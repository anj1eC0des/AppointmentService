package com.example.AppointmentService.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppointmentDTO {
    private int doctorId;
    private int patientId;
    private LocalDateTime appointmentDateTime;
    private String status;
}
