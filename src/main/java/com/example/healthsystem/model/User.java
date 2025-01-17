package com.example.healthsystem.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


import com.example.healthsystem.model.ProfilMedical;
import com.example.healthsystem.model.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
@Inheritance (strategy = InheritanceType.JOINED)
public class User implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "phone_number")
  private String phone_number;
  @Column (name ="user_type")
  @Enumerated(EnumType.STRING)
  private UserType user_type;
  @Column (name ="date_Naissance")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dateNaissance;


  public User(Long id, String name, String email, String phone_number, UserType userType,LocalDate dateNaissance) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone_number = phone_number;
    this.user_type = userType;
    this.dateNaissance = dateNaissance ;
  }

  public User() {}


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone_number() {
    return phone_number;
  }

  public void setPhone_number(String phone_number) {
    this.phone_number = phone_number;
  }

  public LocalDate getDateNaissance() {
    return dateNaissance;
  }

  public void setDateNaissance(LocalDate dateNaissance) {
    this.dateNaissance = dateNaissance;
  }

  public UserType getUser_type() {
    return user_type;
  }

  public void setUser_type(UserType user_type) {
    this.user_type = user_type;
  }
}
