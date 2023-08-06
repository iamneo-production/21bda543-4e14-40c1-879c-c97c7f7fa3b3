package com.recommendate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recommendate.modal.RusultRecommendate;
import com.recommendate.modal.repository.RusultRecommendateRepo;
import com.recommendate.service.RusultRecommendateService;

@Service
public class RusultRecommendateServiceImpl implements RusultRecommendateService {

	@Autowired
	RusultRecommendateRepo recommendateRepo;

	@Override
	public RusultRecommendate saverecomm(RusultRecommendate rusultRecommendate) {
		return recommendateRepo.save(rusultRecommendate);
	}

	@Override
	public RusultRecommendate getResultById(Long id) {
		return recommendateRepo.findById(id).orElseThrow(
				() -> new com.recommendate.exception.ResourceNotFoundException("Patient id is not present " + id));
	}

}
