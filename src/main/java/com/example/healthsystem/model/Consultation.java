package com.example.healthsystem.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "appointments")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column (nullable = false, updatable = false)
    private  Date date ;
    private  String notesConsultation ;
    private  String etatConsultation ;

    @ManyToOne (fetch = FetchType.LAZY)
    private User docteurService;

    @ManyToOne (fetch = FetchType.LAZY)
    private Patient patientService;

    @ManyToOne
    @JoinColumn (name = "profilMed_id")
    private ProfilMedical profilMedical;






}
