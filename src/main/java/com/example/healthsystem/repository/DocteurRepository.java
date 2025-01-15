package com.example.healthsystem.repository;

import com.example.healthsystem.model.Docteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocteurRepository extends JpaRepository<Docteur, Long> {

    List<Docteur> findBySpecialiteDocteur(String specialiteDocteur);

    List<Docteur> findAll();
}
