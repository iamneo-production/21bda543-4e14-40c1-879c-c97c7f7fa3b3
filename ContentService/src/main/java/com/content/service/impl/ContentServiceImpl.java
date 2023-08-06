package com.content.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.content.model.Content;
import com.content.repository.ContentRepository;
import com.content.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentRepository contentRepository;

	@Override
	public Content addContent(Content content) {
		return contentRepository.save(content);
	}

	@Override
	public Content findByTitle(String title) {

		Content cotentResult = contentRepository.findByTitle(title);

		if (cotentResult != null) {
			return cotentResult;
		} else {
			Content dummyContent = new Content();
			dummyContent.setType("Dummy");
			dummyContent.setTitle("Dummy Content");
			dummyContent.setDescription("This is a dummy content.");
			dummyContent.setLink("#");

			return dummyContent;
		}

	}

	@Override
	public List<Content> allCOntent() {
		return contentRepository.findAll();
	}

}
