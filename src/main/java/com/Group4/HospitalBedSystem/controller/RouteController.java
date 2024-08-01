package com.Group4.HospitalBedSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteController {
    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
    @GetMapping("/home")
    public String home() {
        return "home";
    }
    @GetMapping("/register")
    public String register(@RequestParam(name = "from", required = false) String from) {
        return "auth/register";
    }
    @GetMapping("/logout")
    public String logout() {
        return "auth/login";
    }
}
