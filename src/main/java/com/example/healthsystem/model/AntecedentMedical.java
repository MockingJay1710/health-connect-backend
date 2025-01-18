package com.example.healthsystem.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class AntecedentMedical {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;
    private Date dateDiagnostic;
    private Severity severity;
    private String treatement;

    @ManyToOne
    private ProfilMedical profilMedical;

    public AntecedentMedical() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateDiagnostic() {
        return dateDiagnostic;
    }

    public void setDateDiagnostic(Date dateDiagnostic) {
        this.dateDiagnostic = dateDiagnostic;
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

    public ProfilMedical getProfilMedical() {
        return profilMedical;
    }

    public void setProfilMedical(ProfilMedical profilMedical) {
        this.profilMedical = profilMedical;
    }
}
