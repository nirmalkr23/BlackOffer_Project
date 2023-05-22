package com.spring.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.BlackOffer;


public interface BlackOfferRepository  extends JpaRepository<BlackOffer,Integer> {
	Optional< List<BlackOffer>> findByCity(String city);
	Optional <List<BlackOffer>> findByEnd_year(Integer end_year);
	Optional <List<BlackOffer>>  findByCountry(String country);
	Optional <List<BlackOffer>> findByIntensity(Integer intensity);
	Optional <List<BlackOffer>> findByLikelihood(Integer likelihood);
	Optional <List<BlackOffer>> findByRelevance(String relevance);
	Optional <List<BlackOffer>> findByRegion(String region);
	Optional <List<BlackOffer>>  findByTopic(String topic);
	
	
}
