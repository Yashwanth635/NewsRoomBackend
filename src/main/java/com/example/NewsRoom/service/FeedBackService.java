package com.example.NewsRoom.service;

import com.example.NewsRoom.model.Feedback;
import com.example.NewsRoom.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FeedBackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Transactional
    public void submitFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }
}
