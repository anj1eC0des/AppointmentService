package com.example.AppointmentService.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int appointmentId;
    @Column(name="doctorId",nullable = false)
    private int doctorId;
    @Column(name = "patientId",nullable = false)
    private int patientId;
    @Column(name = "appointmentDateTime",nullable = false)
    private LocalDateTime appointmentDateTime;
    @Column(name = "status",nullable = false)
    private String status;
}
