package com.example.NewsRoom.model;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean verifyPassword(String candidatePassword) {
        return password.equals(candidatePassword);
    }

    @Override
    public String toString() {
        return "Registration [fullName=" + Fname + ", lastName=" + Lname + ", email=" + email + ", password=" + password + "]";
    }
}
