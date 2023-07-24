package com.example.healthsystem.service;

import com.example.healthsystem.repository.ServiceProviderScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

@Service
public class ServiceProviderScheduleService {
    private final ServiceProviderScheduleRepository serviceProviderScheduleRepository;
    private final ArrayList<String> serviceHours;

    public ServiceProviderScheduleService(ServiceProviderScheduleRepository serviceProviderScheduleRepository, ArrayList<String> serviceHours) {
        this.serviceProviderScheduleRepository = serviceProviderScheduleRepository;
        this.serviceHours = new ArrayList<>(Arrays.asList("09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00"));
    }

    public List<Map<String, Object>> createServiceProviderSchedule() {
        List<Map<String, Object>> availabilityHoursMap = getAvailabilityHoursMap();

        // Todo: save availabilityHoursMap to database
        return availabilityHoursMap;
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

    public List<Map<String, Object>> getAvailabilityHoursMap() {
        List<LocalDate> workingDaysOfMonth = getWorkingDaysOfMonth();
        List<Map<String, Object>> dates = new ArrayList<>();

        for (LocalDate workingDay: workingDaysOfMonth) {
            Map<String, Object> response = new HashMap<>();
            List<Map<String, Object>> availabilityOfHours = new ArrayList<>();

            response.put("date", workingDay);
            response.put("availability_of_hours", availabilityOfHours);

            for (String serviceHour: serviceHours) {
                availabilityOfHours.add(Map.ofEntries(
                        Map.entry("hour", serviceHour),
                        Map.entry("available", true)
                ));
            }

            dates.add(response);
        }

        return dates;
    }
}
