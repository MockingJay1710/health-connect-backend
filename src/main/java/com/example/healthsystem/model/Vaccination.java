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
    private LocalDate nextDue;



    public Vaccination() {
    }

    public Vaccination(Long id, String vaccineName, String vaccineType, LocalDate vaccineDate) {
        this.id = id;
        this.vaccineName = vaccineName;
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

    public LocalDate getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(LocalDate vaccineDate) {
        this.vaccineDate = vaccineDate;
    }



    public LocalDate getNextDue() {
        return nextDue;
    }

    public void setNextDue(LocalDate
                                   nextDue) {
        this.nextDue = nextDue;
    }
}
