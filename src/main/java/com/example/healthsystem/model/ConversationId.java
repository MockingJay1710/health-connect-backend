package com.example.healthsystem.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ConversationId implements Serializable {
    private String  receiverEmail;
    private String  senderEmail;

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }
}
