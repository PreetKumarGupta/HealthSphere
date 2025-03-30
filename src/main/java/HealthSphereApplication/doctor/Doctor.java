package HealthSphereApplication.doctor;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Doctor {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String speciality;
    private String city;
    private String email;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Speciality specialityEnum;


    // Getters and Setters
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getSpeciality(){
        return speciality;
    }

    public void setSpeciality(String speciality){
        this.speciality = speciality;
    }

    public  String getCity(){
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getExperience() {
        return 5;
    }
}
