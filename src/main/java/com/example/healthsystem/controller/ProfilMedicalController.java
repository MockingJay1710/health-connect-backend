package com.example.healthsystem.controller;

import com.example.healthsystem.model.*;
import com.example.healthsystem.service.AllergieService;
import com.example.healthsystem.service.ProfilMedicalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.Name;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profil-medical")
public class ProfilMedicalController {

    private final ProfilMedicalService profilMedicalService;
    private final AllergieService allergieService;

    public ProfilMedicalController(ProfilMedicalService profilMedicalService, AllergieService allergieService) {
        this.profilMedicalService = profilMedicalService;
        this.allergieService = allergieService;
    }

    @PostMapping("/create")
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
    public ResponseEntity<ProfilMedical> getProfilMedicalByMail(@PathVariable String mailPatient) {
        Optional<ProfilMedical> profilMedical = profilMedicalService.getProfilMedicalByMail(mailPatient);
        return profilMedical.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{mailPatient}/allergies")
    public ResponseEntity<List<Allergie>> getAllergiesByEmail(@PathVariable String mailPatient) {
        Optional<ProfilMedical> profilMedical = profilMedicalService.getProfilMedicalByMail(mailPatient);

        return ResponseEntity.ok(profilMedical.get().getAllergies());
    }

    @GetMapping("/{mailPatient}/vaccinations")
    public ResponseEntity<List<Vaccination>> getVaccinationsByEmail(@PathVariable String mailPatient) {
        Optional<ProfilMedical> profilMedical = profilMedicalService.getProfilMedicalByMail(mailPatient);

        return ResponseEntity.ok(profilMedical.get().getVaccinations());
    }

    @GetMapping("/{mailPatient}/antecedants")
    public ResponseEntity<List<AntecedentMedical>> getAntecedansByEmail(@PathVariable String mailPatient) {
        Optional<ProfilMedical> profilMedical = profilMedicalService.getProfilMedicalByMail(mailPatient);

        return ResponseEntity.ok(profilMedical.get().getAntecedentMedicals());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfilMedical(@PathVariable Long id) {
        profilMedicalService.deleteProfilMedical(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{patientMail}/{nameAllergie}/addAllergies")
    public ResponseEntity<Allergie> addAllergie(@PathVariable String patientMail, @PathVariable String nameAllergie) {
        ProfilMedical updatedProfilMedical = profilMedicalService.addAllergieToProfilMedical(patientMail, nameAllergie);

        return ResponseEntity.ok(allergieService.getAllergieDetails(nameAllergie));
    }

    @PostMapping("/{patientMail}/AddVaccination")
    public ResponseEntity<ProfilMedical> addVaccination(@PathVariable String patientMail, @RequestBody Vaccination vaccination) {
        ProfilMedical updatedProfilMedical = profilMedicalService.addVaccinationToProfilMedical(patientMail, vaccination);
        return ResponseEntity.ok(updatedProfilMedical);
    }

    @PostMapping("/{patientMail}/AddResultatExamen")
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
