package com.Robosoft.foursquare.services.Impl;

import com.Robosoft.foursquare.dto.request.HotelRequest;
import com.Robosoft.foursquare.dto.response.HotelResponse;
import com.Robosoft.foursquare.dto.response.ResponseDTO;
import com.Robosoft.foursquare.modal.Hotel;
import com.Robosoft.foursquare.repository.HotelRepository;
import com.Robosoft.foursquare.services.HotelServices;
import com.Robosoft.foursquare.utils.ResponseUtil;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
//import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelServices {

    private static final Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);   // Default logger
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ResponseUtil responseUtil;

    @Override
    public ResponseEntity<ResponseDTO<Void>> addAHotel(HotelRequest hotelRequest) {
        Hotel hotel = new Hotel(hotelRequest);
        hotelRepository.save(hotel);
//        return new ResponseEntity<>("Hello", HttpStatusCode.valueOf(200));
        return responseUtil.successResponse("Successfully Added hotel to the DB");
    }

    @Override
    public ResponseEntity<ResponseDTO<List<HotelResponse>>> getHotelListBySearch(String city) {
        List<Hotel> hotelList = hotelRepository.findByCity(city).orElseThrow(()->new RuntimeException("NO Hotel Present in this location"));
        System.out.println(hotelList);
        List<HotelResponse> hotelResponseList = new ArrayList<>();
        for(Hotel hotel : hotelList){
//            log.info(hotel.getName());
            logger.debug("Hello "+hotel.getAddress());
            hotelResponseList.add(new HotelResponse(hotel));
        }
        return responseUtil.successResponse(hotelResponseList);
    }
}