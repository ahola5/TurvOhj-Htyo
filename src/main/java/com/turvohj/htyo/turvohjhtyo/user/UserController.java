package com.turvohj.htyo.turvohjhtyo.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.turvohj.htyo.turvohjhtyo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {

		// Check if user already logged in
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {

		    return "redirect:/";
		}
		
		return "login";
	}
	
	//POST login is provided by Spring Security!
	
	@GetMapping("/registration")
	public String register(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {

		    return "redirect:/";
		}
		
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
		return "gameview";
	}
	
	@GetMapping("/")
	public String home() {
		
		return "homepage";
	}
}
