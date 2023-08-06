package com.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.externalController.NotificationService;
import com.patient.model.HealthRecord;
import com.patient.model.Patient;
import com.patient.model.RusultRecommendate;
import com.patient.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@Autowired
	private NotificationService notificationService;

	@PostMapping
	public ResponseEntity<Patient> registerPatientWithHealthRecord(@RequestBody Patient patient) {
		Patient registeredPatient = patientService.registerPatientWithHealthRecord(patient);
		return ResponseEntity.ok(registeredPatient);
	}

	@GetMapping
	public ResponseEntity<List<Patient>> getAllPatientInfo() {
		return ResponseEntity.ok(patientService.getAllPatient());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable long id) {
		return new ResponseEntity<>(patientService.getPatientByid(id), HttpStatus.OK);
	}

	@GetMapping("/health/{id}")
	public ResponseEntity<HealthRecord> gethealathByPatientId(@PathVariable long id) {
		return new ResponseEntity<>(patientService.findByPatientId(id), HttpStatus.OK);
	}

	@GetMapping("/notification/{id}")
	public ResponseEntity<RusultRecommendate> getRecommendationByPatientId(@PathVariable Long id) {
		RusultRecommendate recommendation = notificationService.getRecommendationByPatientId(id);
		if (recommendation != null) {
			return ResponseEntity.ok(recommendation);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
