package com.patient.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.exception.ResourceNotFoundException;
import com.patient.model.HealthRecord;
import com.patient.model.Patient;
import com.patient.repository.HealthRepository;
import com.patient.repository.PatientReposioty;
import com.patient.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientReposioty patientReposioty;

	@Autowired
	private HealthRepository healthRepository;

	@Override
	public Patient registerPatientWithHealthRecord(Patient patient) {

		HealthRecord healthRecord = patient.getHealthRecord();
		healthRecord.setPatient(patient);

		healthRecord.setPatient(patient);
		healthRepository.save(healthRecord);

		return patientReposioty.save(patient);
	}

	@Override
	public List<Patient> getAllPatient() {
		return patientReposioty.findAll();
	}

	@Override
	public Patient getPatientByid(Long id) {
		return patientReposioty.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient id is not present " + id));
	}

	@Override
	public HealthRecord findByPatientId(Long id) {
		return healthRepository.findByPatientId(id);
	}

}
