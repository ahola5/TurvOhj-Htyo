package com.turvohj.htyo.turvohjhtyo.user;

import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.turvohj.htyo.turvohjhtyo.exception.UserNotFoundException;
import com.turvohj.htyo.turvohjhtyo.service.UserService;

@Controller
public class UserController {

	//TODO: REMOVE THIS?
	//@Autowired
	//private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	/*@GetMapping("/users")
	public List<User> getAllUsers() {
		//Get all users
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> retrieveUser(@PathVariable int id) {
		//Get a specific user with id
		Optional<User> user = userRepository.findById(id);
		
		if (!user.isPresent()) {
			throw new UserNotFoundException("id " + id);
		}
		
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		
		//Return CREATED status
		int id = savedUser.getId();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(location).build();
	}*/
	
	
	
	@GetMapping("/login")
	public String login() {
		//model.addAttribute("name", name);
		return "login";
	}
	
	//POST login is provided by Spring Security!
	
	@GetMapping("/registration")
	public String register(Model model) {
		model.addAttribute("user", new User());
		
		return "registration";
	}
	
	@PostMapping("/registration")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		
		if (userService.findByUsername(user.getUsername()) != null) {
			bindingResult.rejectValue("username", null, "Username already exists!");
		}
		if ( !user.getPassword().equals(user.getConfirmPassword()) ) {
			bindingResult.rejectValue("confirmPassword", null, "Passwords must match!");
			bindingResult.rejectValue("password", null, "Passwords must match!");
			return "registration";
		}
		
		if (bindingResult.hasErrors()) {
            return "registration";
        }
		
		userService.save(user);
		
		return "redirect:/login";
	}
	
	@GetMapping("/play")
	public String play(Model model) {
		model.addAttribute("userinput", new UserInput());
		
		return "gameview";
	}
	
	@PostMapping("/play")
	public String play(@Valid @ModelAttribute("userinput") UserInput userInput, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			
            return "gameview";
        }
		System.out.println("jaaahas");
		return "gameview";
	}
	
	@GetMapping("/")
	public String home() {
		
		return "homepage";
	}
}
