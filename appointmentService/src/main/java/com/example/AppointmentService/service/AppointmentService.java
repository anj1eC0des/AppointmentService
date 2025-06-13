package com.example.AppointmentService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.AppointmentService.entity.Appointment;
import com.example.AppointmentService.entity.AppointmentDTO;
import com.example.AppointmentService.repository.AppointmentRepository;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment creatAppointment(AppointmentDTO appointment) {
        Appointment appt = new Appointment();
        appt.setPatientId(appointment.getPatientId());
        appt.setDoctorId(appointment.getDoctorId());
        appt.setAppointmentDateTime(appointment.getAppointmentDateTime());
        appt.setStatus(appointment.getStatus());
        return appointmentRepository.save(appt);
    }

    public List<Appointment> listAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointment(int id) {
        return appointmentRepository.findById(id);
    }

    public Appointment updateAppointment(int id, AppointmentDTO appointment) {
        Appointment appt = new Appointment();
        appt.setAppointmentId(id);
        appt.setPatientId(appointment.getPatientId());
        appt.setDoctorId(appointment.getDoctorId());
        appt.setAppointmentDateTime(appointment.getAppointmentDateTime());
        appt.setStatus(appointment.getStatus());
        return appointmentRepository.save(appt);
    }

    public void deleteAppointment(int id) {
        appointmentRepository.deleteById(id);
    }

    public List<Appointment> searchAppointmentByPatientId(int patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public List<Appointment> searchAppointmentByDoctorId(int doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }
}