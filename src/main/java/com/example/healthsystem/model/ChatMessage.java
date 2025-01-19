package com.example.healthsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ChatMessage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String senderMail;

    private String recipientMail;

    private String content;

    @ManyToOne
    @JsonIgnore
    private Conversation chatRoom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderMail() {
        return senderMail;
    }

    public void setSenderMail(String sender) {
        this.senderMail = sender;
    }

    public String getRecipientMail() {
        return recipientMail;
    }

    public void setRecipientMail(String recipient) {
        this.recipientMail = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Conversation getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(Conversation chatRoom) {
        this.chatRoom = chatRoom;
    }
}
