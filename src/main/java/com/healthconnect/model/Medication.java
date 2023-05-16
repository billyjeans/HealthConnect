package com.healthconnect.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Data
@Table(name = "medications")
public class Medication {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "medication_id")
  private Integer medicationId;

  @Column(name = "medication_name")
  private String medicationName;

  @Column(name = "dosage")
  private String dosage;

  @ManyToOne
  @JoinColumn(name = "prescription_id")
  private Prescription prescription;

}
