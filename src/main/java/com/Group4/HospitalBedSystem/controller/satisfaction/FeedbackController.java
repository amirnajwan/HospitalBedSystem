package com.Group4.HospitalBedSystem.controller.satisfaction;

import com.Group4.HospitalBedSystem.entity.satification.*;
import com.Group4.HospitalBedSystem.service.satisfaction.*;
import com.Group4.HospitalBedSystem.dto.response.satisfication.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private MeasurementService measurementService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/api/v1/submitFeedback")
    public ResponseEntity<?> submitFeedback(@RequestBody FeedbackEntity feedbackEntity) {
        return feedbackService.submitFeedback(feedbackEntity);}

    @GetMapping("/api/v1/feedbackCount")
    public ResponseEntity<?> getFeedbackCount(@RequestParam int categoryId, @RequestParam int measurementId) {
        long count = feedbackService.getTotalFeedbackCount(categoryId, measurementId);
        return ResponseEntity.ok(count);
    }

//    @GetMapping
//    public String getFeedbackForm(Model model) {
//        model.addAttribute("categories", measurementService.getAllMeasurements().stream().collect(Collectors.groupingBy(m -> m.getCategory().getName())));
//        return "feedback/feedback/feedback-form";
//    }

//    @GetMapping
//    public String showFeedbackForm(Model model) {
//        model.addAttribute("feedback", new Feedback());
//       // model.addAttribute("categories", categoryService.getAllCategories());
//        model.addAttribute("measurements", measurementService.getAllMeasurements());
//        return "feedback/feedback/feedback-form";
//    }

//    @PostMapping
//    public String submitFeedback(@ModelAttribute FeedbackDTO feedbackDTO) {
//        Feedback feedback = new Feedback();
//        feedback.setRating(feedbackDTO.getRating());
//        feedback.setMeasurement(measurementService.getMeasurementById(feedbackDTO.getMeasurementId()));
//        feedbackService.saveFeedback(feedback);
//        return "redirect:/feedback";
//    }
//    @PostMapping
//    public String submitFeedback(@ModelAttribute("feedback") Feedback feedback, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            //model.addAttribute("categories", categoryService.getAllCategories());
//            model.addAttribute("measurements", measurementService.getAllMeasurements());
//            return "feedback/feedback/feedback-form";
//        }else {
//            //for success submit form
//            feedbackService.saveFeedback(feedback);
//            return "feedback/feedback/success-submit-satisfaction";
//        }
//    }
//
//    @GetMapping("/report")
//    public String getFeedbackReport(Model model) {
//        model.addAttribute("categories", measurementService.getAllMeasurements().stream().collect(Collectors.groupingBy(m -> m.getCategory().getName())));
//        model.addAttribute("feedbacks", feedbackService.getAllFeedbacks());
//        return "feedback/feedback/feedback_report";
//    }
//    @GetMapping("/feedback/report")
//    public String getFeedbackReport(Model model) {
//        List<Feedback> feedbackList = feedbackService.getAllFeedbacks();
//        model.addAttribute("feedbacks", feedbackList);
//        return "feedback_report";
//    }
}
