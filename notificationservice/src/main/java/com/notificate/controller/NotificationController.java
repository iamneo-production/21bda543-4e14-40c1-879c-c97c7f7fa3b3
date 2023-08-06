package com.notificate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notificate.externalservices.RecommendationService;
import com.notificate.model.RusultRecommendate;


@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
	
	@Autowired
	RecommendationService recommendationService;
	
	
	//fetching result from recommendation service
	
	@GetMapping("/{id}")
	public ResponseEntity<RusultRecommendate> getRecommendationByPatientId(@PathVariable Long id) {
		RusultRecommendate recommendation = recommendationService.getResultbyId(id);
		if (recommendation != null) {
			return ResponseEntity.ok(recommendation);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
