package com.example.healthsystem.repository;

import com.example.healthsystem.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    @Query("SELECT c FROM Consultation c JOIN c.docteurService d WHERE d.email = :email")
    List<Consultation> findByDocteurEmail(@Param("email") String email);

    @Query("SELECT c FROM Consultation c JOIN c.patientService d WHERE d.email = :email")
    List<Consultation> findByPatientEmail(@Param("email") String email);
}
