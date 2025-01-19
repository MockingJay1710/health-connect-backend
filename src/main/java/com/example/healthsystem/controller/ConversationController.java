package com.example.healthsystem.controller;

import com.example.healthsystem.model.ChatMessage;
import com.example.healthsystem.model.Conversation;
import com.example.healthsystem.model.ConversationId;
import com.example.healthsystem.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/conversations")
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @GetMapping("/{email}")
    public List<Conversation> getConversationsByMail(@PathVariable String email) {
        return conversationService.getConversationsByMail(email);
    }

    @PostMapping("/save")
    public Conversation saveConversation(@RequestBody Conversation conversation) {
        return conversationService.saveConversation(conversation);
    }

    @GetMapping("/{receiverMail}/{senderMail}/messages")
    public List<ChatMessage> getMessagesById(@PathVariable String receiverMail,@PathVariable String senderMail) {
        ConversationId conversationId = new ConversationId();
        conversationId.setReceiverEmail(receiverMail);
        conversationId.setSenderEmail(senderMail);
        return conversationService.getMessagesById(conversationId);
    }

    @PostMapping("/{mailReceiver}/{mailSender}/addMessage")
    public Conversation addMessageToConversation(
            @PathVariable String mailSender,
            @PathVariable String mailReceiver,
            @RequestBody ChatMessage chatMessage) {
        return conversationService.addMessageToConversation(mailReceiver, mailSender, chatMessage);
    }



}
