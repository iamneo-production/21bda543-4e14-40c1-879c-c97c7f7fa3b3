package com.notificate.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RusultRecommendate {

	private long id;

	private long patientId;
	private List<String> recommendate;
	private List<String> links;

}
