package com.Robosoft.foursquare.controller;

import com.Robosoft.foursquare.dto.request.HotelRequest;
import com.Robosoft.foursquare.dto.response.HotelResponse;
import com.Robosoft.foursquare.dto.response.ResponseDTO;
import com.Robosoft.foursquare.services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private HotelServices hotelServices;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResponseDTO<Void>> addAHotel(@RequestBody HotelRequest hotelRequest) {
        return hotelServices.addAHotel(hotelRequest);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<ResponseDTO<List<HotelResponse>>> getHotelByCity(@PathVariable String city){
        return hotelServices.getHotelListBySearch(city);
    }

    @GetMapping("/id/{hotelId}")
    public ResponseEntity<ResponseDTO<HotelResponse>> getHotelById(@PathVariable Long hotelId){
        return hotelServices.getHotelById(hotelId);
    }


}
