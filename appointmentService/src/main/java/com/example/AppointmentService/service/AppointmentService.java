package com.example.AppointmentService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AppointmentService.entity.Appointment;
import com.example.AppointmentService.entity.AppointmentDTO;

@Service
public class AppointmentService {
    public Appointment creatAppointment(AppointmentDTO patient) {
        // jpa save - repo.save(patient)
        return new Appointment();
    }

    public List<Appointment> listAppointments() {
        // repo.listAppointments;
        return new ArrayList<>();
    }

    public Appointment getAppointment(int id) {
        // patient find by id
        return new Appointment();
    }

    public Appointment updateAppointment(int id, AppointmentDTO patient) {
        return new Appointment();
    }

    public int deleteAppointment(int id) {
        return 0;
    }

    public Appointment searchAppointment(String name) {
        return new Appointment();
    }
}