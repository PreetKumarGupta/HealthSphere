package HealthSphereApplication.billing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @GetMapping("/all")
    public ResponseEntity<List<Bill>> getAllBills() {
        return ResponseEntity.ok(billingService.getAllBills());
    }

    @PostMapping("/generate")
    public ResponseEntity<Bill> generateBill(@RequestParam Long patientId, @RequestParam BigDecimal amount) {
        return ResponseEntity.ok(billingService.generateBill(patientId, amount));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long id) {
        return ResponseEntity.ok(billingService.getBillById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Bill> updateBill(@PathVariable Long id, @RequestBody Bill updatedBill) {
        return ResponseEntity.ok(billingService.updateBill(id, updatedBill));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable Long id) {
        billingService.deleteBill(id);
        return ResponseEntity.ok("Bill deleted successfully!");
    }
}
