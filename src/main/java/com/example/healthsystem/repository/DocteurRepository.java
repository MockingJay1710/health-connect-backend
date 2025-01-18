package com.example.healthsystem.repository;

import com.example.healthsystem.model.Docteur;
import com.example.healthsystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

public interface DocteurRepository extends JpaRepository<Docteur, Long> {

    List<Docteur> findBySpecialiteDocteur(String specialiteDocteur);

    List<Docteur> findAll();

    Optional<Docteur> findByEmail(String email);

}
