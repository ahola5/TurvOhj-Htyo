package com.turvohj.htyo.turvohjhtyo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.turvohj.htyo.turvohjhtyo.exception.UserNotFoundException;
import com.turvohj.htyo.turvohjhtyo.user.User;
import com.turvohj.htyo.turvohjhtyo.user.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
        if (user == null) {
            throw new UserNotFoundException("name " + username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
         
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}

}
