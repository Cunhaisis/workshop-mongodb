package com.devisis.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devisis.workshopmongo.domain.Post;
import com.devisis.workshopmongo.domain.User;
import com.devisis.workshopmongo.repository.PostRepository;
import com.devisis.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		User beyonce = new User(null, "Beyonce Carter", "bey@gmail.com");
		User bruno = new User(null, "Bruno Mars", "bruno@24K.com");
		User corey = new User(null, "Corey Taylor", "corey@slipknot.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo, Abraços!", beyonce);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", bruno);

		userRepository.saveAll(Arrays.asList(beyonce, bruno, corey));
		postRepository.saveAll(Arrays.asList(post1, post2));

	}

}
