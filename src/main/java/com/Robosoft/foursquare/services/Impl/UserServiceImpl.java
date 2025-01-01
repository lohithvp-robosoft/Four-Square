package com.Robosoft.foursquare.services.Impl;

import com.Robosoft.foursquare.dto.request.ReviewRequest;
import com.Robosoft.foursquare.dto.request.UserLoginRequest;
import com.Robosoft.foursquare.dto.request.UserRegisterRequest;
import com.Robosoft.foursquare.dto.response.ResponseDTO;
import com.Robosoft.foursquare.dto.response.UserLoginResponse;
import com.Robosoft.foursquare.dto.response.UserRegisterResponse;
import com.Robosoft.foursquare.exception.EmailAlreadyExistsException;
import com.Robosoft.foursquare.exception.InvalidCredentialsException;
import com.Robosoft.foursquare.exception.NotFoundException;
import com.Robosoft.foursquare.jwt.JwtUtils;
import com.Robosoft.foursquare.modal.Hotel;
import com.Robosoft.foursquare.modal.Review;
import com.Robosoft.foursquare.modal.User;
import com.Robosoft.foursquare.repository.HotelRepository;
import com.Robosoft.foursquare.repository.ReviewRepository;
import com.Robosoft.foursquare.repository.UserRepository;
import com.Robosoft.foursquare.services.UserServices;
import com.Robosoft.foursquare.utils.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResponseUtil responseUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Object addAUser() {
        return null;
    }

    @Override
    public ResponseEntity<ResponseDTO<UserRegisterResponse>> registerUser(UserRegisterRequest userRegisterRequest) {

        if (userRepository.existsByEmail(userRegisterRequest.getEmail())) throw new EmailAlreadyExistsException();

        User newUser = new User(userRegisterRequest, passwordEncoder.encode(userRegisterRequest.getPassword()));
        userRepository.save(newUser);
        return responseUtil.successResponse(new UserRegisterResponse(newUser), "Registration Successfully");
    }

    @Override
    public ResponseEntity<ResponseDTO<UserLoginResponse>> loginUser(UserLoginRequest userLoginRequest) {
        User user = userRepository.findByEmail(userLoginRequest.getEmail()).orElseThrow(InvalidCredentialsException::new);

        if (!passwordEncoder.matches(userLoginRequest.getPassword(), user.getPassword()))
            throw new InvalidCredentialsException();

        String token = jwtUtils.generateTokenFromUserDetails(user, user.getId().toString());

        return responseUtil.successResponse(new UserLoginResponse(user, token));
    }

    @Override
    public ResponseEntity<ResponseDTO<Void>> addAReview(HttpServletRequest request, Long hotelId, ReviewRequest reviewRequest) {

        Long userId = Long.valueOf(jwtUtils.getUserIdFromJwtToken(jwtUtils.getJwtFromHeader(request)));

        User user = userRepository.findById(userId).get();
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new NotFoundException("Hotel Not Found"));

        Review review = new Review(reviewRequest, user, hotel);

        reviewRepository.save(review);
        return responseUtil.successResponse("Review successfully added");
    }

}
