package HealthSphereApplication.billing;


import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class PaymentGatewayService {

    public String processPayment(String paymentMethod, BigDecimal amount) {
        if ("CREDIT_CARD".equalsIgnoreCase(paymentMethod) || "DEBIT_CARD".equalsIgnoreCase(paymentMethod)) {
            return "Payment of ₹" + amount + " processed successfully using " + paymentMethod;
        } else {
            throw new IllegalArgumentException("Invalid payment method: " + paymentMethod);
        }
    }
}
