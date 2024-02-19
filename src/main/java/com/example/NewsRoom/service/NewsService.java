package com.example.NewsRoom.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class NewsService {
    private final RestTemplate restTemplate;
    public NewsService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<String> getNews() {
        String url = "https://gnews.io/api/v4/top-headlines?category=general&lang=en&country=us&max=10&apikey=868eff1cf6b2c754da64a0ae4cfc7364";
        return restTemplate.getForEntity(url, String.class);
    }
    public ResponseEntity<String> searchNews(String category) {
        String url = "https://gnews.io/api/v4/top-headlines?category="+category+"&lang=en&country=us&max=10&apikey=868eff1cf6b2c754da64a0ae4cfc7364";
        return restTemplate.getForEntity(url, String.class);
    }
    public ResponseEntity<String> listArticles(String query) {
        String url = "https://gnews.io/api/v4/top-headlines?category="+query+"&lang=en&country=us&max=10&apikey=868eff1cf6b2c754da64a0ae4cfc7364";
        return restTemplate.getForEntity(url, String.class);
    }
}
