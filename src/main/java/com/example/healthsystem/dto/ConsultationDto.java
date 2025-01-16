package com.example.healthsystem.dto;

import com.example.healthsystem.model.Consultation;

public class ConsultationDto {
    String patientEmail;
    String doctorEmail;
    Consultation consultation;

    public ConsultationDto(String patientEmail, String doctorEmail, Consultation consultation) {
        this.patientEmail = patientEmail;
        this.doctorEmail = doctorEmail;
        this.consultation = consultation;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
}
