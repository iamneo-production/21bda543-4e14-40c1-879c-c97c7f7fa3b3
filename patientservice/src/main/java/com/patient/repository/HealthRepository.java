package com.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.model.HealthRecord;

public interface HealthRepository extends JpaRepository<HealthRecord, Long> {
	
	HealthRecord findByPatientId(Long id);	
}
