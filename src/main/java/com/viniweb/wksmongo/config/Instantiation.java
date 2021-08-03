package com.viniweb.wksmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.viniweb.wksmongo.domain.Post;
import com.viniweb.wksmongo.domain.User;
import com.viniweb.wksmongo.repository.PostRepository;
import com.viniweb.wksmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User vini = new User(null, "Vinicius Yonezawa", "vinicius.yonezawa@gmail.com");
		User mike = new User(null, "Michael Scott", "dundermifflin@gmail.com");
		User dwight = new User(null, "Dwight Schrute", "dwights@gmail.com");

		Post post1 = new Post(null, sdf.parse("22/03/2021"), "Meu aniversário!!", "Muito feliz pelo dia de hoje :D ", vini);
		Post post2 = new Post(null, sdf.parse("01/03/2021"), "Comprei essa camiseta", "Um achado essa camiseta, vai ficar bonito nela.", vini);
		
		userRepository.saveAll(Arrays.asList(vini, mike, dwight));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
