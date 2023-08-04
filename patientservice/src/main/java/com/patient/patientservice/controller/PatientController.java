package com.patient.patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patient.patientservice.Service.PatientService;
import com.patient.patientservice.model.Patient;



@RestController
@RequestMapping("/api/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping
	public ResponseEntity<Patient> registerPatientWithHealthRecord(@RequestBody Patient patient) {
		Patient registeredPatient = patientService.registerPatientWithHealthRecord(patient);
		return ResponseEntity.ok(registeredPatient);
	}

}
