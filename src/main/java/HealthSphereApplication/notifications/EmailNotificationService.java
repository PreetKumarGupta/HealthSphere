package HealthSphereApplication.notifications;


import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {

    public void sendEmail(String recipient, String subject, String message) {
        // Simulate email sending logic

        System.out.println("Sending Email to: " + recipient);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
    }
}
