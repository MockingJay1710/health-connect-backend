package com.example.healthsystem.repository;

import com.example.healthsystem.model.Consultation;
import com.example.healthsystem.model.EtatConsultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    @Query("SELECT c FROM Consultation c WHERE c.docteurService.email = :email")
    List<Consultation> findByDocteurEmail(@Param("email") String email);

    @Query("SELECT c FROM Consultation c JOIN c.patientService d WHERE d.email = :email")
    List<Consultation> findByPatientEmail(@Param("email") String email);

    @Query("SELECT c FROM Consultation c JOIN c.patientService d WHERE d.email = :email and c.etatConsultation = :status")
    List<Consultation> findByPatientEmailAndStatus(@Param("email") String email, @Param("status") EtatConsultation status);
}
