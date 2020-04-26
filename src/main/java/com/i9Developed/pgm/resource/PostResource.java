package com.i9Developed.pgm.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.i9Developed.pgm.domain.Post;
import com.i9Developed.pgm.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService PostService;

//	@RequestMapping(method = RequestMethod.GET)
//	public ResponseEntity<List<Post>> findAll() {
//		List<Post> list = PostService.findAll();
//		
//
//		return ResponseEntity.ok().body(list);
//	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = PostService.findById(id);

		return ResponseEntity.ok().body(obj);
	}
//
//	@PostMapping
//	public ResponseEntity<Post> insert(@RequestBody Post objDTO) {
//		Post obj = PostService.fromDTO(objDTO);
//		obj = PostService.insert(obj);
//		
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(obj.getId()).toUri();
//		
//		return ResponseEntity.created(uri).body(obj);
//		
//	}
//	
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> delete(@PathVariable String id) {
//		
//		 PostService.delete(id);
//
//		return ResponseEntity.noContent().build();
//	}
//	
//
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody PostDTO obj) {
//		Post objPost = PostService.fromDTO(obj);
//		objPost.setId(id);
//		objPost = PostService.update(id, objPost);
//		return ResponseEntity.noContent().build();
//	}
//	
//	
}
