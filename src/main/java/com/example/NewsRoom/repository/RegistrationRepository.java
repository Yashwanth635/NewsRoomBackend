package com.example.NewsRoom.repository;

import com.example.NewsRoom.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration,String> {
    Optional<Registration> findByEmail(String email);

    boolean existsByEmail(String email);
}
