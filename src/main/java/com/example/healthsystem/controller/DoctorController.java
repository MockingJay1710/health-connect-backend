package com.example.healthsystem.controller;

import com.example.healthsystem.model.Docteur;
import com.example.healthsystem.service.DocteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")  // Defines the base path for the controller
public class DoctorController {

    private final DocteurService doctorService;

    @Autowired
    public DoctorController(DocteurService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/allDoctors")
    public List<Docteur> getDoctors() {
        return doctorService.getDoctors();
    }

    @GetMapping("/{specialite}")
    public List<Docteur> getDoctorsBySpeciality(@PathVariable String specialite) {
        return doctorService.getDoctorsBySpeciality(specialite);
    }

    @PostMapping("/save")
    public Docteur addDoctor(@RequestBody Docteur doctor) {
        return doctorService.saveDocteur(doctor);
    }
}
