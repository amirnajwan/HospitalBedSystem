package com.Group4.HospitalBedSystem.controller.satisfaction;

import com.Group4.HospitalBedSystem.entity.satification.*;
import com.Group4.HospitalBedSystem.service.satisfaction.*;
import com.Group4.HospitalBedSystem.dto.response.satisfication.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private MeasurementService measurementService;

    @Autowired
    private CategoryService categoryService;

//    @GetMapping
//    public String getFeedbackForm(Model model) {
//        model.addAttribute("categories", measurementService.getAllMeasurements().stream().collect(Collectors.groupingBy(m -> m.getCategory().getName())));
//        return "feedback/feedback/feedback-form";
//    }

    @GetMapping
    public String showFeedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
       // model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("measurements", measurementService.getAllMeasurements());
        return "feedback/feedback/feedback-form";
    }

//    @PostMapping
//    public String submitFeedback(@ModelAttribute FeedbackDTO feedbackDTO) {
//        Feedback feedback = new Feedback();
//        feedback.setRating(feedbackDTO.getRating());
//        feedback.setMeasurement(measurementService.getMeasurementById(feedbackDTO.getMeasurementId()));
//        feedbackService.saveFeedback(feedback);
//        return "redirect:/feedback";
//    }
    @PostMapping
    public String submitFeedback(@ModelAttribute("feedback") Feedback feedback, BindingResult result, Model model) {
        if (result.hasErrors()) {
            //model.addAttribute("categories", categoryService.getAllCategories());
            model.addAttribute("measurements", measurementService.getAllMeasurements());
            return "feedback/feedback/feedback-form";
        }else {
            //for success submit form
            feedbackService.saveFeedback(feedback);
            return "feedback/feedback/success-submit-satisfaction";
        }
    }

    @GetMapping("/report")
    public String getFeedbackReport(Model model) {
        model.addAttribute("categories", measurementService.getAllMeasurements().stream().collect(Collectors.groupingBy(m -> m.getCategory().getName())));
        model.addAttribute("feedbacks", feedbackService.getAllFeedbacks());
        return "feedback/feedback/feedback_report";
    }
//    @GetMapping("/feedback/report")
//    public String getFeedbackReport(Model model) {
//        List<Feedback> feedbackList = feedbackService.getAllFeedbacks();
//        model.addAttribute("feedbacks", feedbackList);
//        return "feedback_report";
//    }
}
