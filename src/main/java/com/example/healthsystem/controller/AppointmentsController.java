package com.example.healthsystem.controller;

import com.example.healthsystem.dto.AppointmentsDTO;
import com.example.healthsystem.model.Appointments;
import com.example.healthsystem.model.User;
import com.example.healthsystem.service.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class AppointmentsController {
    private final AppointmentsService appointmentsService;

    @Autowired
    public AppointmentsController(AppointmentsService appointmentsService) {
        this.appointmentsService = appointmentsService;
    }
    @GetMapping("/appointments")
    public List<Map<String,Object>> getServiceProviderSchedule() {
        List<Map<String,Object>> appointments = appointmentsService.getSchedule();

        return appointments;
    }

    @PostMapping("/appointments/schedule/generate")
    public List<Appointments> generateServiceProviderSchedule() {
        List<Appointments> response = appointmentsService.createServiceProviderSchedule();

        return response;
    }

    @PutMapping("/appointments/schedule/{id}")
    public Map<String, Object> createAppointment(@RequestBody Map<String, Object> patientId, @PathVariable(value="id") Long appointmentId) {
        Map<String, Object> response = appointmentsService.registerAppointment(patientId, appointmentId);
        return response;
    }





}
