package HealthSphereApplication.appointment;

import HealthSphereApplication.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // Find appointments for a given patient
    List<Appointment> findByPatient(Patient patient);

    // Custom JPQL query for upcoming appointments
   /* List<Appointment> findUpcomingAppointments(LocalDateTime appointmentDateTime);*/


    @Query("SELECT a FROM Appointment a WHERE a.appointmentDateTime > :appointmentDateTime")
    List<Appointment> findUpcomingAppointments(@Param("appointmentDateTime") LocalDateTime appointmentDateTime);
}
