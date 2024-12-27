package com.example.healthsystem.repository;

import com.example.healthsystem.model.Docteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocteurRepository extends JpaRepository<Docteur, Integer> {
    @Query("SELECT u FROM User u WHERE u.user_type = 'DOCTOR'")
    List<Docteur> getAllDoctors();

    List<Docteur> findBySpecialiteDocteur(String specialiteDocteur);
}
