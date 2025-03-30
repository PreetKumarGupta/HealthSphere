package HealthSphereApplication.search;

import HealthSphereApplication.doctor.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/doctors")
    public List<Doctor> searchDoctors(@RequestParam(required = false) String name,
                                      @RequestParam(required = false) String speciality,
                                      @RequestParam(required = false) String city,
                                      @RequestParam(required = false, defaultValue = "0") int experience) {

        DoctorSearchCriteria criteria = new DoctorSearchCriteria();
        criteria.setName(name);
        criteria.setSpeciality(speciality);
        criteria.setCity(city);
        criteria.setExperience(experience);

        return searchService.searchDoctors(criteria);
    }
}
