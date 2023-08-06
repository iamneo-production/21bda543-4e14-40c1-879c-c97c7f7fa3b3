package com.patient.service;

import java.util.List;

import com.patient.model.HealthRecord;
import com.patient.model.Patient;

public interface PatientService {

	Patient registerPatientWithHealthRecord(Patient patient);

	List<Patient> getAllPatient();

	Patient getPatientByid(Long id);
	
	HealthRecord findByPatientId(Long id);	

}
