package com.viniweb.wksmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniweb.wksmongo.domain.Post;
import com.viniweb.wksmongo.repository.PostRepository;
import com.viniweb.wksmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) { 
		return repo.searchTitle(text);
	}
	
	public List<Post> allSearch(String text, Date minDate, Date maxDate) { 
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.allSearch(text, minDate, maxDate);
	}
	
}
