package com.Group4.HospitalBedSystem.controller;

import com.Group4.HospitalBedSystem.entity.UserEntity;
import com.Group4.HospitalBedSystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new UserEntity());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") UserEntity user){
        UserEntity oauthUser = userService.login(user.getUsername(), user.getPassword());
        if (oauthUser != null) {
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }
}
