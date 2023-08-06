package com.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.model.Patient;

public interface PatientReposioty extends JpaRepository<Patient, Long> {

	

}
