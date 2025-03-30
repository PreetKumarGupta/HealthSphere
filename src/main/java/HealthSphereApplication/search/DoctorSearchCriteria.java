package HealthSphereApplication.search;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorSearchCriteria {

    private String name;
    private String speciality;
    private String city;
    private int experience;

    public boolean isEmpty() {
        return (name == null || name.isEmpty()) &&
                (speciality == null || speciality.isEmpty()) &&
                (city == null || city.isEmpty()) &&
                experience == 0;
    }
}
