package com.healthconnect.services;

import com.healthconnect.model.dto.DoctorDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IDoctorService {
    Optional<DoctorDTO> getDoctorById(Long id);
    List<DoctorDTO> getAllDoctors();
    DoctorDTO createDoctor(DoctorDTO doctorDTO);
    DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO);
    boolean deleteDoctor(Long id);
}

