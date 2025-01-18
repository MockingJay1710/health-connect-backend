package com.example.healthsystem.repository;

import com.example.healthsystem.model.Allergie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AllergieRepository extends JpaRepository<Allergie, Long> {
}
