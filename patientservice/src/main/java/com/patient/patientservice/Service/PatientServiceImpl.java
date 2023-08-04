package com.patient.patientservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.patientservice.model.Patient;
import com.patient.patientservice.repository.PatientReposioty;


@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	PatientReposioty patientReposioty;

	@Override
	public Patient registerPatientWithHealthRecord(Patient patient) {
		return patientReposioty.save(patient);
	}

}