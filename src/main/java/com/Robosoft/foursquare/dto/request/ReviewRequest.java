package com.Robosoft.foursquare.dto.request;

import com.Robosoft.foursquare.modal.Review;
import jakarta.validation.constraints.NotNull;

public class ReviewRequest {

//    @NotNull(message = "User ID cannot be null")
//    private Long userId;

//    @NotNull(message = "Hotel ID cannot be null")
//    private Long hotelId;

    @NotNull(message = "Review content cannot be null")
    private String review;

//    public Long getUserId() {
//        return userId;
//    }

//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public Long getHotelId() {
//        return hotelId;
//    }
//
//    public void setHotelId(Long hotelId) {
//        this.hotelId = hotelId;
//    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
    public ReviewRequest(String review){
        this.review = review;
    }
}
