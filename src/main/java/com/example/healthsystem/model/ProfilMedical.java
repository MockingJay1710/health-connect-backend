package com.example.healthsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ProfilMedical {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String contactUrgence ;


    @OneToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnore
    private Patient patient;

    @ManyToMany (fetch = FetchType.EAGER )
    private List<Allergie> allergies = new ArrayList<>();
    @ManyToMany (fetch = FetchType.EAGER )
    private List<Vaccination> vaccinations = new ArrayList<>();
    @ManyToMany (fetch = FetchType.EAGER )
    private List<ResultatExamen> resultatsExamen = new ArrayList<>();
    @ManyToMany (fetch = FetchType.EAGER )
    private List<AntecedentMedical> antecedentMedicals  = new ArrayList<>();




    public ProfilMedical(Long id, String contactUrgence, Patient patient) {
        this.id = id;
        this.contactUrgence = contactUrgence;
        this.patient = patient;
    }
    public ProfilMedical() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactUrgence() {
        return contactUrgence;
    }

    public void setContactUrgence(String contactUrgence) {
        this.contactUrgence = contactUrgence;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Allergie> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<Allergie> allergies) {
        this.allergies = allergies;
    }

    public List<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(List<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }

    public List<ResultatExamen> getResultatsExamen() {
        return resultatsExamen;
    }

    public void setResultatsExamen(List<ResultatExamen> resultatsExamen) {
        this.resultatsExamen = resultatsExamen;
    }

    public List<AntecedentMedical> getAntecedentMedicals() {
        return antecedentMedicals;
    }

    public void setAntecedentMedicals(List<AntecedentMedical> antecedentMedicals) {
        this.antecedentMedicals = antecedentMedicals;
    }
}
