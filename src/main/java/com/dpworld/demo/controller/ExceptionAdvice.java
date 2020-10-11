package com.dpworld.demo.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dpworld.demo.exception.RateDemoException;
import com.dpworld.demo.model.CustomErrorResponse;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(value = RateDemoException.class)
    public ResponseEntity<CustomErrorResponse> handleGenericNotFoundException(RateDemoException e) {
        CustomErrorResponse error = new CustomErrorResponse();
        error.setTimestamp(LocalDateTime.now());
        error.setStatus((HttpStatus.NOT_FOUND.value()));
        error.setErrorCode(e.getErrorCode());
        error.setErrorMsg(e.getErrorMsg());
        if(e.getErrorCode().equals("500")) {
        	error.setStatus((HttpStatus.INTERNAL_SERVER_ERROR.value()));
        	return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
        	return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
        
    }   
}