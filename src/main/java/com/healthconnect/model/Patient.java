package com.healthconnect.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "patients")
public class Patient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "patient_id")
  private Integer id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "dob")
  @Temporal(TemporalType.DATE)
  private Date dob;

  @Column(name = "gender")
  private String gender;

  @Column(name = "contact_number")
  private String contactNumber;

  @Column(name = "address")
  private String address;

  // getters and setters
}