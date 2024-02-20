package com.example.NewsRoom.controller;
import com.example.NewsRoom.model.Feedback;
import com.example.NewsRoom.model.Registration;
import com.example.NewsRoom.service.FeedBackService;
import com.example.NewsRoom.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private FeedBackService feedbackService;

    @GetMapping("/users")
    public List<Registration> getAllUsers() {
        return registrationService.getAllUsers();
    }

    @DeleteMapping("/users/{email}")
    public ResponseEntity<?> deleteUserByEmail(@PathVariable String email) {
        registrationService.deleteUserByEmail(email);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/feedback")
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }
}
