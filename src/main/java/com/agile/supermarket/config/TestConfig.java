package com.agile.supermarket.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.agile.supermarket.entities.User;
import com.agile.supermarket.entities.enums.Role;
import com.agile.supermarket.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("******************************** SEEDING DATABASE");

//		TODO encode password
		User usr1 = new User("admin user", "admin", "admin123");
		usr1.getRoles().add(Role.ADMIN);
		User usr2 = new User("cashier user", "cashier", "cashier123");
		usr2.getRoles().add(Role.CASHIER);

		userRepository.saveAll(Arrays.asList(usr1, usr2));

	}

}
