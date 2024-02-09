package com.healthconnect;

import com.healthconnect.model.Doctor;
import com.healthconnect.model.dto.DoctorDTO;
import com.healthconnect.repositories.DoctorRepository;
import com.healthconnect.services.impl.DoctorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorServiceImpl doctorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData/testDataDoctors.csv", numLinesToSkip = 1)
    public void testGetDoctorById(Integer testNumber,Integer doctorId, String doctorName, String specialization) {
        // Mock the behavior of DoctorRepository methods
        Doctor doctor = new Doctor();
        doctor.setDoctorId(doctorId);
        doctor.setFirstName(doctorName);
        doctor.setSpecialization(specialization);

        when(doctorRepository.findById(anyLong())).thenReturn(Optional.of(doctor));
        // You may need to mock other methods if used in DoctorServiceImpl

        DoctorDTO result = doctorService.getDoctorById(doctorId.longValue()).get();

        assertEquals(doctorId, result.getId().intValue());

        verify(doctorRepository, times(1)).findById(doctorId.longValue());
        System.out.println("""
            Expected ID: %s   Actual ID: %s
            """.formatted(doctorName, result.getName()));
    }
}
