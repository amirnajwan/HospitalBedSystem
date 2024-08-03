package com.Group4.HospitalBedSystem.dto.response;

import com.Group4.HospitalBedSystem.entity.Employment_Status;
import com.Group4.HospitalBedSystem.entity.Gender;
import com.Group4.HospitalBedSystem.entity.Marital_Status;
import com.Group4.HospitalBedSystem.entity.Sector;
import lombok.Data;

@Data
public class PatientResponse {
    private int id;
    private String patient_id;
    private String name;
    private int age;
    private Gender gender;
    private Marital_Status marital_status;
    private Employment_Status employment_status;
    private Sector sector;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Marital_Status getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(Marital_Status marital_status) {
        this.marital_status = marital_status;
    }

    public Employment_Status getEmployment_status() {
        return employment_status;
    }

    public void setEmployment_status(Employment_Status employment_status) {
        this.employment_status = employment_status;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
}
