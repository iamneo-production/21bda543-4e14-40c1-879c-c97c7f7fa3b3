package com.recommendate.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

	private Long id;
	private String name;
	private String contactInfo;
	private String gender;
	private String email;

	private HealthRecordDto healthRecordDto;
}