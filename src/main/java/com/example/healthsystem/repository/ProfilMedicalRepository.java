package com.example.healthsystem.repository;

import com.example.healthsystem.model.ProfilMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProfilMedicalRepository extends JpaRepository<ProfilMedical, Long> {
    @Query("SELECT p FROM ProfilMedical p JOIN p.patient d WHERE d.email = :email")
    Optional<ProfilMedical> findByPatientEmail(@Param("email") String email);
}
