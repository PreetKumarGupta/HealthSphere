package HealthSphereApplication.notifications;

import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService {

    public void sendSms(String recipient, String message) {
        // Simulate SMS sending logic
        System.out.println("Sending SMS to: " + recipient);
        System.out.println("Message: " + message);
    }
}
