package com.healthconnect.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionDTO {
    private Long id;
    private DoctorDTO doctor;
    private PatientDTO patient;
    private String prescriptionDate;
    private String prescriptionDetails;
}
