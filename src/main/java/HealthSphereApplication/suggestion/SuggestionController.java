package HealthSphereApplication.suggestion;


import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/suggestions")
public class SuggestionController {

    @GetMapping("/symptoms")
    public List<String> suggestDoctorsBySymptom(@RequestParam String symptom) {
        switch (symptom.toLowerCase()) {
            case "fever":
                return Arrays.asList("General Physician", "Internal Medicine Specialist");
            case "heart pain":
                return Arrays.asList("Cardiologist", "Cardio-Thoracic Surgeon");
            case "skin rash":
                return Arrays.asList("Dermatologist", "Allergist");
            case "joint pain":
                return Arrays.asList("Orthopedic", "Rheumatologist");
            default:
                return Arrays.asList("General Physician", "Consult Specialist");
        }
    }

    @GetMapping("/specialities")
    public List<String> listAllSpecialities() {
        return Arrays.asList(
                "General Physician",
                "Cardiologist",
                "Dermatologist",
                "Orthopedic",
                "Pediatrician",
                "Gynecologist",
                "ENT Specialist",
                "Neurologist",
                "Endocrinologist",
                "Urologist"
        );
    }
}
