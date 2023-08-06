package com.dcotor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthRecordDto {

	private Long id;
	private String conditions; // e.g., "Diabetes", "Hypertension", etc.
	private String allergies; // e.g., "Peanuts", "Penicillin", etc.
	private String medications; // e.g., "Metformin", "Lisinopril", etc.
	private String medicalHistory;

}
