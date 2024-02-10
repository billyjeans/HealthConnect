package com.healthconnect.services.impl;

import com.healthconnect.model.Appointment;
import com.healthconnect.repositories.AppointmentRepository;
import com.healthconnect.services.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class AppointmentServiceImpl implements IAppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

//    @Autowired
//    private NotificationService notificationService;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId);
    }

    public void scheduleAppointment(Appointment appointment) {
        // Add business logic for scheduling appointments
        appointmentRepository.save(appointment);

        // Notify the patient and doctor
//        notificationService.sendAppointmentScheduledNotification(appointment);
    }

    public void cancelAppointment(Long appointmentId) {
        // Retrieve the appointment for additional actions, if needed
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);
        if (optionalAppointment.isPresent()) {
            Appointment appointment = optionalAppointment.get();

            // Add business logic for canceling appointments
            appointmentRepository.deleteById(appointmentId);

            // Notify the patient and doctor about the cancellation
//            notificationService.sendAppointmentCancelledNotification(appointment);
        }
    }

    // Additional methods related to appointments...

}
