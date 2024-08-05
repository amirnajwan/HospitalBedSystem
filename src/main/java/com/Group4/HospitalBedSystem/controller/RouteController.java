package com.Group4.HospitalBedSystem.controller;

import com.Group4.HospitalBedSystem.entity.satification.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("/page1") // sambung disini
    public String home() {
        return "page1";
    }

    //patients satisfaction routing pages
    @GetMapping("/category")
    public String viewCategoriesManagement() {return "redirect:/categories";}
    @GetMapping("/measurement")
    public String viewMeasurementsManagement() {return "redirect:/measurements";}

//
//    @GetMapping("/addcategory")
//    public String addSatisfactionCategory() {return "feedback/add-category";}
//    @GetMapping("/addmeasurement")
//    public String addSatisfactionMeasurement() {return "feedback/add-measurement";}
//    @GetMapping("/patientsatisfactionform")
//    public String showSatisfactionForm() {return "feedback/submit-satisfaction-form";}
//    @PostMapping("/successsubmitsatisfactionform")
//    public String submitSatisfactionForm() {return "feedback/success-submit-satisfaction";}
//    @GetMapping("/viewsatisfactionreport")
//    public String viewSatisfactionReport() {return "feedback/view-satisfaction-report";}

    //end patients satisfaction pages

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
