package com.Group4.HospitalBedSystem.dto.response;

import lombok.Data;

@Data
public class AdmissionResponse {
    private int id;
    private String admissionId; // Unique identifier for the admission
    private String patientId; // Identifier for the patient
    private String bedId; // Identifier for the bed
    private String diagnosis; // Diagnosis information
    private String dischargeBy; // Person responsible for the discharge
    private String dischargeSummary; // Summary of the discharge
    private String admissionDate; // Date and  of admission
    private String dischargeDate; // Date and  of discharge
    private boolean paid; // Payment status
    private double amount;
    private String transactionId; // Identifier for the transaction
    private double rateBed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmissionId() {
        return admissionId;
    }

    public void setAdmissionId(String admissionId) {
        this.admissionId = admissionId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getBedId() {
        return bedId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDischargeBy() {
        return dischargeBy;
    }

    public void setDischargeBy(String dischargeBy) {
        this.dischargeBy = dischargeBy;
    }

    public String getDischargeSummary() {
        return dischargeSummary;
    }

    public void setDischargeSummary(String dischargeSummary) {
        this.dischargeSummary = dischargeSummary;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getRateBed() {
        return rateBed;
    }

    public void setRateBed(double rateBed) {
        this.rateBed = rateBed;
    }
}
