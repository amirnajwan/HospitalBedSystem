package com.Group4.HospitalBedSystem.service.general;

import lombok.Data;

@Data
public class SuccessAndDataResponse {
    private Boolean success = false;
    private String message;
    private Object data;

    public SuccessAndDataResponse setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public SuccessAndDataResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public SuccessAndDataResponse setData(Object data) {
        this.data = data;
        return this;
    }
}
