package com.healthconnect.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "appointments")
public class Appointment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "appointment_id")
  private Integer appointmentId;

  @Column(name = "appointment_date")
  private LocalDate appointmentDate;

  @Column(name = "appointment_time")
  private LocalTime appointmentTime;

  @ManyToOne
  @JoinColumn(name = "patient_id")
  private Patient patient;

  @ManyToOne
  @JoinColumn(name = "doctor_id")
  private Doctor doctor;

}
