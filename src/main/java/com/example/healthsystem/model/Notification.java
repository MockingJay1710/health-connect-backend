package com.example.healthsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenuNotif;
    private Date dateEnvoi;

    public Notification() {

    }

    public Notification(String contenuNotif, Date dateEnvoi) {
        this.contenuNotif = contenuNotif;
        this.dateEnvoi = dateEnvoi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenuNotif() {
        return contenuNotif;
    }

    public void setContenuNotif(String contenuNotif) {
        this.contenuNotif = contenuNotif;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }
}
