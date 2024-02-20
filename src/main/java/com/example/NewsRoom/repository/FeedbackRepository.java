package com.example.NewsRoom.repository;

import com.example.NewsRoom.model.Feedback;
import com.example.NewsRoom.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
