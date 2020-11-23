package com.devisis.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devisis.workshopmongo.domain.User;
import com.devisis.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	public UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User beyonce = new User(null, "Beyonce Carter", "bey@gmail.com");
		User bruno = new User(null, "Bruno Mars", "bruno@24K.com");
		User corey = new User(null, "Corey Taylor", "corey@slipknot.com");

		userRepository.saveAll(Arrays.asList(beyonce, bruno, corey));

	}

}
