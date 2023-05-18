package com.healthconnect.services;

import com.healthconnect.model.Doctor;
import com.healthconnect.model.dto.DoctorDTO;
import com.healthconnect.repositories.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, DoctorDTO doctorDto) {
        Doctor doctorToUpdate = doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with id " + id));

        Doctor updatedDoctor = Doctor.builder()
                .doctorId(doctorToUpdate.getDoctorId())
                .firstName(doctorDto.getName() != null ? doctorDto.getName() : doctorToUpdate.getFirstName())
                .specialization(doctorDto.getSpecialization() != null ? doctorDto.getSpecialization() : doctorToUpdate.getSpecialization())
                .build();

        return doctorRepository.save(updatedDoctor);
    }

    public void deleteDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new EntityNotFoundException("Doctor not found for id: " + id);
        }
        doctorRepository.deleteById(id);
    }
}

