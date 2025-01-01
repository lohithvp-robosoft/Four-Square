package com.Robosoft.foursquare.services;

import com.Robosoft.foursquare.dto.request.HotelRequest;
import com.Robosoft.foursquare.dto.response.HotelResponse;
import com.Robosoft.foursquare.dto.response.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelServices {

    ResponseEntity<ResponseDTO<Void>> addAHotel(HotelRequest hotelRequest);

    ResponseEntity<ResponseDTO<List<HotelResponse>>> getHotelListBySearch(String city);
}
