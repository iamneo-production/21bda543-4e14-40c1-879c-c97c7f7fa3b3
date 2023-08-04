package com.patient.patientservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HealthRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String conditions; // e.g., "Diabetes", "Hypertension", etc.
	private String allergies; // e.g., "Peanuts", "Penicillin", etc.
	private String medications; // e.g., "Metformin", "Lisinopril", etc.
	private String medicalHistory; // e.g., surgeries, chronic illnesses, etc.
	
	@OneToOne
	@JoinColumn(name = "id")
	@JsonIgnore
	private Patient patient;

}
