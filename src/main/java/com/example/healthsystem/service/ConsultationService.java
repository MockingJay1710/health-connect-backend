package com.example.healthsystem.service;

import com.example.healthsystem.dto.ConsultationDto;
import com.example.healthsystem.model.*;
import com.example.healthsystem.repository.ConsultationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ConsultationService {

    private final ConsultationRepository consultationRepository;
    private final UserService userService;
    public ConsultationService(ConsultationRepository consultationRepository,
                               UserService userService) {
        this.consultationRepository = consultationRepository;
        this.userService= userService;
    }

    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    public List<Consultation> findByEmailPatient(String email) {
        return this.consultationRepository.findByPatientEmail(email);
    }

    public List<Consultation> findByEmailPatientAndStatus(String email,EtatConsultation status) {
        return this.consultationRepository.findByPatientEmailAndStatus(email,status);
    }

    public List<Consultation> findByEmailDocteur(String email) {
        return this.consultationRepository.findByDocteurEmail(email);
    }

    public Consultation createConsultation(ConsultationDto consultationDto) {
        User patientUser = this.userService.findByEmail(consultationDto.getPatientEmail());
        User docteurUser = this.userService.findByEmail(consultationDto.getDoctorEmail());

        if (!(patientUser instanceof Patient)) {
            throw new IllegalArgumentException("User with email " + consultationDto.getPatientEmail() + " is not a patient.");
        }
        if(!(docteurUser instanceof Docteur)){
            throw new IllegalArgumentException("User with email " + consultationDto.getDoctorEmail() + " is not a docteur.");
        }

        Patient patient = (Patient) patientUser;
        Docteur docteur = (Docteur) docteurUser;
        Consultation consultation = consultationDto.getConsultation();
        patient.add(consultation);
        consultation.setPatientService(patient);
        docteur.add(consultation);
        consultation.setDocteurService(docteur);
        return this.consultationRepository.save(consultation);
    }

    public void changeStatus(Long id, EtatConsultation status){
        this.consultationRepository.findById(id).map( consultation -> {
            consultation.setEtatConsultation(status);
            return this.consultationRepository.save(consultation);
        }).orElseThrow(()-> new RuntimeException("Consultation with id " + id + " not found or does not exist."));
    }

    public void rescheduleConsultation(Long id, LocalDate date, LocalTime time){
        this.consultationRepository.findById(id).map( consultation -> {
            consultation.setDate(date);
            consultation.setTime(time);
            return this.consultationRepository.save(consultation);
        }).orElseThrow(()-> new RuntimeException("Consultation with id " + id + " not found or does not exist."));
    }

}
