package com.example.healthsystem.repository;

import com.example.healthsystem.model.Allergie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergieRepository extends JpaRepository<Allergie, Long> {
}
