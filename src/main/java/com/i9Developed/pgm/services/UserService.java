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
	
	public void delete(String id) {
			
		this.findById(id);
		repository.deleteById(id);
		
	}
	
	public User update(String id,User objNewUser) {
		try {
		User objUser = this.findById(id);
		updateData(objUser,objNewUser);
		return repository.save(objUser);
	} catch (Exception e) {
		throw new ObjectNotFoundException( e+" Recurso nao encontrado: "+id);
	}
		
	}
	
	
	
	
	private User updateData(User objUser,User objNewUser) {
		
		objUser.setName(objNewUser.getName());
		objUser.setEmail(objNewUser.getEmail());
		
		return objUser;
	}
	
	
	
	
	
	public User fromDTO(UserDTO userDTO) {
		
		
		return new User(userDTO.getId(),userDTO.getname(),userDTO.getEmail());
		
	}
}
