package com.Robosoft.foursquare.modal;

import com.Robosoft.foursquare.dto.request.HotelRequest;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Log4j2
@Getter
@Setter
@AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    private String hours;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "hotel")
    private List<Review> reviews;

    public Hotel(HotelRequest hotelRequest) {
        this.name = hotelRequest.getName();
        this.address = hotelRequest.getAddress();
        this.city = hotelRequest.getCity();
        this.hours = hotelRequest.getHours();
        this.categories = hotelRequest.getCategories();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Hotel() {
    }

    @Override
    public String toString() {
        return this.hours;
//        return super.toString();
    }
}