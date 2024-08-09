package com.Group4.HospitalBedSystem.dto.response;

import com.Group4.HospitalBedSystem.entity.AdmissionEntity;

import lombok.Data;

@Data
public class PaymentCallbackData {
    private int status_id;
    private String billcode;
    private String order_id;
    private String transaction_id;

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getBillcode() {
        return billcode;
    }

    public void setBillcode(String billcode) {
        this.billcode = billcode;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }
}


