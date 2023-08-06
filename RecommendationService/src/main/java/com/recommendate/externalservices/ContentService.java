package com.recommendate.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.recommendate.modal.Contents;

@FeignClient(name = "CONTENT-SERVICE")
public interface ContentService {

	@GetMapping("/api/content/{title}")
	Contents findContentByTitle(@PathVariable String title);

}
