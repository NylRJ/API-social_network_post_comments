package com.i9Developed.pgm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.i9Developed.pgm.domain.User;
import com.i9Developed.pgm.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		
		return repository.findAll();
	}
	
	public User insert(User obj) {
		
		return repository.save(obj);
	}
}
