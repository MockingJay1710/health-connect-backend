package com.example.healthsystem.model;

import jakarta.persistence.*;

@Entity
public class ResultatExamen {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String notesDoctor;

    @ManyToOne
    private ProfilMedical profilMedical ;

    @OneToOne
    private Consultation consultation;

    public ResultatExamen() {
    }

    public ResultatExamen(Long id, String remarques) {
        this.id = id;
        this.notesDoctor = remarques;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotesDoctor() {
        return notesDoctor;
    }

    public void setNotesDoctor(String remarques) {
        this.notesDoctor = remarques;
    }

    public ProfilMedical getProfilMedical() {
        return profilMedical;
    }

    public void setProfilMedical(ProfilMedical profilMedical) {
        this.profilMedical = profilMedical;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
}
