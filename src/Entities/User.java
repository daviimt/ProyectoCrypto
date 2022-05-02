package Entities;

import java.io.Serializable;

public class User implements Serializable{

	private String username, name, dni, email, password;

	public User(String username, String name, String dni, String email, String password) {
		super();
		this.username = username;
		this.name = name;
		this.dni = dni;
		this.email = email;
		this.password = password;
	}

	public User() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", dni=" + dni + ", email=" + email + ", password="
				+ password + "]";
	}

}