package com.example.restapidigitalvideostore.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("movies")
public class Movie {

    @Id
    private String id;
    private String title;
    private String description;
    private String rating;
    private String poster;
    private String dateReleased;
    private Integer buy;
    private Integer rent;
    private Boolean featured;
//
//
//    "id": 1,
//            "title": "Avengers",
//    "description": "blah blah blah",
//    "rating": "3.5"
//            "poster": "avengers.jpg",
//
//            "dateReleased": "June 2012",
//           "buy":12.99,
//    "rent": 3.99,
//    "featured": true

    public Movie() {
    }

   // public Movie( String title, String description, String rating, String poster, String dateReleased, Integer buy, Integer rent, Boolean featured) {
   public Movie(String id, String title, String description, String rating, String poster, String dateReleased, Integer buy, Integer rent, Boolean featured) {

                this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.poster = poster;
        this.dateReleased = dateReleased;
        this.buy = buy;
        this.rent = rent;
        this.featured = featured;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(String dateReleased) {
        this.dateReleased = dateReleased;
    }

    public Integer getBuy() {
        return buy;
    }

    public void setBuy(Integer buy) {
        this.buy = buy;
    }

    public Integer getRent() {
        return rent;
    }

    public void setRent(Integer rent) {
        this.rent = rent;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                ", poster='" + poster + '\'' +
                ", dateReleased='" + dateReleased + '\'' +
                ", buy=" + buy +
                ", rent=" + rent +
                ", featured=" + featured +
                '}';
    }
}
