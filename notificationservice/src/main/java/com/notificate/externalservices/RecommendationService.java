package com.notificate.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.notificate.model.RusultRecommendate;



@FeignClient(name = "RECOMMENDATION-SERVICE")
public interface RecommendationService {
	
	@GetMapping("/api/recommendations/{id}")
	RusultRecommendate getResultbyId(@PathVariable Long id);

}
