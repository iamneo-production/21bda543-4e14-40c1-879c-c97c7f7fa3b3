package com.content.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.content.model.Content;

public interface ContentRepository extends JpaRepository<Content, Long> {

	Content findByTitle(String title);

}
