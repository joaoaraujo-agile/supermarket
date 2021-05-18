package com.agile.supermarket.dto;

import java.io.Serializable;
import java.util.Set;

import com.agile.supermarket.entities.enums.Role;

import lombok.Data;

@Data
public class UserRequestDTO implements Serializable {
	private static final long serialVersionUID = -3594540030890321245L;

	private String name;
	private String username;
	private String password;
	private Set<Role> roles;
}
