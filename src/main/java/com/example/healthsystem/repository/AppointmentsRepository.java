package com.example.healthsystem.repository;

import com.example.healthsystem.model.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentsRepository extends JpaRepository<Appointments, Long> {

}
