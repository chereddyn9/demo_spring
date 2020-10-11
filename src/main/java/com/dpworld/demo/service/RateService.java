package com.dpworld.demo.service;

import org.springframework.stereotype.Service;

import com.dpworld.demo.exception.RateDemoException;
import com.dpworld.demo.model.Rate;

@Service
public interface RateService {
	
	Rate searchByRateId(Long rateId) throws RateDemoException;
	
	void createRate(Rate rate) throws RateDemoException;
	
	void updateRate(Rate rate) throws RateDemoException;
	
	void deleteRate(Long rateId)throws RateDemoException;

}
