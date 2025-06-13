package com.example.AppointmentService.repository;

import com.example.AppointmentService.entity.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment,Integer> {
}
