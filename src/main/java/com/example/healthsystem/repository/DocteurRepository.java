package com.example.healthsystem.repository;

import com.example.healthsystem.model.Docteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocteurRepository extends JpaRepository<Docteur, Integer> {
}
