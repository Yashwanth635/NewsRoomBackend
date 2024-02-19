package com.example.NewsRoom.controller;

import com.example.NewsRoom.model.Registration;
import com.example.NewsRoom.model.UserFavourites;
import com.example.NewsRoom.service.RegistrationService;
import com.example.NewsRoom.service.UserFavouritesService;
import com.example.NewsRoom.service.UserFavouritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class UserFavouritesController {
    @Autowired
    private UserFavouritesService userFavoritesService;

    @GetMapping("/user")
    public ResponseEntity<List<UserFavourites>> getUserFavoritesByEmail(@RequestParam String email) {
        List<UserFavourites> userFavorites = userFavoritesService.getUserFavoritesByEmail(email);
        if (userFavorites.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(userFavorites);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUserFavorites(@RequestBody UserFavourites userFavorites) {
        userFavoritesService.saveUserFavorites(userFavorites);
        return ResponseEntity.ok("Favorite added successfully");
    }
}