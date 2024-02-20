//package com.example.NewsRoom.model;
//
//import jakarta.persistence.*;
//
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "UserFavourites")
//public class UserFavourites {
//
//    @EmbeddedId
//    private UserFavouriteKeys id;
//
//    // Other fields, if any
//
//    @ManyToOne
//    @MapsId("email")
//    private Registration registration;
//
//    // Constructors, getters, and setters
//
//    public UserFavourites() {
//        this.id = new UserFavouriteKeys();
//    }
//
//    public UserFavouriteKeys getId() {
//        return id;
//    }
//
//    public void setId(UserFavouriteKeys id) {
//        this.id = id;
//    }
//
//    public String getFavouritesURL() {
//        return id.getFavouritesURL();
//    }
//
//    public void setFavouritesURL(String favouritesURL) {
//        id.setFavouritesURL(favouritesURL);
//    }
//
//    public Registration getRegistration() {
//        return registration;
//    }
//
//    public void setRegistration(Registration registration) {
//        this.registration = registration;
//    }
//}
