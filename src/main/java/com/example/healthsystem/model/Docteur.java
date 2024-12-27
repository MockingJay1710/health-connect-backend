package com.example.healthsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@DiscriminatorValue(value = "DOC")
@Entity
public class Docteur extends User{

    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name= "specialite_docteur")
    private String specialiteDocteur;

    @OneToMany (mappedBy = "docteurService")
    private List<Consultation> consultations= new ArrayList<>();

    public Docteur(){

    }

    public Docteur(String name, String password, String phone_number, UserType user_type,String numTel, String mail,String specialiteDocteur) {
        super(name, password, phone_number, user_type);
        this.email = mail;
        this.specialiteDocteur = specialiteDocteur;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialiteDocteur() {
        return specialiteDocteur;
    }

    public void setSpecialiteDocteur(String specialiteDocteur) {
        this.specialiteDocteur = specialiteDocteur;
    }
}
