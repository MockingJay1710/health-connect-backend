package com.example.healthsystem.service;

import com.example.healthsystem.model.Allergie;
import com.example.healthsystem.model.ProfilMedical;
import com.example.healthsystem.model.ResultatExamen;
import com.example.healthsystem.model.Vaccination;
import com.example.healthsystem.repository.AllergieRepository;
import com.example.healthsystem.repository.ProfilMedicalRepository;
import com.example.healthsystem.repository.ResultatExamenRepository;
import com.example.healthsystem.repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfilMedicalService {

    private final ProfilMedicalRepository profilMedicalRepository;

    @Autowired
    private AllergieRepository allergieRepository;

    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Autowired
    private ResultatExamenRepository resultatExamenRepository;


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

    public Optional<ProfilMedical> getProfilMedicalById(String mail) {
        return profilMedicalRepository.findByPatientEmail(mail);
    }

    public void deleteProfilMedical(Long id) {
        if (profilMedicalRepository.existsById(id)) {
            profilMedicalRepository.deleteById(id);
        } else {
            throw new RuntimeException("ProfilMedical with ID " + id + " does not exist.");
        }
    }


    public ProfilMedical addAllergieToProfilMedical(String mailPatient, Allergie allergie) {
        ProfilMedical profilMedical = profilMedicalRepository.findByPatientEmail(mailPatient)
                .orElseThrow(() -> new RuntimeException("ProfilMedical not found"));
        allergie.setProfilMedical(profilMedical);
        profilMedical.getAllergies().add(allergie);
        allergieRepository.save(allergie);
        profilMedical.getAllergies().add(allergie);
        return profilMedicalRepository.save(profilMedical);
    }

    public ProfilMedical addVaccinationToProfilMedical(String mailPatient, Vaccination vaccination) {
        ProfilMedical profilMedical = profilMedicalRepository.findByPatientEmail(mailPatient)
                .orElseThrow(() -> new RuntimeException("ProfilMedical not found"));
        vaccination.setProfilMedical(profilMedical);
        profilMedical.getVaccinations().add(vaccination);
        vaccinationRepository.save(vaccination);
        profilMedical.getVaccinations().add(vaccination);
        return profilMedicalRepository.save(profilMedical);
    }

    public ProfilMedical addResultatExamenToProfilMedical(String mailPatient, ResultatExamen resultatExamen) {
        ProfilMedical profilMedical = profilMedicalRepository.findByPatientEmail(mailPatient)
                .orElseThrow(() -> new RuntimeException("ProfilMedical not found"));
        resultatExamen.setProfilMedical(profilMedical);
        profilMedical.getResultatsExamen().add(resultatExamen);
        resultatExamenRepository.save(resultatExamen);
        profilMedical.getResultatsExamen().add(resultatExamen);
        return profilMedicalRepository.save(profilMedical);
    }




}
