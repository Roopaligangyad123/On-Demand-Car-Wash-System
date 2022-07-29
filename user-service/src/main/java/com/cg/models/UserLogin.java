package com.cg.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="Login")
public class UserLogin 
{
	@Id
	private String username;
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
		return "UserLogin [username=" + username + ", password=" + password + "]";
	}
	public UserLogin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}
