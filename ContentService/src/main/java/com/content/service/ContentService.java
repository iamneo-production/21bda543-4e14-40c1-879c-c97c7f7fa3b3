package com.content.service;

import java.util.List;

import com.content.model.Content;

public interface ContentService {

	Content addContent(Content content);

	Content findByTitle(String title);
	
	List<Content> allCOntent();

}
