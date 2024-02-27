package com.example.NewsRoom.repository;

import com.example.NewsRoom.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,String> {
    Admin findByEmail(String email);

    boolean existsByEmail(String email);
}
