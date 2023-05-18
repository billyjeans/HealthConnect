package com.healthconnect.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Data
@Table(name = "prescriptions")
public class Prescription {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "prescription_id")
  private Integer prescriptionId;

  @Column(name = "prescription_date")
  private LocalDate prescriptionDate;

  @Column(name = "prescription_details")
  private String prescriptionDetails;

  @ManyToOne
  @JoinColumn(name = "patient_id")
  private Patient patient;

  @ManyToOne
  @JoinColumn(name = "doctor_id")
  private Doctor doctor;

}
