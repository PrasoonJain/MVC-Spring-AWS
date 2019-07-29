package com.maven.models;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class LoginBean {
	@NotBlank(message = "Username cannot be empty")
	private String username;

	@NotBlank(message = "Username cannot be empty")
	private String password;

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

	@Override
	public String toString() {
		return "LoginBean [username=" + username + ", password=" + password + "]";
	}

	public LoginBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public LoginBean() {
		super();
	}
}
