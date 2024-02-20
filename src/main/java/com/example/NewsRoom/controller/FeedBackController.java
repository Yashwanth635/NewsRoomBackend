package com.example.NewsRoom.controller;

import com.example.NewsRoom.model.Feedback;
import com.example.NewsRoom.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {
    @Autowired
    private FeedBackService feedbackService;

    @Transactional
    @PostMapping("/submit")
    public void submitFeedback(@RequestBody Feedback feedback) {
        System.out.println(feedback.getEmail() + feedback.getMessage());
        feedbackService.submitFeedback(feedback);
    }
}
