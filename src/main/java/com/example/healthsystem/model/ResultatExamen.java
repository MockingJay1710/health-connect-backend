package com.example.healthsystem.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class ResultatExamen {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String remarques  ;

    @OneToOne
    private Consultation consultation;

    public ResultatExamen() {
    }

    public ResultatExamen(Long id, String remarques) {
        this.id = id;
        this.remarques = remarques;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }
}
