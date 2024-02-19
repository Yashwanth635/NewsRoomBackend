package com.example.NewsRoom.repository;

import com.example.NewsRoom.model.UserFavouriteKeys;
import com.example.NewsRoom.model.UserFavourites;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFavouritesRepository extends JpaRepository<UserFavourites, UserFavouriteKeys> {
    List<UserFavourites> findByEmail(String email);
}
