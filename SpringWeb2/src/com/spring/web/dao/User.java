package com.spring.web.dao;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.spring.web.validation.ValidEmail;

public class User {

	@NotBlank(message="Username cannot be blank")
	@Size(min=4,max=15,message="Username must be in between 4 and 15")
	@Pattern(regexp="^\\w{4,}$",message="username must be alphanumeric")
	private String username;
	
	@NotBlank(message="Password cannot be blank")
	@Pattern(regexp="^\\S+$" , message="no space allowed")
	@Size(min=4, max=15, message="Password must be between 4 and 15")
	private String password;
	
	@ValidEmail
	private String email;
	
	private boolean enabled = false;
	private String authority;

	public User() {
	}

	public User(String username, String password, String email, boolean enabled, String authority) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.authority = authority;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", enabled=" + enabled
				+ ", authority=" + authority + "]";
	}

}
