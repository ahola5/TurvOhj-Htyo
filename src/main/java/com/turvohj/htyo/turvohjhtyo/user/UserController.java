package com.turvohj.htyo.turvohjhtyo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		//Get all users
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> retrieveUser(@PathVariable int id) {
		//Get a specific user with id
		Optional<User> user = userRepository.findById(id);
		
		if (!user.isPresent()) {
			//TODO: UserNotFoundException??
			throw new RuntimeException("id-" + id);
		}
		
		return user;
	}
}
