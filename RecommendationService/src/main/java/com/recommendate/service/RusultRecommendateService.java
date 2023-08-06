package com.recommendate.service;

import com.recommendate.modal.RusultRecommendate;

public interface RusultRecommendateService {
	
	RusultRecommendate saverecomm(RusultRecommendate rusultRecommendate);
	
	RusultRecommendate getResultById(Long id);

}
