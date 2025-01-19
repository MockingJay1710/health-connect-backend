package com.example.healthsystem.dto;

public class ChatMessageDTO {
    private String content;
    private String senderMail;
    private String recepientmail;

    private Boolean isR;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSenderMail() {
        return senderMail;
    }

    public void setSenderMail(String senderMail) {
        this.senderMail = senderMail;
    }

    public String getRecepientmail() {
        return recepientmail;
    }

    public void setRecepientmail(String recepientmail) {
        this.recepientmail = recepientmail;
    }
}
