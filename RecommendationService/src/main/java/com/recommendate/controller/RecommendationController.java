package com.recommendate.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recommendate.externalservices.ContentService;
import com.recommendate.externalservices.PatientService;
import com.recommendate.modal.Contents;
import com.recommendate.modal.HealthRecord;
import com.recommendate.modal.PatientDto;
import com.recommendate.modal.RusultRecommendate;
import com.recommendate.service.RusultRecommendateService;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

	@Autowired
	PatientService patientService;

	@Autowired
	ContentService contentService;

	@Autowired
	RusultRecommendateService recommendateService;
	
	//patient record using id

	@GetMapping("/patient/{id}")
	public ResponseEntity<PatientDto> getPatientById(@PathVariable long id) {
		PatientDto patientDto = patientService.getPatientByid(id);
		return new ResponseEntity<>(patientDto, HttpStatus.OK);
	}

	//health record using patient id
	
	@GetMapping("/health/{id}")
	public ResponseEntity<HealthRecord> getHealthREcord(@PathVariable long id) {
		return new ResponseEntity<>(patientService.findByPatientId(id), HttpStatus.OK);
	}

	
	//testing content Service
	
	@GetMapping("/con/{title}")
	public ResponseEntity<Contents> getContentByYitle(@PathVariable String title) {
		return new ResponseEntity<>(contentService.findContentByTitle(title), HttpStatus.OK);
	}

	//Recommendation Logic
	
	@PostMapping("/{id}")
	public ResponseEntity<RusultRecommendate> Recommendateans(@PathVariable Long id) {

		HealthRecord findByPatientId = patientService.findByPatientId(id);

		RusultRecommendate rc = new RusultRecommendate();
		rc.setPatientId(id);

		List<String> contentList = new ArrayList<>();
		List<String> urls = new ArrayList<>();

		if (!findByPatientId.getAllergies().isEmpty()) {
			Contents findContentByTitle1 = contentService.findContentByTitle(findByPatientId.getAllergies());
			if (findContentByTitle1 != null) {
				contentList.add(findContentByTitle1.getDescription());
				urls.add(findContentByTitle1.getLink());
			}
		}

		if (!findByPatientId.getConditions().isEmpty()) {
			Contents findContentByTitle = contentService.findContentByTitle(findByPatientId.getConditions());

			if (findContentByTitle != null) {
				contentList.add(findContentByTitle.getDescription());
				urls.add(findContentByTitle.getLink());
			}
		}

		if (!findByPatientId.getMedicalHistory().isEmpty()) {
			Contents findContentByTitle3 = contentService.findContentByTitle(findByPatientId.getMedicalHistory());

			if (findContentByTitle3 != null) {
				contentList.add(findContentByTitle3.getDescription());
				urls.add(findContentByTitle3.getLink());
			}
		}

		rc.setRecommendate(contentList);
		rc.setLinks(urls);

		return new ResponseEntity<>(recommendateService.saverecomm(rc), HttpStatus.OK);
	}
	
	//get health recommendation using patient id
	@GetMapping("/{id}")
	public ResponseEntity<RusultRecommendate> getResultbyId(@PathVariable Long id){
		return new ResponseEntity<>(recommendateService.getResultById(id),HttpStatus.OK);
	}

}
