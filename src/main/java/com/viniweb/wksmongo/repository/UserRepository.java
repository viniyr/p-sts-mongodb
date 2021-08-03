package com.viniweb.wksmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viniweb.wksmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
}
