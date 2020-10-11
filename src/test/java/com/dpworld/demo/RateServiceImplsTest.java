package com.dpworld.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import com.dpworld.demo.controller.RateController;
import com.dpworld.demo.exception.RateDemoException;
import com.dpworld.demo.model.Rate;
import com.dpworld.demo.model.RateEntity;
import com.dpworld.demo.repository.RateRepository;
import com.dpworld.demo.service.RateServiceImpl;

import jdk.nashorn.internal.runtime.regexp.joni.ast.AnyCharNode;

@RunWith(MockitoJUnitRunner.class)
public class RateServiceImplsTest {

	@InjectMocks
	private RateServiceImpl rateServiceImplMock;
	@Mock
	private RateRepository rateRepositoryMock;
	@Mock
	private ModelMapper modelMapper;
	
	
	@Test
	public void testSearchRate() throws Exception {
	when(rateRepositoryMock.findById(any())).thenReturn(populateRateEntity());
	when(modelMapper.map(any(), any())).thenReturn(populateRate());
	Rate rate = rateServiceImplMock.searchByRateId(1l);
	assertNotNull(rate);
	assertEquals(100, rate.getAmount());
	}
	@Test(expected = Exception.class)
	public void testSearchRateExceptoin() throws Exception {
	when(rateRepositoryMock.findById(any())).thenThrow(RateDemoException.class);
	when(modelMapper.map(any(), any())).thenReturn(populateRate());
	Rate rate = rateServiceImplMock.searchByRateId(1l);
	}

	private Rate populateRate() {
		Rate rate = new Rate();
		rate.setId(1l);
		rate.setAmount(100);
		rate.setRateDescription("testing");
		rate.setRateEffectiveDate(new Date());
		rate.setRateExpirationDate(new Date());
		return rate;
	}
	
	private Optional<RateEntity> populateRateEntity() {
		List<RateEntity> rateList = new ArrayList<>();
		RateEntity rate = new RateEntity();
		rate.setId(1l);
		rate.setAmount(100);
		rate.setRateDescription("testing");
		rate.setRateEffectiveDate(new Date());
		rate.setRateExpirationDate(new Date());
		rateList.add(rate);
		Optional<RateEntity> rateEnt = rateList.stream().findAny();
		return rateEnt;
	}
}
