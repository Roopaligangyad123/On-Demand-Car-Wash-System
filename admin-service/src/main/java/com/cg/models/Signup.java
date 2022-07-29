package com.cg.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "signup")
public class Signup {

	@Id
	private int id;
	@NotEmpty(message = "Name must not be empty")
	private String name;
	@NotEmpty(message = "userName must not be empty")
	private String username;
	@NotEmpty(message = "password Must not be empty")
	@Size(min=8,message="Not Strong Password")
	private String password;
	private String confirmpassword;
	@NotEmpty(message = "Contact Number must not be empty")
	@Size(max=10,message="10 Digit Mobile Number")
	private String contactno;
	@NotEmpty(message = "Emailid must not be empty")
	private String email;

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

	public Signup() {
		super();
	}

	public Signup(int id, @NotEmpty(message = "Name must not be empty") String name,
			@NotEmpty(message = "userName must not be empty") String username,
			@NotEmpty(message = "password Must not be empty") @Size(min = 8, message = "Not Strong Password") String password,
			String confirmpassword,
			@NotEmpty(message = "Contact Number must not be empty") @Size(max = 10, message = "10 Digit Mobile Number") String contactno,
			@NotEmpty(message = "Emailid must not be empty") String email) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.contactno = contactno;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	@Override
	public String toString() {
		return "Signup [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", confirmpassword=" + confirmpassword + ", contactno=" + contactno + ", email=" + email + "]";
	}

	
}
