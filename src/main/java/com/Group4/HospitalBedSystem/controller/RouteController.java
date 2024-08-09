package com.Group4.HospitalBedSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteController {

    // route pages
    @GetMapping("/")
    public String login() {
        return "auth/login";
    }
    @GetMapping("/index")
    public String index() {
        return "index";
    }
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }
    @GetMapping("/users")
    public String users() {
        return "users";
    }
    @GetMapping("/registerPatient")
    public String registerPatient() {
        return "patient/registerPatient";
    }
    @GetMapping("/patients")
    public String patients() {
        return "patient/patients";
    }
    @GetMapping("/page1") // sambung disini
    public String page1() {
        return "page1";
    }

    //patients satisfaction routing pages
    @GetMapping("/categories")
    public String viewCategoriesManagement() {return "feedback/category/categories";}
    @GetMapping("/categories/add")
    public String addCategoriesManagement() {return "feedback/category/add-category";}
    @GetMapping("/measurements")
    public String viewMeasurementsManagement() {return "feedback/measurement/measurements";}
    @GetMapping("/measurements/add")
    public String addMeasurementsManagement() {return "feedback/measurement/add-measurement";}
    @GetMapping("/feedbackForm")
    public String feedbackFormManagement() {return "feedback/feedback/feedback-form";}
    @GetMapping("/completeFeedback")
    public String completeFormManagement() {return "feedback/feedback/feedback-complete";}


    //end patients satisfaction pages

    //beds routing
    @GetMapping("/beds")
    public String viewAllBeds(){return "/bed/beds";}
    //end beds

    @GetMapping("/register")
    public String register(@RequestParam(name = "from", required = false) String from) {
        return "auth/register";
    }
    @GetMapping("/logout")
    public String logout() {
        return "auth/login";
    }

    // utils
    @GetMapping("/sidebar")
    public String sidebar() {
        return "utils/sidebar";
    }
    @GetMapping("/footer")
    public String footer() {
        return "utils/footer";
    }
    @GetMapping("/header")
    public String header() {
        return "utils/header";
    }


}
