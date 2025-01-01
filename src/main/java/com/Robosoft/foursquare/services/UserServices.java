package com.Robosoft.foursquare.services;

import com.Robosoft.foursquare.dto.request.ReviewRequest;
import com.Robosoft.foursquare.dto.request.UserLoginRequest;
import com.Robosoft.foursquare.dto.request.UserRegisterRequest;
import com.Robosoft.foursquare.dto.response.ResponseDTO;
import com.Robosoft.foursquare.dto.response.UserLoginResponse;
import com.Robosoft.foursquare.dto.response.UserRegisterResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserServices {

    Object addAUser();

    ResponseEntity<ResponseDTO<UserRegisterResponse>> registerUser(UserRegisterRequest userRegisterRequest);

    ResponseEntity<ResponseDTO<UserLoginResponse>> loginUser(UserLoginRequest userLoginRequest);

    ResponseEntity<ResponseDTO<Void>> addAReview(HttpServletRequest request, Long hotelId, ReviewRequest reviewRequest);
}
