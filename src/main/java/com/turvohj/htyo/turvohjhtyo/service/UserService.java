package com.turvohj.htyo.turvohjhtyo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.turvohj.htyo.turvohjhtyo.user.User;
import com.turvohj.htyo.turvohjhtyo.user.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private PasswordEncoder bCryptPasswordEncoder;
	
	public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
	
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
