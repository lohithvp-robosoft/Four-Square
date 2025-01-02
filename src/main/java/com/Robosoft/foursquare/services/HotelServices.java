package com.Robosoft.foursquare.services;

import com.Robosoft.foursquare.dto.request.hotel.HotelRequest;
import com.Robosoft.foursquare.dto.response.hotel.HotelResponse;
import com.Robosoft.foursquare.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelServices {

    ResponseEntity<ResponseDTO<Void>> addHotel(HotelRequest hotelRequest);

    ResponseEntity<ResponseDTO<List<HotelResponse>>> getHotelListBySearch(String city);

    ResponseEntity<ResponseDTO<HotelResponse>> getHotelById(Long id);

    ResponseEntity<ResponseDTO<HotelResponse>> deleteHotelById(Long id);

    ResponseEntity<ResponseDTO<HotelResponse>> updateHotelById(Long hotelId, HotelRequest updatedHotel);

    ResponseEntity<ResponseDTO<List<HotelResponse>>> getAllHotels();
}
