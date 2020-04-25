package com.i9Developed.pgm.dto;

import java.io.Serializable;

import com.i9Developed.pgm.domain.User;


public class AuthorDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
	private String id;
	private String name;
	
	
	
	public AuthorDTO() {}

	public AuthorDTO(User obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	
}
