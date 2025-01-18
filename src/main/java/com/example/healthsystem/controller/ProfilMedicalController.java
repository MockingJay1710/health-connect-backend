package com.example.healthsystem.controller;

import com.example.healthsystem.model.*;
import com.example.healthsystem.service.ProfilMedicalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profil-medical")
public class ProfilMedicalController {

    private final ProfilMedicalService profilMedicalService;

    public ProfilMedicalController(ProfilMedicalService profilMedicalService) {
        this.profilMedicalService = profilMedicalService;
    }

    @PostMapping
    public ResponseEntity<ProfilMedical> createProfilMedical(@RequestBody ProfilMedical profilMedical) {
        ProfilMedical savedProfilMedical = profilMedicalService.saveProfilMedical(profilMedical);
        return ResponseEntity.ok(savedProfilMedical);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProfilMedical>> getAllProfilMedicals() {
        List<ProfilMedical> profilMedicals = profilMedicalService.getAllProfilMedicals();
        return ResponseEntity.ok(profilMedicals);
    }

    @GetMapping("/{mailPatient}")
    public ResponseEntity<ProfilMedical> getProfilMedicalById(@PathVariable String mailPatient) {
        Optional<ProfilMedical> profilMedical = profilMedicalService.getProfilMedicalById(mailPatient);
        return profilMedical.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfilMedical(@PathVariable Long id) {
        profilMedicalService.deleteProfilMedical(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{mailPatient}/addAllergies")
    public ResponseEntity<ProfilMedical> addAllergie(@PathVariable String patientMail, @RequestBody Allergie allergie) {
        ProfilMedical updatedProfilMedical = profilMedicalService.addAllergieToProfilMedical(patientMail, allergie);
        return ResponseEntity.ok(updatedProfilMedical);
    }

    @PostMapping("/{mailPatient}/AddVaccination")
    public ResponseEntity<ProfilMedical> addVaccination(@PathVariable String patientMail, @RequestBody Vaccination vaccination) {
        ProfilMedical updatedProfilMedical = profilMedicalService.addVaccinationToProfilMedical(patientMail, vaccination);
        return ResponseEntity.ok(updatedProfilMedical);
    }

    @PostMapping("/{mailPatient}/AddResultatExamen")
    public ResponseEntity<ProfilMedical> addResultatExamen(@PathVariable String patientMail, @RequestBody ResultatExamen resultatExamen) {
        ProfilMedical updatedProfilMedical = profilMedicalService.addResultatExamenToProfilMedical(patientMail, resultatExamen);
        return ResponseEntity.ok(updatedProfilMedical);
    }

    @PostMapping("/{mailPatient}/AddAntecedant")
    public ResponseEntity<ProfilMedical> addAntecedantMedical(@PathVariable String patientMail, @RequestBody AntecedentMedical antecedentMedical) {
        ProfilMedical updatedProfilMedical = profilMedicalService.addAntecedentMedicalToProfilMedical(patientMail, antecedentMedical);
        return ResponseEntity.ok(updatedProfilMedical);
    }


}
