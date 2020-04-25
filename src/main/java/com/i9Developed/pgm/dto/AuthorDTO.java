package com.i9Developed.pgm.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.i9Developed.pgm.domain.User;


public class AuthorDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
	private String id;
	private String name;

	

	
	
	
	public AuthorDTO() {}

	public AuthorDTO(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	



	
	
	
}
