package com.turvohj.htyo.turvohjhtyo.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotBlank(message="Username cannot be empty")
	@Pattern(regexp="^[a-zA-Z0-9]{2,20}$",
			message="Username must be 2-20 characters long and it can't contain special characters")
	private String username;
	
	@NotBlank(message="Password cannot be empty")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!?_-])(?=\\S+$).{8,60}$",
			message="Password must be at least 8 characters long and contain 1 small letter, 1 capital letter, 1 number and 1 special character")
	private String password;
	
	@NotBlank(message="Password cannot be empty")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!?_-])(?=\\S+$).{8,60}$",
			message="Password must be at least 8 characters long and contain 1 small letter, 1 capital letter, 1 number and 1 special character")
	@Transient
	private String confirmPassword;
	
	public User() {
		//Required default constructor
	}

	public User(Integer id, String username, String password, String confirmPassword) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
