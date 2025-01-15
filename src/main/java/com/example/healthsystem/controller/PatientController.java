package com.example.healthsystem.controller;

import com.example.healthsystem.model.Patient;
import com.example.healthsystem.model.Consultation;
import com.example.healthsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Optional<Patient> patient = patientService.getPatientById(id);
        return patient.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("save")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        Optional<Patient> existingPatient = patientService.getPatientById(id);
        if (existingPatient.isPresent()) {
            updatedPatient.setId(id);
            return ResponseEntity.ok(patientService.savePatient(updatedPatient));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        if (patientService.getPatientById(id).isPresent()) {
            patientService.deletePatient(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{patientId}/consultations")
    public ResponseEntity<List<Consultation>> getConsultationsByPatient(@PathVariable Long patientId) {
        try {
            List<Consultation> consultations = patientService.getConsultationsByPatient(patientId);
            return ResponseEntity.ok(consultations);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{patientId}/consultations")
    public ResponseEntity<Consultation> addConsultation(@PathVariable Long patientId, @RequestBody Consultation consultation) {
        try {
            Consultation savedConsultation = patientService.addConsultation(patientId, consultation);
            return ResponseEntity.ok(savedConsultation);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/consultations/{consultationId}")
    public ResponseEntity<Void> deleteConsultation(@PathVariable Long consultationId) {
        try {
            patientService.removeConsultation(consultationId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
