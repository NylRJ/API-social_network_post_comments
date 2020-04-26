package com.i9Developed.pgm.dto;

import java.io.Serializable;
import java.time.Instant;

public class CommentDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String txt;
	private Instant date;
	private AuthorDTO author;
	
	public CommentDTO() {
		
		
	}

	public CommentDTO(String txt, Instant date, AuthorDTO author) {
		super();
		this.txt = txt;
		this.date = date;
		this.author = author;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
	
}
