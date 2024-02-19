package com.example.NewsRoom.service;

import ch.qos.logback.core.boolex.Matcher;
import com.example.NewsRoom.model.Registration;
import com.example.NewsRoom.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private final RegistrationRepository registrationRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }
    public void registerUser(Registration registration) {

        registrationRepository.save(registration);
    }

    public boolean authenticateUser(Registration registration) {
        Registration existingUser = registrationRepository.findByEmail(registration.getEmail());
        System.out.println("EMail :"+existingUser);
        if (existingUser.getEmail() != null) {
            System.out.println("EMail :"+existingUser.getEmail());
            System.out.println("Provided Password: " + registration.getPassword());
            System.out.println("Provided Password: " + existingUser.getPassword());


            return passwordEncoder.matches(registration.getPassword(), existingUser.getPassword());
        }
        return false;
    }

}
