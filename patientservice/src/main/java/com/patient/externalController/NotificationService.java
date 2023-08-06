package com.patient.externalController;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.patient.model.RusultRecommendate;

@FeignClient(name = "NOTIFCATION-SERVICE")
public interface NotificationService {

	@GetMapping("/api/notifications/{id}")
	RusultRecommendate getRecommendationByPatientId(@PathVariable Long id);

}
