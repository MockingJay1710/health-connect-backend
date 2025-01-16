package com.example.healthsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@DiscriminatorValue(value = "DOC")
@Entity
public class Docteur extends User{

    @Column(name= "specialite_docteur")
    private String specialiteDocteur;

    @OneToMany (mappedBy = "docteurService")
    @JsonIgnore
    private List<Consultation> consultations= new ArrayList<>();

    public Docteur(){
    }

    public Docteur(Long id, String name, String email, String phone_number, UserType userType, LocalDate dateNaissance, String specialiteDocteur) {
        super(id, name, email, phone_number, userType, dateNaissance);
        this.specialiteDocteur = specialiteDocteur;
    }

    public String getSpecialiteDocteur() {
        return specialiteDocteur;
    }

    public void setSpecialiteDocteur(String specialiteDocteur) {
        this.specialiteDocteur = specialiteDocteur;
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
