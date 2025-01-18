package com.example.healthsystem.controller;

import com.example.healthsystem.dto.ConsultationDto;
import com.example.healthsystem.model.Consultation;
import com.example.healthsystem.model.Docteur;
import com.example.healthsystem.model.EtatConsultation;
import com.example.healthsystem.repository.ConsultationRepository;
import com.example.healthsystem.repository.DocteurRepository;
import com.example.healthsystem.service.ConsultationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/consultation")
public class ConsultationController {

    private final ConsultationService consultationService;
    private final ConsultationRepository consultationRepository;
    private final DocteurRepository docteurRepository;

    public ConsultationController(ConsultationService consultationService, ConsultationRepository consultationRepository, DocteurRepository docteurRepository) {
        this.consultationService = consultationService;
        this.consultationRepository = consultationRepository;
        this.docteurRepository = docteurRepository;
    }

    @GetMapping("/all")
    public List<Consultation> getAllConsultation() {
        return this.consultationService.getAllConsultations();
    }

    @PostMapping("/create")
    public Consultation createConsultation(@RequestBody ConsultationDto consultation) {
        return this.consultationService.createConsultation(consultation);
    }

    @GetMapping("/consultations/patient/{email}")
    public List<Consultation> getConsultationByEmailPatient(@PathVariable String email) {
        return this.consultationService.findByEmailPatient(email);
    }

    @GetMapping("/consultations/patient/{email}/{status}")
    public List<Consultation> getConsultationByEmailPatientAndStatus(@PathVariable String email, @PathVariable EtatConsultation status) {
        return this.consultationService.findByEmailPatientAndStatus(email, status);
    }

    @GetMapping("/consultations/doctor/{email}")
    public List<Consultation> getConsultationByEmailDoctor(@PathVariable String email) {
        return this.consultationService.findByEmailDocteur(email);
    }

    @GetMapping("/consultations/doctor/{email}/{status}")
    public List<Consultation> getConsultationByEmailDocteurAndStatus(@PathVariable String email, @PathVariable EtatConsultation status) {
        return this.consultationService.findByEmailDocteurAndStatus(email, status);
    }

    @PatchMapping("/change_status/id/{id}/status/{status}")
    public void alterConsultationStatus(@PathVariable Long id, @PathVariable EtatConsultation status) {
        this.consultationService.changeStatus(id, status);
    }

    @PatchMapping("/cancel/{id}")
    public void cancelConsultation(@PathVariable Long id) {
        this.consultationService.changeStatus(id, EtatConsultation.Canceled);
    }

    @PatchMapping("/accept/{id}")
    public void acceptConsultation(@PathVariable Long id) {
        Consultation consultation = consultationRepository.findById(id).orElse(null);
        Docteur docteur =  consultation.getDocteurService();
        docteur.addPatient(consultation.getPatientService());
        docteurRepository.save(docteur);

        this.consultationService.changeStatus(id, EtatConsultation.Completed);

    }

    @PutMapping("/reschedule/{date}/{time}/{id}")
    public void rescheduleConsultation(@PathVariable Long id, @PathVariable LocalDate date, @PathVariable LocalTime time) {
        this.consultationService.rescheduleConsultation(id, date, time);
    }

}