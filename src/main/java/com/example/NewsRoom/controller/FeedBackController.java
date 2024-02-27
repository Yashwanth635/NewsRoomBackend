package com.example.NewsRoom.controller;

import com.example.NewsRoom.model.Feedback;
import com.example.NewsRoom.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {
    @Autowired
    private FeedBackService feedbackService;

    @Autowired
    private HttpSession httpSession;

    @Transactional
    @PostMapping("/submit")
    public void submitFeedback(@RequestBody Feedback feedback) {
        String userEmail = (String) httpSession.getAttribute("email");
        System.out.println("User Email from session: " + userEmail); // Debugging code

        if (userEmail != null) {
            feedback.setEmail(userEmail); // Set the user's email in the feedback
            System.out.println("Feedback received from: " + userEmail);
            feedbackService.submitFeedback(feedback);
        } else {
            throw new IllegalStateException("User must be logged in to submit feedback");
        }
    }
}
