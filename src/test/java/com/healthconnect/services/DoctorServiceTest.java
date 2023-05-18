package com.healthconnect.services;

import com.healthconnect.model.Doctor;
import com.healthconnect.model.dto.DoctorDTO;
import com.healthconnect.repositories.DoctorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DoctorServiceImplTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorServiceImpl doctorService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetDoctorById() {
        Integer doctorId = 1;
        Doctor doctor = new Doctor();
        doctor.setDoctorId(doctorId);
        doctor.setFirstName("John Doe");
        doctor.setSpecialization("Cardiology");

        when(doctorRepository.findById(doctorId.longValue())).thenReturn(Optional.of(doctor));

        DoctorDTO result = doctorService.getDoctorById(doctorId.longValue()).get();

        assertEquals(doctorId, result.getId().intValue());

        verify(doctorRepository, times(1)).findById(doctorId.longValue());

    }
}






