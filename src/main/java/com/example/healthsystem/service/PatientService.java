package com.example.healthsystem.service;

import com.example.healthsystem.model.Patient;
import com.example.healthsystem.model.Consultation;
import com.example.healthsystem.repository.PatientRepository;
import com.example.healthsystem.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final ConsultationRepository consultationRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.consultationRepository = consultationRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
        } else {
            throw new RuntimeException("Patient with ID " + id + " does not exist.");
        }
    }

    public List<Consultation> getConsultationsByPatient(Long patientId) {
        Optional<Patient> patientOpt = patientRepository.findById(patientId);
        if (patientOpt.isPresent()) {
            return patientOpt.get().getConsultations();
        } else {
            throw new RuntimeException("Patient with ID " + patientId + " does not exist.");
        }
    }

    public Consultation addConsultation(Long patientId, Consultation consultation) {
        Optional<Patient> patientOpt = patientRepository.findById(patientId);
        if (patientOpt.isPresent()) {
            Patient patient = patientOpt.get();
            consultation.setPatientService(patient);
            return consultationRepository.save(consultation);
        } else {
            throw new RuntimeException("Patient with ID " + patientId + " does not exist.");
        }
    }

    public void removeConsultation(Long consultationId) {
        if (consultationRepository.existsById(consultationId)) {
            consultationRepository.deleteById(consultationId);
        } else {
            throw new RuntimeException("Consultation with ID " + consultationId + " does not exist.");
        }
    }
}

