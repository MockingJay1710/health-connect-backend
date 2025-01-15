package com.example.healthsystem.controller;

import com.example.healthsystem.model.Consultation;
import com.example.healthsystem.service.ConsultationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultation")
public class ConsultationController {

    private final ConsultationService consultationService;
    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @PostMapping("/create/{email}")
    public Consultation createConsultation(@RequestBody Consultation consultation,@PathVariable String email) {
        return this.consultationService.createConsultation(consultation, email);
    }
    @GetMapping("/consultations/patient/{email}")
    public List<Consultation> getConsultationByEmailPatient(@PathVariable String email) {
        return this.consultationService.findByEmailPatient(email);
    }

    @GetMapping("/consultations/doctor/{email}")
    public List<Consultation> getConsultationByEmailDoctor(@PathVariable String email) {
        return this.consultationService.findByEmailDocteur(email);
    }
}
