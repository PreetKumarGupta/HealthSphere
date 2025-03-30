package HealthSphereApplication.billing;


import HealthSphereApplication.patient.Patient;
import HealthSphereApplication.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BillingService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private PatientRepository patientRepository;

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Bill getBillById(Long id) {
        return billRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found with id: " + id));
    }

    public Bill generateBill(Long patientId, BigDecimal amount) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);

        if (optionalPatient.isEmpty()) {
            throw new RuntimeException("Patient not found with id: " + patientId);
        }

        Bill bill = new Bill();
        bill.setPatient(optionalPatient.get());
        bill.setAmount(amount);
        bill.setBillingDate(LocalDateTime.now());
        bill.setPaymentStatus("PENDING");

        return billRepository.save(bill);
    }

    public Bill updateBill(Long id, Bill updatedBill) {
        Bill existingBill = getBillById(id);
        existingBill.setAmount(updatedBill.getAmount());
        existingBill.setPaymentStatus(updatedBill.getPaymentStatus());
        return billRepository.save(existingBill);
    }

    public void deleteBill(Long id) {
        Bill bill = getBillById(id);
        billRepository.delete(bill);
    }
}
