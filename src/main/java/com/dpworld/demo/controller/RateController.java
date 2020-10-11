package com.dpworld.demo.controller;

import javax.validation.Valid;

import com.dpworld.demo.model.Rate1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import com.dpworld.demo.exception.RateDemoException;
import com.dpworld.demo.model.Rate;
import com.dpworld.demo.service.RateService;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/surcharge")
public class RateController {
	
	@Autowired
	private RateService rateService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RateController.class);
	
	@GetMapping("/{id}")
    public ResponseEntity<Rate> searchByRateId(@PathVariable("id") Long rateId) throws RateDemoException {
		LOGGER.info("search controller called....");
		Rate rate = rateService.searchByRateId(rateId);
        return new ResponseEntity<>(rate, HttpStatus.OK);
    }
	
	@PostMapping
    public void createRate(@Valid @RequestBody Rate rate) throws RateDemoException{
		rateService.createRate(rate);
    }
	@PutMapping
    public void updateRate(@Valid @RequestBody Rate rate) throws RateDemoException{
		rateService.updateRate(rate);
    }
	
	@DeleteMapping("/{id}")
    public void deleteRate(@PathVariable("id") Long rateId) throws RateDemoException{
		rateService.deleteRate(rateId);
    }
}
