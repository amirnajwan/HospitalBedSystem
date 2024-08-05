package com.Group4.HospitalBedSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "beds")
public class BedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id; //bed id auto generate
    private String wardType; //Public/ Female / Children
    private String bedTypeId; //Eg. Fe001(Female, Unit 001)
    private String bedTypeName; //Common / VIP
    private String bedStatus; //Available / Cleaning / Occupied
    private double pricePerDay; //depending on bedTypeName & wardType

    public int getId() {
        return Id;
    }

    public void setBedId(int Id) {
        this.Id = Id;
    }

    public String getWardType() {
        return wardType;
    }

    public void setWardType(String wardType) {
        this.wardType = wardType;
    }

    public String getBedTypeId() {
        return bedTypeId;
    }

    public void setBedTypeId(String bedTypeId) {
        this.bedTypeId = bedTypeId;
    }

    public String getBedTypeName() {
        return bedTypeName;
    }

    public void setBedTypeName(String bedTypeName) {
        this.bedTypeName = bedTypeName;
    }

    public String getBedStatus() {
        return bedStatus;
    }

    public void setBedStatus(String bedStatus) {
        this.bedStatus = bedStatus;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}


