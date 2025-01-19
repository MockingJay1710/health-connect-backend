package com.example.healthsystem.service;

import com.example.healthsystem.dto.ChatMessageDTO;
import com.example.healthsystem.model.*;
import com.example.healthsystem.repository.ConversationRepository;
import com.example.healthsystem.repository.UserRepository;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ConversationService {
    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Conversation> getConversationsByMail(String mail) {
        User user = userRepository.findByEmail(mail);
        return user.getConversations();
    }

    public Conversation saveConversation(Conversation conversation) {
        conversationRepository.save(conversation);
        User user = userRepository.findByEmail(conversation.getId().getReceiverEmail());
        User user_2 = userRepository.findByEmail(conversation.getId().getSenderEmail());

        user.add(conversation);
        userRepository.save(user);

        user_2.add(conversation);
        userRepository.save(user_2);

        return conversation;
    }

    public List<ChatMessage> getMessagesById(ConversationId id) {
        return conversationRepository.findById(id).get().getMessages();
    }

    public Conversation addMessageToConversation(String mailReceiver, String mailSender, ChatMessage chatMessage) {
        ConversationId conversationId = new ConversationId();
        conversationId.setSenderEmail(mailSender);
        conversationId.setReceiverEmail(mailReceiver);

        Optional<Conversation> optionalConversation = conversationRepository.findById(conversationId);

        if (optionalConversation.isPresent()) {
            Conversation conversation = optionalConversation.get();
            conversation.getMessages().add(chatMessage);
            chatMessage.setChatRoom(conversation);
            return conversationRepository.save(conversation);
        } else {
            // Handle the case where the conversation is not found
            throw new NoSuchElementException("Conversation not found for the given sender and receiver emails.");
        }
    }


}
