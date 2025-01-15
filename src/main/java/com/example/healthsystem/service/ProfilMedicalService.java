package com.example.healthsystem.service;

import com.example.healthsystem.model.ProfilMedical;
import com.example.healthsystem.repository.ProfilMedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfilMedicalService {

    private final ProfilMedicalRepository profilMedicalRepository;

    @Autowired
    public ProfilMedicalService(ProfilMedicalRepository profilMedicalRepository) {
        this.profilMedicalRepository = profilMedicalRepository;
    }

    // Create or Update ProfilMedical
    public ProfilMedical saveProfilMedical(ProfilMedical profilMedical) {
        return profilMedicalRepository.save(profilMedical);
    }

    public List<ProfilMedical> getAllProfilMedicals() {
        return profilMedicalRepository.findAll();
    }

    public Optional<ProfilMedical> getProfilMedicalById(Long id) {
        return profilMedicalRepository.findById(id);
    }

    public void deleteProfilMedical(Long id) {
        if (profilMedicalRepository.existsById(id)) {
            profilMedicalRepository.deleteById(id);
        } else {
            throw new RuntimeException("ProfilMedical with ID " + id + " does not exist.");
        }
    }
}
