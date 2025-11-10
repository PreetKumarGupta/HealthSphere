package HealthSphereApplication.doctor;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Doctor {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Getters and Setters
    @Getter
    private String name;
    @Getter
    private String speciality;
    @Getter
    private String city;
    @Getter
    private String email;
    @Getter
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Speciality specialityEnum;


    public void setName(String name){
        this.name = name;
    }

    public void setSpeciality(String speciality){
        this.speciality = speciality;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getExperience() {
        return 5;
    }
}
