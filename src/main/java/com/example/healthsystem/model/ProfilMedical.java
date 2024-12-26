package com.example.healthsystem.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "profil_Medical")

public class ProfilMedical {
    @Id
    private Long id ;


  @OneToOne
  @JoinColumn(name = "allergie")
   private Allergie allergie;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

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
