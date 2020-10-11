package com.dpworld.demo.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dpworld.demo.exception.RateDemoException;
import com.dpworld.demo.model.Rate;
import com.dpworld.demo.model.RateEntity;
import com.dpworld.demo.repository.RateRepository;
import com.dpworld.demo.service.RateService;

@Service
public class RateServiceImpl implements RateService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RateServiceImpl.class);
	@Autowired
	private RateRepository rateRepository;
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public Rate searchByRateId(Long rateId) throws RateDemoException {
		LOGGER.info("RateServiceImpl searchByRateId called");
		Rate rate = null;
		Optional<RateEntity> rateEntity = rateRepository.findById(rateId);
		if(rateEntity.isPresent()) {
			rate = convertToDTO(rateEntity.get());
		} else {
			throw new RateDemoException("404", "RateId not found in RMS");
		}
		return rate;
	}

	@Override
	@Transactional
	public void createRate(Rate rate) throws RateDemoException {
		try {
			rateRepository.save(convertToEntity(rate));
		} catch (RateDemoException e) {
			throw new RateDemoException("500","Internal server error. Please contact admin");
		}
	}

	
	@Override
	@Transactional
	public void updateRate(Rate rate) throws RateDemoException {
		try {
			rateRepository.save(convertToEntity(rate));
		} catch (RateDemoException e) {
			throw new RateDemoException("500","Internal server error. Please contact admin");
		}
	}

	@Override
	public void deleteRate(Long rateId) throws RateDemoException{
		if(!rateRepository.existsById(rateId)) {
			throw new RateDemoException("404", "RateId not found in RMS");
		}
		rateRepository.deleteById(rateId);
	}
	
	
	private RateEntity convertToEntity(Rate rate) throws RateDemoException {
		return modelMapper.map(rate, RateEntity.class);
	}
	
	private Rate convertToDTO(RateEntity rateEntity) throws RateDemoException {
		return modelMapper.map(rateEntity, Rate.class);
	}
	
}
