package com.example.healthsystem.service;

import com.example.healthsystem.model.Allergie;
import com.example.healthsystem.model.Severity;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

@Service
public class AllergieService {

    private static final Map<String, Allergie> allergieMap = new HashMap<>();

    static {
        allergieMap.put("Pollen", new Allergie("Pollen", Severity.Medium, "Éternuements, Nez qui coule", "Antihistaminiques"));
        allergieMap.put("Poussière", new Allergie("Poussière", Severity.Low, "Toux, Yeux qui piquent", "Environnement propre, Antihistaminiques"));
        allergieMap.put("Arachides", new Allergie("Arachides", Severity.High, "Urticaire, Anaphylaxie", "Épinéphrine"));
        allergieMap.put("Poisson", new Allergie("Poisson", Severity.High, "Démangeaisons, Anaphylaxie", "Épinéphrine, Antihistaminiques"));
        allergieMap.put("Lait", new Allergie("Lait", Severity.Medium, "Douleurs abdominales, Nausées", "Éviter les produits laitiers, Lactase"));
        allergieMap.put("Œufs", new Allergie("Œufs", Severity.Medium, "Urticaire, Vomissements", "Éviter les œufs, Antihistaminiques"));
        allergieMap.put("Fruits de mer", new Allergie("Fruits de mer", Severity.High, "Gonflement, Difficultés respiratoires", "Épinéphrine"));
        allergieMap.put("Pollen d'arbres", new Allergie("Pollen d'arbres", Severity.Medium, "Éternuements, Démangeaisons", "Antihistaminiques, Décongestionnants"));
        allergieMap.put("Poils d'animaux", new Allergie("Poils d'animaux", Severity.Medium, "Yeux rouges, Éternuements", "Antihistaminiques, Environnement propre"));
        allergieMap.put("Gluten", new Allergie("Gluten", Severity.High, "Douleurs abdominales, Fatigue", "Régime sans gluten"));
    }


    public Allergie getAllergieDetails(String nomAllergie) {
        return allergieMap.getOrDefault(nomAllergie, null);
    }
}

