package com.healthconnect.services.impl;

import com.healthconnect.model.Doctor;
import com.healthconnect.model.dto.DoctorDTO;
import com.healthconnect.repositories.DoctorRepository;
import com.healthconnect.services.DoctorMapper;
import com.healthconnect.services.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DoctorServiceImpl implements IDoctorService {

    // this is a commit to check if jenkins pipeline scans correctly
        private final DoctorRepository doctorRepository;

        @Autowired
        public DoctorServiceImpl(DoctorRepository doctorRepository) {
            this.doctorRepository = doctorRepository;
        }

        @Override
        public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
            Doctor doctor = DoctorMapper.toEntity(doctorDTO);
            Doctor savedDoctor = doctorRepository.save(doctor);
            return DoctorMapper.toDTO(savedDoctor);
        }

        @Override
        public Optional<DoctorDTO> getDoctorById(Long id) {
            Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
            return optionalDoctor.map(DoctorMapper::toDTO);
        }

        @Override
        public List<DoctorDTO> getAllDoctors() {
            List<Doctor> doctors = doctorRepository.findAll();
            return DoctorMapper.toDTOList(doctors);
        }

        @Override
        public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) {
            Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
            if (optionalDoctor.isPresent()) {
                Doctor doctor = optionalDoctor.get();
                doctor.setFirstName(doctorDTO.getName());
                doctor.setSpecialization(doctorDTO.getSpecialization());
                Doctor updatedDoctor = doctorRepository.save(doctor);
                return DoctorMapper.toDTO(updatedDoctor);
            }
            return null;
        }

        @Override
        public boolean deleteDoctor(Long id) {
            if (doctorRepository.existsById(id)) {
                doctorRepository.deleteById(id);
                return true;
            }
            return false;
        }
    }


