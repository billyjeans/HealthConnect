package com.healthconnect.services.impl;

import com.healthconnect.model.Doctor;
import com.healthconnect.model.dto.DoctorDTO;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorMapper {

        private DoctorMapper() {
            // private constructor to prevent instantiation
        }

        public static DoctorDTO toDTO(Doctor doctor) {
            DoctorDTO dto = new DoctorDTO();
            dto.setId(doctor.getDoctorId().longValue());
            dto.setName(doctor.getFirstName());
            dto.setSpecialization(doctor.getSpecialization());
            return dto;
        }

        public static List<DoctorDTO> toDTOList(List<Doctor> doctors) {
            return doctors.stream()
                    .map(DoctorMapper::toDTO)
                    .collect(Collectors.toList());
        }

        public static Doctor toEntity(DoctorDTO dto) {
            Doctor doctor = new Doctor();
            doctor.setDoctorId(dto.getId().intValue());
            doctor.setFirstName(dto.getName());
            doctor.setSpecialization(dto.getSpecialization());
            return doctor;
        }
    }


