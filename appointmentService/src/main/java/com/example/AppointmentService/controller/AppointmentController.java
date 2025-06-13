package com.example.AppointmentService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.AppointmentService.entity.Appointment;
import com.example.AppointmentService.entity.AppointmentDTO;

@RestController
public class AppointmentController {
    @PostMapping("/appointments")
    @ResponseBody
    public String createAppointment(@RequestBody AppointmentDTO patient) {
        return "New Appointment created";
    }

    @GetMapping("/appointments")
    @ResponseBody
    public List<Appointment> getAppointments() {
        return new ArrayList<Appointment>();
    }

    @GetMapping("/appointments/{id}")
    @ResponseBody
    public Appointment getAppointments(@PathVariable int id) {
        return new Appointment();
    }

    @PutMapping("/appointments/{id}")
    @ResponseBody
    public Appointment updateAppointments(@RequestBody AppointmentDTO patient, @PathVariable int id) {
        return new Appointment();
    }

    @DeleteMapping("/appointments/{id}")
    @ResponseBody
    public String deleteAppointment(@PathVariable int id) {
        return "Appointment deleted";
    }

    @GetMapping("/appointments/patient/{patientId}")
    @ResponseBody
    public List<Appointment> searchAppointmentsByPatientId(@PathVariable int patientId) {
        return new ArrayList<Appointment>();
    }

    @GetMapping("/appointments/patient/{patientId}")
    @ResponseBody
    public List<Appointment> searchAppointmentsByDoctorId(@PathVariable int doctorId) {
        return new ArrayList<Appointment>();
    }
}
