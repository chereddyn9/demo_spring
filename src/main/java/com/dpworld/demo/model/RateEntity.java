package com.dpworld.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
 
@Entity
@Table(name="RATE", schema = "dp_world", catalog = "dp_world")
public class RateEntity implements Serializable {
 

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="rate_id")
    private Long id;
     
    @Column(name="rate_desc")
    private String rateDescription;
    
    @Column(name="rate_effective_date")
    private Date rateEffectiveDate;
    
    @Column(name="rate_expiration_date")
    private Date rateExpirationDate;
    
    @Column(name="amount")
    private Integer amount;


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