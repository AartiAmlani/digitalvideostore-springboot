package com.example.restapidigitalvideostore.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("tvshows")
public class Tvshow {
//    "id": 1,
//            "title": "Hacks",
//            "description": "Explores a dark mentorship that forms between Deborah Vance, a legendary Las Vegas comedian, and an entitled, outcast 25-year-old.Hacks is an American comedy-drama streaming television series created by Lucia Aniello, Paul W. Downs and Jen Statsky",
//            "rating":"3.5",
//            "poster": "hacksTv.jpg",
//            "dateReleased": "Jan 2000",
//
//            "buy":"$14.99",
//            "rent":"3.99",
//            "featured": false

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

    public Tvshow() {
    }

    public Tvshow(String id, String title, String description, String rating, String poster, String dateReleased, Integer buy, Integer rent, Boolean featured) {
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
}
