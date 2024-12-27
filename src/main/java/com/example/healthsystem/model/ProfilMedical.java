package com.example.healthsystem.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "profil_Medical")
public class ProfilMedical {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String contactUrgence ;



    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany
    private List<Allergie> allergies = new ArrayList<>();
    @OneToMany
    private List<Vaccination> vaccinations = new ArrayList<>();
    @OneToMany
    private List<ResultatExamen> resultatsExamen = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
