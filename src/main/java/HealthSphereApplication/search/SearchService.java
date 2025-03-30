package HealthSphereApplication.search;


import HealthSphereApplication.doctor.Doctor;
import HealthSphereApplication.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> searchDoctors(DoctorSearchCriteria criteria) {
        List<Doctor> allDoctors = doctorRepository.findAll();

        if (criteria.isEmpty()) {
            return allDoctors;
        }

        return allDoctors.stream()
                .filter(doctor ->
                        (criteria.getName() == null || doctor.getName().toLowerCase().contains(criteria.getName().toLowerCase())) &&
                                (criteria.getSpeciality() == null || doctor.getSpeciality().toString().equalsIgnoreCase(criteria.getSpeciality())) &&
                                (criteria.getCity() == null || doctor.getCity().equalsIgnoreCase(criteria.getCity())) &&
                                (criteria.getExperience() == 0 || doctor.getExperience() >= criteria.getExperience())
                )
                .collect(Collectors.toList());
    }
}
