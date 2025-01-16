package com.example.healthsystem.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "Consultations")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column (nullable = false, updatable = true)
    private LocalDate date ;
    @Column (nullable = false, updatable = true)
    private LocalTime time ;
    private  String notesConsultation ;
    private  String etatConsultation ;

    @ManyToOne (fetch = FetchType.LAZY)
    private Docteur docteurService;

    @ManyToOne (fetch = FetchType.LAZY)
    private Patient patientService;


    public Consultation(Long id, LocalDate date, String notesConsultation, String etatConsultation) {
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

    public String getNotesConsultation() {
        return notesConsultation;
    }

    public void setNotesConsultation(String notesConsultation) {
        this.notesConsultation = notesConsultation;
    }

    public String getEtatConsultation() {
        return etatConsultation;
    }

    public void setEtatConsultation(String etatConsultation) {
        this.etatConsultation = etatConsultation;
    }

    public User getDocteurService() {
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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}