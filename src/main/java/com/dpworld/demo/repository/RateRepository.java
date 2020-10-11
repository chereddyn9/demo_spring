package com.dpworld.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dpworld.demo.model.RateEntity;


@Repository
public interface RateRepository extends JpaRepository<RateEntity, Long>{

	
}
