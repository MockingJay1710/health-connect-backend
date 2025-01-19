package com.example.healthsystem.service;

import com.example.healthsystem.model.*;
import com.example.healthsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfilMedicalService {

    private final ProfilMedicalRepository profilMedicalRepository;

    @Autowired
    private AllergieService allergieService;

    @Autowired
    private AllergieRepository allergieRepository;

    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Autowired
    private ResultatExamenRepository resultatExamenRepository;
    @Autowired
    private AntecedantMedicalRepository antecedantMedicalRepository;


    @Autowired
    public ProfilMedicalService(ProfilMedicalRepository profilMedicalRepository) {
        this.profilMedicalRepository = profilMedicalRepository;
    }

    public ProfilMedical saveProfilMedical(ProfilMedical profilMedical) {
        return profilMedicalRepository.save(profilMedical);
    }

    public List<ProfilMedical> getAllProfilMedicals() {
        return profilMedicalRepository.findAll();
    }

    public List<ProfilMedical> getAllProfilMedicalsByDoctorMail(String doctorMail) {
        return null ;
    }

    public Optional<ProfilMedical> getProfilMedicalByMail(String mail) {
        return profilMedicalRepository.findByPatientEmail(mail);
    }

    public void deleteProfilMedical(Long id) {
        if (profilMedicalRepository.existsById(id)) {
            profilMedicalRepository.deleteById(id);
        } else {
            throw new RuntimeException("ProfilMedical with ID " + id + " does not exist.");
        }
    }


    public ProfilMedical addAllergieToProfilMedical(String mailPatient, String allergieName) {
        ProfilMedical profilMedical = profilMedicalRepository.findByPatientEmail(mailPatient)
                .orElseThrow(() -> new RuntimeException("ProfilMedical not found"));

        Allergie allergie = allergieService.getAllergieDetails(allergieName);
        if (allergie == null) {
            throw new RuntimeException("Allergie not found for name: " + allergieName);
        }

        profilMedical.getAllergies().add(allergie);
        allergieRepository.save(allergie);
        return profilMedicalRepository.save(profilMedical);
    }


    public ProfilMedical addVaccinationToProfilMedical(String mailPatient, Vaccination vaccination) {
        ProfilMedical profilMedical = profilMedicalRepository.findByPatientEmail(mailPatient)
                .orElseThrow(() -> new RuntimeException("ProfilMedical not found"));
        profilMedical.getVaccinations().add(vaccination);
        vaccinationRepository.save(vaccination);
        return profilMedicalRepository.save(profilMedical);
    }

    public ProfilMedical addResultatExamenToProfilMedical(String mailPatient, ResultatExamen resultatExamen) {
        ProfilMedical profilMedical = profilMedicalRepository.findByPatientEmail(mailPatient)
                .orElseThrow(() -> new RuntimeException("ProfilMedical not found"));
        resultatExamenRepository.save(resultatExamen);
        profilMedical.getResultatsExamen().add(resultatExamen);
        return profilMedicalRepository.save(profilMedical);
    }

    public ProfilMedical addAntecedentMedicalToProfilMedical(String mailPatient, AntecedentMedical antecedentMedical) {
        ProfilMedical profilMedical = profilMedicalRepository.findByPatientEmail(mailPatient)
                .orElseThrow(() -> new RuntimeException("ProfilMedical not found"));
        profilMedical.getAntecedentMedicals().add(antecedentMedical);
        antecedantMedicalRepository.save(antecedentMedical);
        return profilMedicalRepository.save(profilMedical);
    }




}
