package com.example.NewsRoom.service;

import com.example.NewsRoom.model.Admin;
import com.example.NewsRoom.model.Registration;
import com.example.NewsRoom.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

//    public void registerAdmin(Admin admin) {
//        if (adminRepository.existsByEmail(admin.getEmail())) {
//            throw new IllegalArgumentException("User with this email already exists");
//        }
//        adminRepository.save(admin);
//    }

    public boolean authenticateUser(Admin admin) {
        Admin existingUser = adminRepository.findByEmail(admin.getEmail());
        return existingUser != null && admin.getPassword().equals(existingUser.getPassword());
    }
}
