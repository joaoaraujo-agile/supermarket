package com.agile.supermarket.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.agile.supermarket.dto.UserRequestDTO;
import com.agile.supermarket.dto.UserResponseDTO;
import com.agile.supermarket.entities.User;
import com.agile.supermarket.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository repository;

	private final BCryptPasswordEncoder pe;

	@Autowired
	public UserService(UserRepository repository, BCryptPasswordEncoder pe) {
		this.repository = repository;
		this.pe = pe;
	}

	public List<UserResponseDTO> findAll() {
		return repository.findAll().stream().map(u -> UserResponseDTO.toDTO(u)).collect(Collectors.toList());
	}

	public UserResponseDTO findById(Long id) {
		return UserResponseDTO.toDTO(findUserById(id));
//		TODO Exception handling when object doesn't exist
	}

	private User findUserById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
//		TODO Exception handling when object doesn't exist
	}

	public UserResponseDTO insert(UserRequestDTO obj) {
		User entity = new User(null, obj.getName(), obj.getUsername(), obj.getPassword());
		entity.setRoles(obj.getRoles());
		return UserResponseDTO.toDTO(entity);
//		TODO encode password
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public UserResponseDTO update(Long id, UserRequestDTO obj) {
		User entity = findUserById(id);
		updateData(entity, obj);
		entity = repository.save(entity);
		return UserResponseDTO.toDTO(entity);
	}

	private void updateData(User entity, UserRequestDTO obj) {
		entity.setName(obj.getName());
		if (obj.getPassword() != null) {
			entity.setPassword(obj.getPassword());
			// TODO encode password
		}
		if (obj.getRoles() != null) {
			entity.setRoles(obj.getRoles());
		}

	}

	public static User authenticated() {
		try {
			return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
