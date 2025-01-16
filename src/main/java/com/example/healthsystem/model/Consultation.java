package com.example.healthsystem.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Consultations")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column (nullable = false, updatable = false)
    private  Date date ;
    private  String notesConsultation ;
    private  EtatConsultation etatConsultation ;

    @ManyToOne (fetch = FetchType.LAZY)
    private Docteur docteurService;

    @ManyToOne (fetch = FetchType.LAZY)
    private Patient patientService;

    @ManyToOne
    @JoinColumn (name = "profilMed_id")
    private ProfilMedical profilMedical;

    public Consultation(Long id, Date date, String notesConsultation, EtatConsultation etatConsultation) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotesConsultation() {
        return notesConsultation;
    }

    public void setNotesConsultation(String notesConsultation) {
        this.notesConsultation = notesConsultation;
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

    public ProfilMedical getProfilMedical() {
        return profilMedical;
    }

    public void setProfilMedical(ProfilMedical profilMedical) {
        this.profilMedical = profilMedical;
    }

    public EtatConsultation getEtatConsultation() {
        return etatConsultation;
    }

    public void setEtatConsultation(EtatConsultation etatConsultation) {
        this.etatConsultation = etatConsultation;
    }
}
