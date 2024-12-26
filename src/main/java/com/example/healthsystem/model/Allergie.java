package com.example.healthsystem.model;


import com.example.healthsystem.service.Severity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Allergie {
        private String allergern;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Severity severity;
        @Transient

        private List<String> symptomps = new ArrayList<>();
        @ManyToOne
@JoinColumn(name = "profil_id")
        private ProfilMedical profilMedical;
        @Transient
        private List<String> notes = new ArrayList<>();

    public String getAllergern() {
        return allergern;
    }

    public void setAllergern(String allergern) {
        this.allergern = allergern;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public List<String> getSymptomps() {
        return symptomps;
    }

    public void setSymptomps(List<String> symptomps) {
        this.symptomps = symptomps;
    }
}
