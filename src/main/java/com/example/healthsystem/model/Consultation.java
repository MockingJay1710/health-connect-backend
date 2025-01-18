package com.example.healthsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "Consultations")
public class Consultation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column (nullable = false, updatable = true)
    private LocalDate date ;
    @Column (nullable = false, updatable = true)
    private LocalTime time ;
    private  String notesConsultation ;
    @Enumerated(EnumType.STRING)
    private  EtatConsultation etatConsultation ;

    @ManyToOne (fetch = FetchType.EAGER)
    private Docteur docteurService;

    @ManyToOne (fetch = FetchType.EAGER)
    private Patient patientService;


    public Consultation(Long id, LocalDate date, String notesConsultation, EtatConsultation etatConsultation) {
        this.id = id;
        this.date = date;
        this.notesConsultation = notesConsultation;
        this.etatConsultation = etatConsultation;
    }

    public Consultation() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getNotesConsultation() {
        return notesConsultation;
    }

    public void setNotesConsultation(String notesConsultation) {
        this.notesConsultation = notesConsultation;
    }


    public Docteur getDocteurService() {
        return docteurService;
    }

    public void setDocteurService(Docteur docteurService) {
        this.docteurService = docteurService;
    }

    public Patient getPatientService() {
        return patientService;
    }

    public void setPatientService(Patient patientService) {
        this.patientService = patientService;
    }


    public EtatConsultation getEtatConsultation() {
        return etatConsultation;
    }

    public void setEtatConsultation(EtatConsultation etatConsultation) {
        this.etatConsultation = etatConsultation;
    }
}