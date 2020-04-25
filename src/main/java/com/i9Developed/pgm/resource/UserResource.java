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
import com.i9Developed.pgm.domain.User;
import com.i9Developed.pgm.dto.UserDTO;
import com.i9Developed.pgm.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = userService.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = userService.findById(id);

		return ResponseEntity.ok().body(new UserDTO(obj));
	}


	@PostMapping
	public ResponseEntity<User> insert(@RequestBody UserDTO objDTO) {
		User obj = userService.fromDTO(objDTO);
		obj = userService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		
		 userService.delete(id);

		return ResponseEntity.noContent().build();
	}
	

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO obj) {
		User objUser = userService.fromDTO(obj);
		objUser.setId(id);
		objUser = userService.update(id, objUser);
		return ResponseEntity.noContent().build();
	}
	

	@RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findPost(@PathVariable String id) {
		User obj = userService.findById(id);

		return ResponseEntity.ok().body(obj.getPosts());
	}
	
}
