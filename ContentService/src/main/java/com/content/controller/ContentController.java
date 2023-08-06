package com.content.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.content.model.Content;
import com.content.service.ContentService;

@RestController
@RequestMapping("/api/content")
public class ContentController {

	@Autowired
	private ContentService contentService;

	@PostMapping
	public ResponseEntity<Content> addContent(@RequestBody Content content) {
		return new ResponseEntity<>(contentService.addContent(content), HttpStatus.OK);
	}

	@GetMapping("/{title}")
	public ResponseEntity<Content> findContentByTitle(@PathVariable String title) {
		return new ResponseEntity<>(contentService.findByTitle(title), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Content>> allContent() {
		return new ResponseEntity<>(contentService.allCOntent(), HttpStatus.OK);
	}

}
