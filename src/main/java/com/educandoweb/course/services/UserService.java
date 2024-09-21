package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service																// Para registra a classe como componente do Spring
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	// Para buscar objeto pelo Id
	public User findById(long id) {										
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	// Para acrescentar um usuário
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	// Para deletar um usuário
	public void delete (Long id) {
		repository.deleteById(id);
	}
}
