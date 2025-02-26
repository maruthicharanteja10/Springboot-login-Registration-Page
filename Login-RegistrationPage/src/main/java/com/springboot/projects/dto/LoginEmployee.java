package com.springboot.projects.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginEmployee {
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;
	@NotBlank(message = "password should not be empty")
	private String password;

}
