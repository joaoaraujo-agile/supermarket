package com.agile.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agile.supermarket.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);
}
