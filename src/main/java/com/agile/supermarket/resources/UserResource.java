package com.agile.supermarket.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.agile.supermarket.dto.UserRequestDTO;
import com.agile.supermarket.dto.UserResponseDTO;
import com.agile.supermarket.services.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserResource {

	private final UserService service;

	@Autowired
	public UserResource(UserService service) {
		this.service = service;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<UserResponseDTO> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public UserResponseDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping
	public ResponseEntity<UserResponseDTO> insert(@RequestBody UserRequestDTO obj) {
		UserResponseDTO entity = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).body(entity);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public UserResponseDTO update(@PathVariable Long id, @RequestBody UserRequestDTO obj) {
		return service.update(id, obj);
	}
}
