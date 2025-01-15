package com.example.healthsystem.service;

import com.example.healthsystem.model.Consultation;
import com.example.healthsystem.model.Patient;
import com.example.healthsystem.model.User;
import com.example.healthsystem.repository.ConsultationRepository;
import org.springframework.stereotype.Service;

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

    public List<Consultation> findByEmailPatient(String email) {
        return this.consultationRepository.findByPatientEmail(email);
    }

    public List<Consultation> findByEmailDocteur(String email) {
        return this.consultationRepository.findByDocteurEmail(email);
    }

    public Consultation createConsultation(Consultation consultation, String email) {
        User user = this.userService.findByEmail(email);

        if (!(user instanceof Patient)) {
            throw new IllegalArgumentException("User with email " + email + " is not a patient.");
        }

        Patient patient = (Patient) user;
        patient.add(consultation);
        consultation.setPatientService(patient);

        return this.consultationRepository.save(consultation);
    }
}
