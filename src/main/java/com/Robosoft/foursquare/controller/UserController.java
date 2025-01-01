package com.Robosoft.foursquare.controller;

import com.Robosoft.foursquare.dto.request.ReviewRequest;
import com.Robosoft.foursquare.dto.request.UserLoginRequest;
import com.Robosoft.foursquare.dto.request.UserRegisterRequest;
import com.Robosoft.foursquare.dto.response.ResponseDTO;
import com.Robosoft.foursquare.dto.response.UserLoginResponse;
import com.Robosoft.foursquare.dto.response.UserRegisterResponse;
import com.Robosoft.foursquare.modal.Hotel;
import com.Robosoft.foursquare.modal.Review;
import com.Robosoft.foursquare.modal.User;
import com.Robosoft.foursquare.repository.HotelRepository;
import com.Robosoft.foursquare.repository.ReviewRepository;
import com.Robosoft.foursquare.repository.UserRepository;
import com.Robosoft.foursquare.services.UserServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelRepository hotelRepository;


    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserServices userServices;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO<UserRegisterResponse>> registerAUser(@Valid @RequestBody UserRegisterRequest request){
        return userServices.registerUser(request);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<UserLoginResponse>> registerAUser(@Valid @RequestBody UserLoginRequest request){
        return userServices.loginUser(request);
    }

//    @GetMapping
//    public Object addaUser(@Valid @RequestBody UserRegisterRequest userRegisterRequest){
//        User newUser = new User(userRegisterRequest);
//        userRepository.save(newUser);
//        return null;
//    }

    @PostMapping("/review/{hotelId}")
    public ResponseEntity<ResponseDTO<Void>> addAReview(@RequestBody ReviewRequest reviewRequest, HttpServletRequest request, @PathVariable Long hotelId){
        return userServices.addAReview(request,hotelId,reviewRequest);
    }

}
