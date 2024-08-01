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

    // Post
    // @PostMapping("/addUser")
    // public ResponseEntity<?> addUser(@RequestBody UserEntity user){
    //     return service.saveUser(user);
    // }

    //    @PostMapping("/login")
    //    public ResponseEntity<?> loginUser(@RequestBody UserEntity user) {
    //        return service.login(user.getUsername(), user.getPassword());
    //    }


    //    @PostMapping("/addUsers")
    //    public List<UserEntity> addUsers(@RequestBody List<UserEntity> users){
    //        return service.saveUsers(users);
    //    }

    // Get
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        return service.getUsers();
    }

    @GetMapping("/userById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        return service.getUserById(id);
    }

    @GetMapping("/userByName/{name}")
    public ResponseEntity<?> getUserByName(@PathVariable String name){
        return service.getUserByName(name);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody UserEntity user){
        return service.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        return service.deleteUser(id);
    }


}
