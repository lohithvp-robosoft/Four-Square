package com.Robosoft.foursquare.utils;

import com.Robosoft.foursquare.dto.response.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
//import org.springframework..Component;

@Component
public class ResponseUtil {

    public <T> ResponseEntity<ResponseDTO<T>> successResponse(T responseData) {
        return new ResponseEntity<>(new ResponseDTO<>(0, 200, "Success", responseData), HttpStatus.OK);
    }

    // Method without data (returns Void)
    public ResponseEntity<ResponseDTO<Void>> successResponse() {
        return new ResponseEntity<>(new ResponseDTO<>(0, 200, "Success", null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO<Void>> successResponse(String message) {
        return new ResponseEntity<>(new ResponseDTO<>(0, 200, message, null), HttpStatus.OK);
    }


//    public <T> ResponseEntity<ResponseDTO<T>> successResponse(T responseData, String message) {
//        return new ResponseEntity<>(new ResponseDTO<>(0, 200, message, responseData), HttpStatus.OK);
//    }

//    public ResponseEntity<ResponseDTO<Void>> errorResponse() {
//        return new ResponseEntity<>(new ResponseDTO<>(-1, 404, "Fail", null), HttpStatus.NOT_FOUND);
//    }
//
//    public ResponseEntity<ResponseDTO<Void>> errorResponse(String message) {
//        return new ResponseEntity<>(new ResponseDTO<>(-1, 404, message, null), HttpStatus.NOT_FOUND);
//    }
//
//    public ResponseEntity<ResponseDTO<Void>> errorResponse(String message, int statusCode) {
//        return new ResponseEntity<>(new ResponseDTO<>(-1, statusCode, message, null), HttpStatusCode.valueOf(statusCode));
//    }
}
