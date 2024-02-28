package com.example.NewsRoom.controller;

import com.example.NewsRoom.model.Registration;
import com.example.NewsRoom.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class RegistrationController{
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Registration registration, HttpSession session) {
        registrationService.registerUser(registration);
        session.setAttribute("email", registration.getEmail());
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password , HttpSession session) {
        if (registrationService.authenticateUser(email,password)) {
            session.setAttribute("email", email);
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate(); // Invalidates the session, effectively ending it
        return ResponseEntity.ok("Logout successful");
    }
}
