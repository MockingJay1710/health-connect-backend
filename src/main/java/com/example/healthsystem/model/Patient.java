package com.example.healthsystem.model;

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
    private Date dateNaissance;

    @OneToOne
    private ProfilMedical profilMedical ;
    @OneToMany
    private List<Consultation> consultations = new ArrayList<>();

    public Patient(){

    }

    public Patient(String name, String password, String phone_number, UserType user_type,String numTel, Date dateNaissance) {
        super(name, password, phone_number, user_type);
        this.dateNaissance = dateNaissance;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
