package com.Robosoft.foursquare.dto.response;

import com.Robosoft.foursquare.modal.Category;
import com.Robosoft.foursquare.modal.Hotel;
import com.Robosoft.foursquare.modal.Review;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelResponse {

    private Long id;

    private String name;

    private String address;

    private String city;

    private String hours;

    private List<Category> categories = new ArrayList<>();

    private List<Review> reviews;

    public HotelResponse(Hotel hotel){
        this.id = hotel.getId();
        this.name = hotel.getName();
        this.city = hotel.getCity();
        this.hours = hotel.getHours();
        this.categories = hotel.getCategories();
        this.address = hotel.getAddress();
        this.reviews = hotel.getReviews();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getHours() {
        return hours;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
