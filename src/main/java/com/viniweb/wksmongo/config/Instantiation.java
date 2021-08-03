package com.viniweb.wksmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.viniweb.wksmongo.domain.Post;
import com.viniweb.wksmongo.domain.User;
import com.viniweb.wksmongo.dto.AuthorDTO;
import com.viniweb.wksmongo.dto.CommentDTO;
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
		User amanda = new User(null, "Amanda Ogoshi", "mand_ogoshi@hotmail.com");

		userRepository.saveAll(Arrays.asList(vini, mike, dwight, amanda));
		
		Post post1 = new Post(null, sdf.parse("22/03/2021"), "Meu aniversário!!", "Muito feliz pelo dia de hoje :D ", new AuthorDTO(vini));
		Post post2 = new Post(null, sdf.parse("01/03/2021"), "Dia especial!", "Até comprei presente olha aí. :)", new AuthorDTO(vini));
		
		CommentDTO c1 = new CommentDTO("Thats what she said", sdf.parse("01/03/2021"), new AuthorDTO(mike));
		CommentDTO c2 = new CommentDTO("Bears. Beets. Battlestar Galactica.", sdf.parse("22/03/2021"), new AuthorDTO(dwight));
		CommentDTO c3 = new CommentDTO("Obrigada!!", sdf.parse("02/03/2021"), new AuthorDTO(amanda));
		
		post1.getComments().addAll(Arrays.asList(c2));
		post2.getComments().addAll(Arrays.asList(c1, c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		vini.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(vini);
		
	}

}
