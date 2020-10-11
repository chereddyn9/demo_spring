package com.dpworld.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Rate implements Serializable{

	private Long id;
	private String rateDescription;
	@NotNull(message = "Please provide a name")
	private Date rateEffectiveDate;
	@NotNull(message = "Please provide a rateExpirationDate")
	private Date rateExpirationDate;
	@NotNull(message = "Please provide a name")
	private Integer amount;
	
	
	public Rate() {
		super();
	}

	public Rate(Long id, String rateDescription, @NotEmpty(message = "Please provide a name") Date rateEffectiveDate,
			@NotEmpty(message = "Please provide a name") Date rateExpirationDate,
			@NotEmpty(message = "Please provide a name") Integer amount) {
		super();
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
	public Date getRateEffectiveDate() {
		return rateEffectiveDate;
	}
	public void setRateEffectiveDate(Date rateEffectiveDate) {
		this.rateEffectiveDate = rateEffectiveDate;
	}
	public Date getRateExpirationDate() {
		return rateExpirationDate;
	}
	public void setRateExpirationDate(Date rateExpirationDate) {
		this.rateExpirationDate = rateExpirationDate;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
}
