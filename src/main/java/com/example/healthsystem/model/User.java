package com.example.healthsystem.model;

import java.util.Date;

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

@Entity
@Table(name = "users")
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "phone_number")
  private String phone_number;

  @Enumerated(EnumType.STRING)
  @Column(name = "user_type", nullable = false)
  private UserType user_type;
 
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", updatable = false)
  private Date created_at;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at")
  private Date updated_at;

  @PrePersist
  protected void onCreate() {
    created_at = new Date();
    updated_at = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    updated_at = new Date();
  }

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhoneNumber() {
    return phone_number;
  }

  public void setPhoneNumber(String phone_number) {
    this.phone_number = phone_number;
  }

  public UserType getUserType() {
    return user_type;
  }

  public void setUserType(UserType user_type) {
    this.user_type = user_type;
  }

  public Date getCreatedAt() {
    return created_at;
  }

  public void setCreatedAt(Date created_at) {
    this.created_at = created_at;
  }

  public Date getUpdatedAt() {
    return updated_at;
  }

  public void setUpdatedAt(Date updated_at) {
    this.updated_at = updated_at;
  }
}