package com.Robosoft.foursquare.controller;

import com.Robosoft.foursquare.dto.request.HotelRequest;
import com.Robosoft.foursquare.dto.response.HotelResponse;
import com.Robosoft.foursquare.dto.response.ResponseDTO;
import com.Robosoft.foursquare.services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel/")
public class HotelController {

    @Autowired
    private HotelServices hotelServices;

    @PostMapping
    public ResponseEntity<ResponseDTO<Void>> addAHotel(@RequestBody HotelRequest hotelRequest) {
        return hotelServices.addAHotel(hotelRequest);
    }

    @GetMapping("{city}/")
    public ResponseEntity<ResponseDTO<List<HotelResponse>>> getHotelByCity(@PathVariable String city){
        return hotelServices.getHotelListBySearch(city);
    }

}
