package com.example.healthsystem.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Vaccination {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String vaccineName;
    private LocalDate vaccineDate;
    private String vaccineType;
    private LocalDate nextDue;

    @ManyToOne
    private ProfilMedical profilMedical ;

    public Vaccination() {

    }

    public Vaccination(Long id, String vaccineName, String vaccineType, LocalDate vaccineDate) {
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

    public LocalDate getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(LocalDate vaccineDate) {
        this.vaccineDate = vaccineDate;
    }

    public ProfilMedical getProfilMedical() {
        return profilMedical;
    }

    public void setProfilMedical(ProfilMedical profilMedical) {
        this.profilMedical = profilMedical;
    }

    public LocalDate getNextDue() {
        return nextDue;
    }

    public void setNextDue(LocalDate
                                   nextDue) {
        this.nextDue = nextDue;
    }
}
