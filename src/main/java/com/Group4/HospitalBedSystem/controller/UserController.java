package com.Group4.HospitalBedSystem.controller;

import com.Group4.HospitalBedSystem.entity.UserEntity;
import com.Group4.HospitalBedSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    // Get
    @GetMapping("/api/v1/users")
    public ResponseEntity<?> getAllUsers(){
        return service.getUsers();
    }

    @GetMapping("/api/v1/userById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        return service.getUserById(id);
    }

    // @GetMapping("/userByName/{name}")
    // public ResponseEntity<?> getUserByName(@PathVariable String name){
    //     return service.getUserByName(name);
    // }

    @PutMapping("/api/v1/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody UserEntity user){
        return service.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        return service.deleteUser(id);
    }


}
