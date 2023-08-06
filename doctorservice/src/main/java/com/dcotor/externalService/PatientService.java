package com.dcotor.externalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dcotor.model.PatientDto;

@FeignClient(name = "PATIENT-SERVICE")
public interface PatientService {

	@GetMapping("/patient/{id}")
	PatientDto getPatientByid(@PathVariable long id);

}
