package com.dcotor.externalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dcotor.model.RusultRecommendate;


@FeignClient(name = "RECOMMENDATION-SERVICE")
public interface RecommendationService {

	@PostMapping("/api/recommendations/{id}")
	RusultRecommendate Recommendateans(@PathVariable Long id);

}
