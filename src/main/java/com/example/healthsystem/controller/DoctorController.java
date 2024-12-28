package com.example.healthsystem.controller;

import com.example.healthsystem.model.Docteur;
import com.example.healthsystem.service.DocteurService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.print.Doc;
import java.util.List;

@Controller
public class DoctorController {
    @Autowired
    private final DocteurService doctorService;

    public DoctorController(DocteurService doctorService) {
        this.doctorService = doctorService;
    }


    @GetMapping("/doctors")
    public List<Docteur> getDoctors() {
        List<Docteur> response = doctorService.getDoctors();
        return response;
    }

    @GetMapping("/doctors/{speciality}")
    public List<Docteur> getDoctorsBySpeciality(@PathVariable(value="speciality") String speciality) {
        List<Docteur> response = doctorService.getDoctorsBySpeciality(speciality);
        return response;
    }
}
