package com.example.NewsRoom.model;
import org.springframework.security.crypto.bcrypt.BCrypt;

import jakarta.persistence.*;

@Entity
@Table(name="Register")
public class Registration {
    @Id
    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "Full Name")
    private String Fname;

    @Column(name = "Last Name")
    private String Lname;

    @Column(name = "password")
    private String passwordHash; // Changed to store hashed password

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    // Update setPassword method to hash the password before setting it
    public void setPassword(String password) {
        this.passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Method to verify password
    public boolean verifyPassword(String candidatePassword) {
        return BCrypt.checkpw(candidatePassword, this.passwordHash);
    }

    @Override
    public String toString() {
        return "Registration [fullName=" + Fname + ", lastName=" + Lname + ", email=" + email + ", password=" + passwordHash + "]";
    }
}