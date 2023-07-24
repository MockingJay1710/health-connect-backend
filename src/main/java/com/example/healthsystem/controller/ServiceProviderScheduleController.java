package com.example.healthsystem.controller;

import com.example.healthsystem.service.ServiceProviderScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class ServiceProviderScheduleController {
    private final ServiceProviderScheduleService serviceProviderScheduleService;

    @Autowired
    public ServiceProviderScheduleController(ServiceProviderScheduleService serviceProviderScheduleService) {
        this.serviceProviderScheduleService = serviceProviderScheduleService;
    }

    @PostMapping("/serviceProviderSchedule/generate")
    public List<Map<String, Object>> generateServiceProviderSchedule() {
        List<Map<String, Object>> response = serviceProviderScheduleService.createServiceProviderSchedule();

        return response;
    }


}
