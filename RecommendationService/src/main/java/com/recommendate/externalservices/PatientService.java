package com.recommendate.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.recommendate.modal.HealthRecord;
import com.recommendate.modal.PatientDto;

@FeignClient(name = "PATIENT-SERVICE")
public interface PatientService {

	@GetMapping("/patient/{id}")
	PatientDto getPatientByid(@PathVariable long id);
	
	
	

	@GetMapping("/patient/health/{id}")
	HealthRecord findByPatientId(@PathVariable Long id);

}