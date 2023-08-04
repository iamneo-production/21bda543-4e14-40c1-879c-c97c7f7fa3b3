package com.patient.patientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.patientservice.model.Patient;

public interface PatientReposioty extends JpaRepository<Patient, Long>{

}