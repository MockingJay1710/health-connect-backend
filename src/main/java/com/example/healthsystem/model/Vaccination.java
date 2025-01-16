package com.example.healthsystem.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Vaccination {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String vaccineName;
    private String vaccineType;
    private Date vaccineDate;

    @ManyToOne
    private ProfilMedical profilMedical ;

    public Vaccination() {

    }

    public Vaccination(Long id, String vaccineName, String vaccineType, Date vaccineDate) {
        this.id = id;
        this.vaccineName = vaccineName;
        this.vaccineType = vaccineType;
        this.vaccineDate = vaccineDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public Date getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(Date vaccineDate) {
        this.vaccineDate = vaccineDate;
    }

    public ProfilMedical getProfilMedical() {
        return profilMedical;
    }

    public void setProfilMedical(ProfilMedical profilMedical) {
        this.profilMedical = profilMedical;
    }
}
