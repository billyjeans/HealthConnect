package com.healthconnect.services;

import com.healthconnect.model.Doctor;
import com.healthconnect.model.dto.DoctorDTO;
import com.healthconnect.repositories.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DoctorService {
    Optional<DoctorDTO> getDoctorById(Long id);
    List<DoctorDTO> getAllDoctors();
    DoctorDTO createDoctor(DoctorDTO doctorDTO);
    DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO);
    boolean deleteDoctor(Long id);
}

