package com.i9Developed.pgm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i9Developed.pgm.domain.User;
import com.i9Developed.pgm.dto.UserDTO;
import com.i9Developed.pgm.repository.UserRepository;
import com.i9Developed.pgm.services.xception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {

		return repository.findAll();
	}

	public User findById(String id) {

		Optional<User> obj = repository.findById(id);
		
		return obj.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {

		return repository.insert(obj);
	}
	
	
	
	
	public User fromDTO(UserDTO userDTO) {
		
		
		
		return new User(userDTO.getId(),userDTO.getname(),userDTO.getEmail());
		
	}
}
