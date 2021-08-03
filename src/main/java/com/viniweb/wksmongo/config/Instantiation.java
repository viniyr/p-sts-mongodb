package com.viniweb.wksmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.viniweb.wksmongo.domain.User;
import com.viniweb.wksmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		
		User vini = new User(null, "Vinicius Yonezawa", "vinicius.yonezawa@gmail.com");
		User mike = new User(null, "Michael Scott", "dundermifflin@gmail.com");
		User dwight = new User(null, "Dwight Schrute", "dwights@gmail.com");

		userRepository.saveAll(Arrays.asList(vini, mike, dwight));
		
	}

}
