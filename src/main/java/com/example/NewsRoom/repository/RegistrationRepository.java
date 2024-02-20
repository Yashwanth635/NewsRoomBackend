package com.example.NewsRoom.repository;

import com.example.NewsRoom.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration,String> {
    Registration findByEmail(String email);

    boolean existsByEmail(String email);
}
