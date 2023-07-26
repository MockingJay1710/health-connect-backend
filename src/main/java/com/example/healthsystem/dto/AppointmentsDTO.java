package com.example.healthsystem.dto;

import com.example.healthsystem.model.Appointments;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentsDTO {
    private Long id;
    private Long serviceProviderId;
    private Long patientId;
    private LocalDateTime date;
    private Boolean reservation;
    private Date created_at;


    public AppointmentsDTO() {

    }

    public Map<String, Object> getServiceProviderScheduleDTOResponse(Appointments appointments) {
        Map<String, Object> serviceProvider = new HashMap<>();
        serviceProvider.put("id", appointments.getServiceProviderId().getId());
        serviceProvider.put("name", appointments.getServiceProviderId().getName());
        serviceProvider.put("email", appointments.getServiceProviderId().getEmail());

        Map<String, Object> patientProvider = new HashMap<>();
        patientProvider.put("id", appointments.getPatient().getId());
        patientProvider.put("name", appointments.getPatient().getName());
        patientProvider.put("email", appointments.getPatient().getEmail());

        Map<String, Object> serviceProviderScheduleDTO = Map.ofEntries(
            Map.entry("id", appointments.getId()),
            Map.entry("service_provider", serviceProvider),
            Map.entry("patient", patientProvider),
            Map.entry("date", appointments.getDate()),
            Map.entry("reservation", appointments.getReservation()),
            Map.entry("created_at", appointments.getCreatedAt()),
            Map.entry("updated_at", appointments.getUpdatedAt())
        );
        return serviceProviderScheduleDTO;
    }

    public Map<String, Object> getScheduleDTOResponse(Appointments appointments) {
        Map<String, Object> serviceProvider = new HashMap<>();
        serviceProvider.put("id", appointments.getServiceProviderId().getId());
        serviceProvider.put("name", appointments.getServiceProviderId().getName());
        serviceProvider.put("email", appointments.getServiceProviderId().getEmail());

        Map<String, Object> patientProvider = null;
        Boolean hasPatient = appointments.getPatient() != null;

        if (hasPatient) {
            patientProvider = new HashMap<>();
            patientProvider.put("id", appointments.getPatient().getId());
            patientProvider.put("name", appointments.getPatient().getName());
            patientProvider.put("email", appointments.getPatient().getEmail());
        }


        Map<String, Object> scheduleDTOResponse = new HashMap<>();
        scheduleDTOResponse.put("id", appointments.getId());
        scheduleDTOResponse.put("service_provider", serviceProvider);
        scheduleDTOResponse.put("patient", patientProvider);
        scheduleDTOResponse.put("date", appointments.getDate());
        scheduleDTOResponse.put("reservation", appointments.getReservation());
        scheduleDTOResponse.put("created_at", appointments.getCreatedAt());
        scheduleDTOResponse.put("updated_at", appointments.getUpdatedAt());


        return scheduleDTOResponse;
    }
}
