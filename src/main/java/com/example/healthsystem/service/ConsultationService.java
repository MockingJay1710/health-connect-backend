package com.example.healthsystem.service;

import com.example.healthsystem.model.Consultation;
import com.example.healthsystem.model.Docteur;
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

    public Consultation createConsultation(Consultation consultation, String patientEmail,String docteurEmail) {
        User patientUser = this.userService.findByEmail(patientEmail);
        User docteurUser = this.userService.findByEmail(docteurEmail);

        if (!(patientUser instanceof Patient)) {
            throw new IllegalArgumentException("User with email " + patientEmail + " is not a patient.");
        }
        if(!(docteurUser instanceof Docteur)){
            throw new IllegalArgumentException("User with email " + docteurEmail + " is not a docteur.");
        }

        Patient patient = (Patient) patientUser;
        Docteur docteur = (Docteur) docteurUser;
        patient.add(consultation);
        consultation.setPatientService(patient);
        docteur.add(consultation);
        consultation.setDocteurService(docteur);
        return this.consultationRepository.save(consultation);
    }
}
