package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	// Para acrescentar um usuário
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	// Para deletar um usuário
	public void delete (Long id) {
		repository.deleteById(id);
	}
	
	// Para atualizar o usuário
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);						//  Pq vai ser uma entidade (entity) de Usuário (User) monitorada pelo JPA
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {						// não é necessários todos os campos do usuário serem atualizados.
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
