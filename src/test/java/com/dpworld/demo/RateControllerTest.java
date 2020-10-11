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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.dpworld.demo.controller.RateController;
import com.dpworld.demo.model.Rate;
import com.dpworld.demo.service.RateServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class RateControllerTest {

	@InjectMocks
	private RateController rateControllerMock;
	@Mock
	private RateServiceImpl rateServiceImplMock;
	
	
	@Test
	public void t() throws Exception {
	when(rateServiceImplMock.searchByRateId(any())).thenReturn(populateRate());
	ResponseEntity<Rate> rate = rateControllerMock.searchByRateId(1l);
	assertNotNull(rate);
	assertEquals(100, rate.getBody().getAmount());
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
}
