package com.agile.supermarket.dto;

import java.io.Serializable;
import java.util.Set;

import com.agile.supermarket.entities.User;
import com.agile.supermarket.entities.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDTO implements Serializable {
	private static final long serialVersionUID = 2888384533966561323L;

	private Long id;
	private String name;
	private String username;
	private Set<Role> roles;
	
	public static UserResponseDTO toDTO(User obj) {
		return new UserResponseDTO(obj.getId(), obj.getName(), obj.getUsername(), obj.getRoles());
	}
}
