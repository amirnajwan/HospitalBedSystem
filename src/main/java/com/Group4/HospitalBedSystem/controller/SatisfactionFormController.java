package com.Group4.HospitalBedSystem.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
public class SatisfactionFormController {
    @RequestMapping("/form")
    public String showForm() {
        return "satisfactionForm";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam Map<String, String> formData, RedirectAttributes redirectAttributes) {
        // Process the form data
        System.out.println("Form data: " + formData);

        // Add success message
        redirectAttributes.addFlashAttribute("message", "Form submitted successfully!");

        return "redirect:/";
    }
}
