package com.Group4.HospitalBedSystem.dto.response;

import lombok.Data;

@Data
public class BedResponse {
    private int id; //bed id auto generate
    private String wardType; //Public/ Female / Children
    private String bedTypeId; //Eg. Fe001(Female, Unit 001)
    private String name; //Common / VIP
    private String bedStatus; //Available / Cleaning / Occupied
    private double pricePerDay; //depending on bedTypeName & wardType

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
