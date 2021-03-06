package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    ApiRequestException are = new ApiRequestException();
    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        //1. create payload containing exception and details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException api = new ApiException(e.getMessage(), are.getErrorCode(), ZonedDateTime.now(ZoneId.of("Z")));
        //2. return response entity
        return new ResponseEntity<>(api, badRequest);
    }
}
