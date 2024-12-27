package com.example.healthsystem.service;

import com.example.healthsystem.model.Docteur;
import com.example.healthsystem.model.User;
import com.example.healthsystem.repository.DocteurRepository;
import com.example.healthsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private final DocteurRepository docteurRepository;

    public DoctorService(DocteurRepository docteurRepository) {
        this.docteurRepository = docteurRepository;
    }

    public List<Docteur> getDoctors() { return docteurRepository.getAllDoctors(); }
    public List<Docteur> getDoctorsBySpeciality(String speciality) { return docteurRepository.findBySpecialiteDocteur(speciality); }
}
