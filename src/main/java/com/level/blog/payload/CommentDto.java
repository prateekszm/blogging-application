package com.level.blog.payload;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class CommentDto {
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}





}
