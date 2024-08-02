package com.Group4.HospitalBedSystem.dto.response;

import lombok.Data;

@Data
public class LoginResponse {
    private int userId;
    private String name;
    private String role;
    private boolean loginSuccess;

    public LoginResponse() {
    }

    public LoginResponse(int userId, String name, String role, boolean loginSuccess) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.loginSuccess = loginSuccess;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }
}
