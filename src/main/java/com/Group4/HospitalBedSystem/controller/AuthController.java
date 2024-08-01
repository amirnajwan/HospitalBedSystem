package com.Group4.HospitalBedSystem.controller;

import com.Group4.HospitalBedSystem.entity.UserEntity;
import com.Group4.HospitalBedSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/v1/login")
    public ResponseEntity<?> loginUser(@RequestBody UserEntity user) {
        return userService.login(user.getUsername(), user.getPassword());
    }

    @PostMapping("/api/v1/register")
    public ResponseEntity<?> addUser(@RequestBody UserEntity user){
        return userService.saveUser(user);
    }

}
