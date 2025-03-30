package HealthSphereApplication;


import HealthSphereApplication.appointment.AppointmentController;
import HealthSphereApplication.auth.AuthenticationController;
import HealthSphereApplication.billing.BillingController;
import HealthSphereApplication.doctor.DoctorController;
import HealthSphereApplication.medicalrecord.MedicalRecordController;
import HealthSphereApplication.notifications.NotificationController;
import HealthSphereApplication.patient.PatientController;
import HealthSphereApplication.search.SearchController;
import HealthSphereApplication.suggestion.SuggestionController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HealthSphereApplicationTest {

	@Autowired
	private AppointmentController appointmentController;

	@Autowired
	private AuthenticationController authenticationController;

	@Autowired
	private BillingController billingController;

	@Autowired
	private DoctorController doctorController;

	@Autowired
	private MedicalRecordController medicalRecordController;

	@Autowired
	private NotificationController notificationController;



	@Autowired
	private SearchController searchController;

	@Autowired
	private SuggestionController suggestionController;
	@Autowired
	private PatientController patientController;


	/**
	 * Test that the application context loads successfully and all controllers are properly injected.
	 */
	@Test
	void contextLoads() {
		assertThat(appointmentController).isNotNull();
		assertThat(authenticationController).isNotNull();
		assertThat(billingController).isNotNull();
		assertThat(doctorController).isNotNull();

		assertThat(medicalRecordController).isNotNull();
		assertThat(notificationController).isNotNull();
		assertThat(patientController).isNotNull();
		assertThat(searchController).isNotNull();
		assertThat(suggestionController).isNotNull();
	}

	/**
	 * Test application startup.
	 */
	@Test
	void applicationStarts() {
		HealthSphereApplication.main(new String[]{});
	}
}
