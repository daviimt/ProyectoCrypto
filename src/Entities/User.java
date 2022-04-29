package Entities;

public class User {

	private String username, dni, correo, name, password;

	public User(String username, String dni, String correo, String name, String apellido1, String apellido2,
			String password, String tlf) {
		super();
		this.username = username;
		this.dni = dni;
		this.correo = correo;
		this.name = name;
		this.password = password;
	}

	public User(String username, String dni, String correo, String password, String tlf) {
		super();
		this.username = username;
		this.dni = dni;
		this.correo = correo;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", dni=" + dni + ", correo=" + correo + ", name=" + name + ", password="
				+ password + "]";
	}

}