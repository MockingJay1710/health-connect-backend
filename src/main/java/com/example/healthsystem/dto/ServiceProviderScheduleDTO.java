package com.example.healthsystem.dto;

import com.example.healthsystem.model.ServiceProviderSchedule;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

public class ServiceProviderScheduleDTO {
    private Long id;
    private Long serviceProviderId;
    private Long patientId;
    private LocalDateTime date;
    private Boolean reservation;
    private Date created_at;


    public ServiceProviderScheduleDTO() {

    }

    public Map<String, Object> getServiceProviderScheduleDTOResponse(ServiceProviderSchedule serviceProviderSchedule) {
        Map<String, Object> serviceProviderScheduleDTO = Map.ofEntries(
            Map.entry("id", serviceProviderSchedule.getId()),
            Map.entry("service_provider_id", serviceProviderSchedule.getServiceProviderId().getId()),
            Map.entry("patient_id", serviceProviderSchedule.getPatient().getId()),
            Map.entry("date", serviceProviderSchedule.getDate()),
            Map.entry("available", serviceProviderSchedule.getReservation()),
            Map.entry("created_at", serviceProviderSchedule.getCreatedAt())
        );
        return serviceProviderScheduleDTO;
    }
}
