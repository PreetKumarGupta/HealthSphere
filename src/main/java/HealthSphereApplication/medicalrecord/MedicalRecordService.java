package HealthSphereApplication.medicalrecord;

import HealthSphereApplication.patient.Patient;
import HealthSphereApplication.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    private PatientRepository patientRepository;

    public List<MedicalRecord> getAllRecords() {
        return medicalRecordRepository.findAll();
    }

    public List<MedicalRecord> getRecordsByPatientId(Long patientId) {
        return medicalRecordRepository.findByPatientId(patientId);
    }

    public MedicalRecord addRecord(MedicalRecord record) {
        Optional<Patient> optionalPatient = patientRepository.findById(record.getPatient().getId());

        if (optionalPatient.isEmpty()) {
            throw new RuntimeException("Patient not found with id: " + record.getPatient().getId());
        }

        record.setPatient(optionalPatient.get());
        return medicalRecordRepository.save(record);
    }

    public MedicalRecord updateRecord(Long id, MedicalRecord updatedRecord) {
        MedicalRecord existingRecord = medicalRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medical record not found with id: " + id));

        existingRecord.setDiagnosis(updatedRecord.getDiagnosis());
        existingRecord.setTreatment(updatedRecord.getTreatment());
        existingRecord.setRecordDate(updatedRecord.getRecordDate());
        return medicalRecordRepository.save(existingRecord);
    }

    public void deleteRecord(Long id) {
        MedicalRecord record = medicalRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medical record not found with id: " + id));
        medicalRecordRepository.delete(record);
    }
}
