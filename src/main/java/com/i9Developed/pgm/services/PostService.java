package com.i9Developed.pgm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i9Developed.pgm.domain.Post;
import com.i9Developed.pgm.dto.PostDTO;
import com.i9Developed.pgm.repository.PostRepository;
import com.i9Developed.pgm.services.xception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public List<Post> findAll() {

		return repository.findAll();
	}

	public Post findById(String id) {

		Optional<Post> obj = repository.findById(id);
		
		return obj.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Post insert(Post obj) {

		return repository.insert(obj);
	}
	
	public void delete(String id) {
			
		this.findById(id);
		repository.deleteById(id);
		
	}
	
	public Post update(String id,Post objNewPost) {
		try {
		Post objPost = this.findById(id);
		updateData(objPost,objNewPost);
		return repository.save(objPost);
	} catch (Exception e) {
		throw new ObjectNotFoundException( e+" Recurso nao encontrado: "+id);
	}
		
	}
	
	
	
	
	private Post updateData(Post objPost,Post objNewPost) {
		
		objPost.setBody(objNewPost.getBody());
		objPost.setTitle(objNewPost.getTitle());
		objPost.setDate(objNewPost.getDate());
		
		
		
		return objPost;
	}
	
	
	
	
	
	public Post fromDTO(PostDTO postDTO) {
		
		
		return new Post(postDTO.getId(),postDTO.getDate(),postDTO.getBody(),postDTO.getTitle(),postDTO.getAuthor());
		
	}
}
