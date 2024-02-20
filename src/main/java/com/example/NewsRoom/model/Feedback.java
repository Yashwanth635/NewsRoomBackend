package com.example.NewsRoom.model;

import jakarta.persistence.*;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String message;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

     // Feedback message

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
//        System.out.println("aaaaa");

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Feedback(Long id, String message) {
        this.id = id;
        this.message = message;

    }
}
