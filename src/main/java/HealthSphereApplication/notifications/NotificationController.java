package HealthSphereApplication.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    @Autowired
    private EmailNotificationService emailService;

    @Autowired
    private SmsNotificationService smsService;

    @Autowired
    private ReminderService reminderService;

    @PostMapping("/email")
    public String sendEmailNotification(@RequestParam String recipient, @RequestParam String subject, @RequestParam String message) {
        emailService.sendEmail(recipient, subject, message);
        return "Email notification sent successfully.";
    }

    @PostMapping("/sms")
    public String sendSmsNotification(@RequestParam String recipient, @RequestParam String message) {
        smsService.sendSms(recipient, message);
        return "SMS notification sent successfully.";
    }

    @PostMapping("/reminder")
    public String scheduleReminder(@RequestParam Long appointmentId) {
        reminderService.scheduleReminder(appointmentId);
        return "Reminder scheduled successfully.";
    }
}
