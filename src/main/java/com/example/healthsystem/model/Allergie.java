package com.example.healthsystem.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Allergie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomAllergie;
    private Severity severity;
    private String symptomes;
    private String treatement;

    @ManyToOne
    private ProfilMedical profilMedical ;

    public Allergie() {
    }

    public Allergie(Long id, String nomAllergie, String symptomes) {
        this.id = id;
        this.nomAllergie = nomAllergie;
        this.symptomes = symptomes;
      }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomAllergie() {
        return nomAllergie;
    }

    public void setNomAllergie(String nomAllergie) {
        this.nomAllergie = nomAllergie;
    }

    public String getSymptomes() {
        return symptomes;
    }

    public void setSymptomes(String symptomes) {
        this.symptomes = symptomes;
    }

    public ProfilMedical getProfilMedical() {
        return profilMedical;
    }

    public void setProfilMedical(ProfilMedical profilMedical) {
        this.profilMedical = profilMedical;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public String getTreatement() {
        return treatement;
    }

    public void setTreatement(String treatement) {
        this.treatement = treatement;
    }
}
