package com.spring.restController;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.BlackOffer;
import com.spring.repository.BlackOfferRepository;

@RestController
@RequestMapping("data/fetch")
public class DataFetchController {

	@Autowired
	private BlackOfferRepository repo;
	
	ResponseEntity<?> getById(Integer id)
	{
		Optional<BlackOffer> findById = repo.findById(id);
		HashMap<Object, Object> hashMap = new HashMap<>();
		if(findById!=null)
		{
			hashMap.put("statusCode", 401);
			hashMap.put("status", true);
			hashMap.put("Data",findById);
			return ResponseEntity.status(HttpStatus.FOUND).body(hashMap);
		}
		else 
		{
			hashMap.put("statusCode", 404);
			hashMap.put("status", false);
			hashMap.put("message", "Data not found.....!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hashMap);
		}
	}
	
	@GetMapping("/findall")
	ResponseEntity<?> getFindAll()
	{
		HashMap<Object, Object> hashMap = new HashMap<>();
		List<BlackOffer> findAll = repo.findAll();
		if(findAll!=null)
		{
			hashMap.put("statusCode", 401);
			hashMap.put("status", true);
			hashMap.put("Data", findAll);
			return ResponseEntity.status(HttpStatus.FOUND).body(hashMap);
		}
		else 
		{
			hashMap.put("statusCode", 404);
			hashMap.put("status", false);
			hashMap.put("message", "Data not found.....!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hashMap);
		}
		
	}
	
	@GetMapping("/endyear")
	ResponseEntity<?> getEndYear(int end_year)
	{
		HashMap<Object, Object> hashMap = new HashMap<>();
		Optional<List<BlackOffer>> End_year = repo.findByEnd_year(end_year);
		if(End_year.isPresent())
		{
			hashMap.put("statusCode", 401);
			hashMap.put("status", true);
			hashMap.put("Data", End_year);
			return ResponseEntity.status(HttpStatus.FOUND).body(hashMap);
		}
		else 
		{
			hashMap.put("statusCode", 404);
			hashMap.put("status", false);
			hashMap.put("message", "Data not found.....!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hashMap);
		}
		
	}
	@GetMapping("/intensity")
	ResponseEntity<?> getIntensity(Integer intensity)
	{
		HashMap<Object, Object> hashMap = new HashMap<>();
		Optional<BlackOffer> inten = repo.findById(intensity);
		if(inten.isPresent())
		{
			hashMap.put("statusCode", 302);
			hashMap.put("status", true);
			hashMap.put("Data", inten);
			return ResponseEntity.status(HttpStatus.FOUND).body(hashMap);
		}
		else 
		{
			hashMap.put("statusCode", 404);
			hashMap.put("status", false);
			hashMap.put("message", "Data not found.....!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hashMap);
		}
	}
	
	@GetMapping("/topic")
	ResponseEntity<?> getTopic(String topic)
	{
		HashMap<Object, Object> hashMap = new HashMap<>();
		Optional<List<BlackOffer>> findByTopic = repo.findByTopic(topic);
		if(findByTopic.isPresent())
		{
			hashMap.put("statusCode", 302);
			hashMap.put("status", true);
			hashMap.put("Data", findByTopic);
			return ResponseEntity.status(HttpStatus.FOUND).body(hashMap);
		}
		else 
		{
			hashMap.put("statusCode", 404);
			hashMap.put("status", false);
			hashMap.put("message", "Data not found.....!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hashMap);
		}
	}
	
	@GetMapping("/region")
	ResponseEntity<?> getRegion(String region)
	{
		HashMap<Object, Object> hashMap = new HashMap<>();
		Optional<List<BlackOffer>> findByRegion = repo.findByRegion(region);
		if(findByRegion.isPresent())
		{
			hashMap.put("statusCode", 302);
			hashMap.put("status", true);
			hashMap.put("Data", findByRegion);
			return ResponseEntity.status(HttpStatus.FOUND).body(hashMap);
		}
		else 
		{
			hashMap.put("statusCode", 404);
			hashMap.put("status", false);
			hashMap.put("message", "Data not found.....!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hashMap);
		}
	}
	
	@GetMapping("/city")
	ResponseEntity<?> getCity(String city)
	{
		HashMap<Object, Object> hashMap = new HashMap<>();
		Optional<List<BlackOffer>> findByCity = repo.findByCity(city);
		if(findByCity.isPresent())
		{
			hashMap.put("statusCode", 302);
			hashMap.put("status", true);
			hashMap.put("Data", findByCity);
			return ResponseEntity.status(HttpStatus.FOUND).body(hashMap);
		}
		else 
		{
			hashMap.put("statusCode", 404);
			hashMap.put("status", false);
			hashMap.put("message", "Data not found.....!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hashMap);
		}
	}
	
	@GetMapping("/country")
	ResponseEntity<?> getCountry(String country)
	{
		HashMap<Object, Object> hashMap = new HashMap<>();
	Optional<List<BlackOffer>> findByCountry = repo.findByCountry(country);
		if(findByCountry.isPresent())
		{
			hashMap.put("statusCode", 302);
			hashMap.put("status", true);
			hashMap.put("Data", findByCountry);
			return ResponseEntity.status(HttpStatus.FOUND).body(hashMap);
		}
		else 
		{
			hashMap.put("statusCode", 404);
			hashMap.put("status", false);
			hashMap.put("message", "Data not found.....!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hashMap);
		}
	}
	
	@GetMapping("/relevance")
	ResponseEntity<?> getRelevance(String relevance)
	{
		HashMap<Object, Object> hashMap = new HashMap<>();
	Optional<List<BlackOffer>> findByRelevance = repo.findByRelevance(relevance);
		if(findByRelevance.isPresent())
		{
			hashMap.put("statusCode", 302);
			hashMap.put("status", true);
			hashMap.put("Data", findByRelevance);
			return ResponseEntity.status(HttpStatus.FOUND).body(hashMap);
		}
		else 
		{
			hashMap.put("statusCode", 404);
			hashMap.put("status", false);
			hashMap.put("message", "Data not found.....!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hashMap);
		}
	}
	
	
	@GetMapping("/likelihood")
	ResponseEntity<?> getLikelihood(Integer likelihood)
	{
		HashMap<Object, Object> hashMap = new HashMap<>();
Optional<List<BlackOffer>> findByLikelihood = repo.findByLikelihood(likelihood);
		if(findByLikelihood.isPresent())
		{
			hashMap.put("statusCode", 302);
			hashMap.put("status", true);
			hashMap.put("Data", findByLikelihood);
			return ResponseEntity.status(HttpStatus.FOUND).body(hashMap);
		}
		else 
		{
			hashMap.put("statusCode", 404);
			hashMap.put("status", false);
			hashMap.put("message", "Data not found.....!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hashMap);
		}
	}
}
