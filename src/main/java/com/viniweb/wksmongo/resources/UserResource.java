package com.viniweb.wksmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.viniweb.wksmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() { 
		User vini = new User("1", "Vinicius Yonezawa", "vini@gmail.com");
		User mike = new User("2", "Michael Scott", "michael@gmail.com");
		User dwight = new User("3", "Dwight Schrute", "dwigh@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(vini,mike,dwight));
		return ResponseEntity.ok().body(list);
		
	}
	
}
