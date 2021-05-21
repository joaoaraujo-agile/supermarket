package com.agile.supermarket.config;

import com.agile.supermarket.entities.User;
import com.agile.supermarket.entities.enums.Role;
import com.agile.supermarket.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Profile("prod")
public class ProdConfig implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User usr = userRepository.findByUsername("admin");
				
		if (usr == null) {			
			User usr1 = new User(null, "admin", "admin", pe.encode("admin123"));
			usr1.getRoles().add(Role.ADMIN);
			
			userRepository.save(usr1);
		}

	}

}
