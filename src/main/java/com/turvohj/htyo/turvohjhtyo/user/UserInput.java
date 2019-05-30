package com.turvohj.htyo.turvohjhtyo.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserInput {

	@NotBlank
	@Size(min=1, max=1)
	@Pattern(regexp = "^[a-zA-Z]$", message="Only one letter!")
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	
}
