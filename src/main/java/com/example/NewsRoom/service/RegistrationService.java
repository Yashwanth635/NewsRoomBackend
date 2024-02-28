package com.example.NewsRoom.service;

import ch.qos.logback.core.boolex.Matcher;
import com.example.NewsRoom.model.Registration;
import com.example.NewsRoom.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.util.Optional;


import java.util.List;

@Service
public class RegistrationService {
    @Autowired
    private final RegistrationRepository registrationRepository;
//    private List<Registration> registeredUsers;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public void registerUser(Registration registration) {
        registrationRepository.save(registration);
    }
//public boolean isUserRegistered(String email) {
//    for (Registration user : registeredUsers) {
//        if (user.getEmail().equals(email)) {
//            return true;
//        }
//    }
//    return false;
//}
public boolean authenticateUser(String email, String password) {
    Registration registration = registrationRepository.findByEmail(email).orElse(null);
    if (registration != null) {
        return BCrypt.checkpw(password, registration.getPasswordHash());
    }
    return false;
}



    public List<Registration> getAllUsers() {
        return registrationRepository.findAll();
    }

    public void deleteUserByEmail(String email) {
        Optional<Registration> optionalUser = registrationRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            Registration user = optionalUser.get();
            registrationRepository.delete(user);
        } else {
            throw new UserNotFoundException("User with email " + email + " not found");
        }
    }

}
