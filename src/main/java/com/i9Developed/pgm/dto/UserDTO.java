package com.i9Developed.pgm.dto;

import java.io.Serializable;

import com.i9Developed.pgm.domain.User;

public class UserDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
	private String id;
	private String name;
	private String email;
	
	
	
	public UserDTO() {}

	public UserDTO(User obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
