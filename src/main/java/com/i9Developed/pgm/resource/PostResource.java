package com.i9Developed.pgm.resource;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.i9Developed.pgm.domain.Post;
import com.i9Developed.pgm.services.PostService;
import com.i9Developed.pgm.uttil.URL;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService PostService;



	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById( String id) {
		Post obj = PostService.findById(id);

		return ResponseEntity.ok().body(obj);
	}
	
	

	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> titleSearch(
			@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "minDate", defaultValue = "") Date minDate,
			@RequestParam(value = "maxDate", defaultValue = "") Date maxDate) {
		text = URL.decodeParameter(text);
		 
		List<Post> objList = PostService.findByTitle(text);

		return ResponseEntity.ok().body(objList);
	}
	

	@RequestMapping(value = "/fullSearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParameter(text);
		 
		List<Post> objList = PostService.findByTitle(text);

		return ResponseEntity.ok().body(objList);
	}
}
