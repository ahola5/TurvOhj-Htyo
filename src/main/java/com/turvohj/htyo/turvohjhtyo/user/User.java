package com.turvohj.htyo.turvohjhtyo.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer highscore;
	private String username;
	
	private String password;
	
	public User() {
		//Required default constructor
	}

	public User(Integer id, Integer highscore, String username, String password) {
		super();
		this.id = id;
		this.highscore = highscore;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHighscore() {
		return highscore;
	}

	public void setHighscore(Integer highscore) {
		this.highscore = highscore;
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
	
	
	
	
}
