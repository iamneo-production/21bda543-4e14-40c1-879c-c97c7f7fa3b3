package com.patient.patientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.patientservice.model.HealthRecord;

public interface HealthRepository extends JpaRepository<HealthRecord, Long>{

}
