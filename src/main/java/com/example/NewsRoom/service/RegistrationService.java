package com.example.NewsRoom.service;

import ch.qos.logback.core.boolex.Matcher;
import com.example.NewsRoom.model.Registration;
import com.example.NewsRoom.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private final RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public void registerUser(Registration registration) {
        if (registrationRepository.existsByEmail(registration.getEmail())) {
            throw new IllegalArgumentException("User with this email already exists");
        }
        registrationRepository.save(registration);
    }

    public boolean authenticateUser(Registration registration) {
        Registration existingUser = registrationRepository.findByEmail(registration.getEmail());
        return existingUser != null && registration.getPassword().equals(existingUser.getPassword());
    }
}
