package com.example.healthsystem.service;

import com.example.healthsystem.dto.AppointmentsDTO;
import com.example.healthsystem.model.Appointments;
import com.example.healthsystem.model.User;
import com.example.healthsystem.repository.AppointmentsRepository;
import com.example.healthsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class AppointmentsService {

    private final AppointmentsRepository appointmentsRepository;
    private final UserRepository userRepository;
     final ArrayList<String> serviceHours;

    public AppointmentsService(AppointmentsRepository appointmentsRepository, ArrayList<String> serviceHours, UserRepository userRepository) {
        this.appointmentsRepository = appointmentsRepository;
        this.userRepository = userRepository;
        this.serviceHours = new ArrayList<>(Arrays.asList("09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00"));
    }


    public List<Map<String,Object>> getSchedule() {
        List<Appointments> appointments = appointmentsRepository.findAll();
        List<Map<String,Object>> parsedResponse = new ArrayList<>();

        for (Appointments appointment: appointments) {
            Map<String, Object> response = new AppointmentsDTO().getScheduleDTOResponse(appointment);
            parsedResponse.add(response);
        }

        return parsedResponse;
    }

    public Map<String, Object> registerAppointment(Map<String,Object> patientId, Long appointmentId) {
        Appointments savedAppointment = appointmentsRepository.getReferenceById(appointmentId);

        String userId = patientId.get("patientId").toString();
        User patient = userRepository.findById(userId);
        savedAppointment.setPatient(patient);
        savedAppointment.setReservation(true);
        Appointments newAppointment = appointmentsRepository.save(savedAppointment);
        Map<String, Object> response = new AppointmentsDTO().getServiceProviderScheduleDTOResponse(newAppointment);
        return response;
    }

    public  List<Appointments> createServiceProviderSchedule() {
        List<LocalDate> workingDaysOfMonth = getWorkingDaysOfMonth();
        List<Appointments> appointments = new ArrayList<>();
        List<User> serviceProviders = userRepository.findServiceProviders();

        for (User serviceProvider: serviceProviders) {
            Long id = serviceProvider.getId();
            for (LocalDate workingDay: workingDaysOfMonth) {
                for (String serviceHour: serviceHours) {
                    LocalDate date = LocalDate.parse(workingDay.toString());
                    LocalTime time = LocalTime.parse(serviceHour);
                    LocalDateTime dateTime = LocalDateTime.of(date, time);


                    Map<String, Object> dateMap = Map.ofEntries(
                        Map.entry("service_provide_id", id),
                        Map.entry("date",  dateTime)
                    );

                    Appointments appointment = new Appointments();
                    appointment.setServiceProviderId(serviceProvider);
                    appointment.setDate(dateTime);

                    // save to database
                    appointmentsRepository.save(appointment);

                    appointments.add(appointment);
                }
            }
        }


        return appointments;
    }

    public List<LocalDate> getWorkingDaysOfMonth() {
        LocalDate currentDate = LocalDate.now();

        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
        LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());
        List<LocalDate> allDatesOfMonth = new ArrayList<>();
        LocalDate currentDay = firstDayOfMonth;

        while (!currentDay.isAfter(lastDayOfMonth)) {
            allDatesOfMonth.add(currentDay);
            currentDay = currentDay.plusDays(1);
        }

        List<LocalDate> workingDaysOfMonth = new ArrayList<>();
        for (LocalDate date : allDatesOfMonth) {
            if (date.getDayOfWeek() != DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY) {
                workingDaysOfMonth.add(date);
            }
        }

        return workingDaysOfMonth;
    }


}
