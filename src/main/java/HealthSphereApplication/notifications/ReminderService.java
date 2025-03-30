package HealthSphereApplication.notifications;

import HealthSphereApplication.appointment.Appointment;
import HealthSphereApplication.appointment.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReminderService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private EmailNotificationService emailService;

    @Scheduled(cron = "0 0 * * * ?") // Runs every hour
    public void sendReminders() {
        List<Appointment> upcomingAppointments = appointmentRepository.findUpcomingAppointments(LocalDateTime.now().plusHours(24));
        for (Appointment appointment : upcomingAppointments) {
            String message = "Reminder: You have an appointment scheduled at " + appointment.getAppointmentDateTime();
            emailService.sendEmail(appointment.getPatient().getEmail(), "Appointment Reminder", message);
        }
    }

    public void scheduleReminder(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        String message = "Reminder: Your appointment is scheduled on " + appointment.getAppointmentDateTime();
        emailService.sendEmail(appointment.getPatient().getEmail(), "Appointment Scheduled Reminder", message);
    }
}
