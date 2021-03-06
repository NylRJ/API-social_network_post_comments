package com.i9Developed.pgm.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i9Developed.pgm.domain.Post;
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
	

	public List<Post> findByTitle(String txt) {

		
		return repository.searchTitle(txt);
		
	}
	

	public List<Post> fullSearch(String txt, Date minDate,Date maxDate) {
			
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 100);
		  
		return repository.fullSearchTitle(txt, minDate, maxDate);
		
	}

	public Post insert(Post obj) {

		return repository.insert(obj);
	}
	
	public void delete(String id) {
			
		this.findById(id);
		repository.deleteById(id);
		
	}
	
	
}
