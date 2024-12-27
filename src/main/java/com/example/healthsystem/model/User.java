package com.example.healthsystem.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "Type")
@Table(name = "users")
public class User {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "password")
  private String password;

  @Column(name = "phone_number")
  private String phone_number;

  @Enumerated(EnumType.STRING)
  @Column(name = "user_type", nullable = false)
  private UserType user_type;

  @OneToOne(mappedBy = "user")
  private ProfilMedical profilMedical;

  public User(){

  }

  public User(String name, String password, String phone_number, UserType user_type) {
    this.name = name;
    this.password = password;
    this.phone_number = phone_number;
    this.user_type = user_type;
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


}