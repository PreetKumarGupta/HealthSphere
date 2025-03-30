package HealthSphereApplication.medicalrecord;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicalrecords")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;
    private ReportGenerator reportGenerator;

    @GetMapping("/all")
    public ResponseEntity<List<MedicalRecord>> getAllRecords() {
        return ResponseEntity.ok(medicalRecordService.getAllRecords());
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalRecord>> getRecordsByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(medicalRecordService.getRecordsByPatientId(patientId));
    }

    @PostMapping("/add")
    public ResponseEntity<MedicalRecord> addMedicalRecord(@RequestBody MedicalRecord record) {
        return ResponseEntity.ok(medicalRecordService.addRecord(record));
    }

    @GetMapping("/patient/{id}/report")
    public ResponseEntity<byte[]> getPatientReport(@PathVariable Long id) {
        List<MedicalRecord> records = medicalRecordService.getRecordsByPatientId(id);
        byte[] report = reportGenerator.generatePatientReport(records);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "PatientReport.pdf");

        return new ResponseEntity<>(report, headers, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<MedicalRecord> updateMedicalRecord(@PathVariable Long id, @RequestBody MedicalRecord updatedRecord) {
        return ResponseEntity.ok(medicalRecordService.updateRecord(id, updatedRecord));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMedicalRecord(@PathVariable Long id) {
        medicalRecordService.deleteRecord(id);
        return ResponseEntity.ok("Medical record deleted successfully.");
    }
}
