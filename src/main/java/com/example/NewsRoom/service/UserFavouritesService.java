package com.example.NewsRoom.service;

import com.example.NewsRoom.model.Registration;
import com.example.NewsRoom.model.UserFavourites;
import com.example.NewsRoom.repository.RegistrationRepository;
import com.example.NewsRoom.repository.UserFavouritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserFavouritesService {
    @Autowired
    private UserFavouritesRepository userFavoritesRepository;

    public List<UserFavourites> getUserFavoritesByEmail(String email) {
        return userFavoritesRepository.findByEmail(email);
    }

    public void saveUserFavorites(UserFavourites userFavorites) {
        userFavoritesRepository.save(userFavorites);
    }
}
