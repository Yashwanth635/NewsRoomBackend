package com.example.NewsRoom.controller;

import com.example.NewsRoom.service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/getNews")
    public ResponseEntity<String> getNews() {
        return newsService.getNews();
    }
    @GetMapping("/search")
    public ResponseEntity<String> searchNews(@RequestParam String category) {
        return newsService.searchNews(category);
    }
    @GetMapping("/listArticles")
    public ResponseEntity<String> listArticles(@RequestParam String query) {
        return newsService.listArticles(query);
    }
}
