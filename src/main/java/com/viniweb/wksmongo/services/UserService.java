package com.viniweb.wksmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniweb.wksmongo.domain.User;
import com.viniweb.wksmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() { 
		return repo.findAll();
	}
}
