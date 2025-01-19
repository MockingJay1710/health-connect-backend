package com.example.healthsystem.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Conversation {
    @EmbeddedId
    private ConversationId id;

    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<ChatMessage> messages = new ArrayList<>();

    public ConversationId getId() {
        return id;
    }

    public void setId(ConversationId id) {
        this.id = id;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }
}
