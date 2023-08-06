package com.dcotor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcotor.externalService.PatientService;
import com.dcotor.externalService.RecommendationService;
import com.dcotor.model.PatientDto;
import com.dcotor.model.RusultRecommendate;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

	@Autowired
	PatientService patientService;

	@Autowired
	RecommendationService recommendationService;

	@GetMapping("/{id}")
	public ResponseEntity<PatientDto> getPatientById(@PathVariable long id) {
		return new ResponseEntity<>(patientService.getPatientByid(id), HttpStatus.OK);
	}

	@PostMapping("/{id}")
	public ResponseEntity<RusultRecommendate> getRecommendate(@PathVariable Long id) {
		return new ResponseEntity<>(recommendationService.Recommendateans(id), HttpStatus.OK);
	}

}
