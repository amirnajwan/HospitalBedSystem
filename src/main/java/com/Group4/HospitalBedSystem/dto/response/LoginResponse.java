package com.Group4.HospitalBedSystem.dto.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String username;
    private String role;
    private boolean loginSuccess;

    public LoginResponse() {
    }

    public LoginResponse(String username, String role, boolean loginSuccess) {
        this.username = username;
        this.role = role;
        this.loginSuccess = loginSuccess;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
