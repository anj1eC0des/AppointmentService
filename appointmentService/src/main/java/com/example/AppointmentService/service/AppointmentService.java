package com.example.AppointmentService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AppointmentService.entity.Appointment;
import com.example.AppointmentService.entity.AppointmentDTO;
import com.example.AppointmentService.repository.AppointmentRepository;

@Service
public class AppointmentService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment creatAppointment(AppointmentDTO appointment) {
        Appointment appt = new Appointment();
        //check if patient exists
        //check if doctor exists

        //if yes
        appt.setPatientId(appointment.getPatientId());
        appt.setDoctorId(appointment.getDoctorId());
        appt.setAppointmentDateTime(appointment.getAppointmentDateTime());
        appt.setStatus(appointment.getStatus());
        Appointment savedAppointment=appointmentRepository.save(appt);
        rabbitTemplate.convertAndSend("appointment.demo",savedAppointment);

        //if no
        //throw some exception
        return savedAppointment;

    }

    public List<Appointment> listAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointment(int id) {
        return appointmentRepository.findById(id);
    }

    public Appointment updateAppointment(int id, AppointmentDTO appointment) throws Exception{
        Optional<Appointment> appointmentFromDb= appointmentRepository.findById(id);
        if(appointmentFromDb.isPresent()){
            Appointment appt=appointmentFromDb.get();
            appt.setPatientId(appointment.getPatientId());
            appt.setDoctorId(appointment.getDoctorId());
            appt.setAppointmentDateTime(appointment.getAppointmentDateTime());
            appt.setStatus(appointment.getStatus());
            return appointmentRepository.save(appt);
        }
        throw new Exception("Appointment with id doesn't exist.");
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