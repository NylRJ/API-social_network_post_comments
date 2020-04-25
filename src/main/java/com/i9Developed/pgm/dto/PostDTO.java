package com.i9Developed.pgm.dto;

import java.io.Serializable;
import java.util.Date;

import com.i9Developed.pgm.domain.Post;
import com.i9Developed.pgm.domain.User;

public class PostDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private Date date;
	private String title;
	private String body;
	private User author;

	public PostDTO() {
		
	}
	
	public PostDTO(Post x) {
		this();
		this.id = x.getId();
		this.date = x.getDate();
		this.title = x.getTitle();
		this.body = x.getBody();
		
	}

	
	
	
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostDTO other = (PostDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
