package com.healthconnect.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    private Long id;
    private DoctorDTO doctor;
    private PatientDTO patient;
    private String appointmentDate;
    private String appointmentTime;
}
