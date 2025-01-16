package com.example.healthsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue(value = "PAT")
public class Patient extends User{

    @OneToOne (mappedBy = "patient")
    private ProfilMedical profilMedical ;
    @OneToMany (mappedBy = "patientService")
    @JsonIgnore
    private List<Consultation> consultations = new ArrayList<>();


    public Patient(){}



    public ProfilMedical getProfilMedical() {
        return profilMedical;
    }

    public void setProfilMedical(ProfilMedical profilMedical) {
        this.profilMedical = profilMedical;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public boolean isEmpty() {
        return consultations.isEmpty();
    }

    public boolean contains(Object o) {
        return consultations.contains(o);
    }

    public boolean add(Consultation consultation) {
        return consultations.add(consultation);
    }
}
