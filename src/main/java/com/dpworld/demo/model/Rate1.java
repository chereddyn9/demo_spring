package com.dpworld.demo.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class Rate1 implements Serializable{

	private Long id;
	private String rateDescription;
	private String rateEffectiveDate;
	private String  rateExpirationDate;
	private Integer amount;

	public Rate1(Long id, String rateDescription, String rateEffectiveDate, String rateExpirationDate, Integer amount) {
		this.id = id;
		this.rateDescription = rateDescription;
		this.rateEffectiveDate = rateEffectiveDate;
		this.rateExpirationDate = rateExpirationDate;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRateDescription() {
		return rateDescription;
	}

	public void setRateDescription(String rateDescription) {
		this.rateDescription = rateDescription;
	}

	public String getRateEffectiveDate() {
		return rateEffectiveDate;
	}

	public void setRateEffectiveDate(String rateEffectiveDate) {
		this.rateEffectiveDate = rateEffectiveDate;
	}

	public String getRateExpirationDate() {
		return rateExpirationDate;
	}

	public void setRateExpirationDate(String rateExpirationDate) {
		this.rateExpirationDate = rateExpirationDate;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
