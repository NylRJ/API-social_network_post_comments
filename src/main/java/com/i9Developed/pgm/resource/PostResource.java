package com.i9Developed.pgm.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.i9Developed.pgm.domain.Post;
import com.i9Developed.pgm.dto.PostDTO;
import com.i9Developed.pgm.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService PostService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PostDTO>> findAll() {
		List<Post> list = PostService.findAll();
		List<PostDTO> listDto = list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PostDTO> findById(@PathVariable String id) {
		Post obj = PostService.findById(id);

		return ResponseEntity.ok().body(new PostDTO(obj));
	}

	@PostMapping
	public ResponseEntity<Post> insert(@RequestBody PostDTO objDTO) {
		Post obj = PostService.fromDTO(objDTO);
		obj = PostService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		
		 PostService.delete(id);

		return ResponseEntity.noContent().build();
	}
	

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody PostDTO obj) {
		Post objPost = PostService.fromDTO(obj);
		objPost.setId(id);
		objPost = PostService.update(id, objPost);
		return ResponseEntity.noContent().build();
	}
	
	
}
