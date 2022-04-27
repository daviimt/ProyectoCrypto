package Entities;

public class User {

	private String username, dni, correo, nombre, apellido1, apellido2, password, tlf;

	public User(String username, String dni, String correo, String nombre, String apellido1, String apellido2,
			String password, String tlf) {
		super();
		this.username = username;
		this.dni = dni;
		this.correo = correo;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.password = password;
		this.tlf = tlf;
	}

	public User(String username, String dni, String correo, String password, String tlf) {
		super();
		this.username = username;
		this.dni = dni;
		this.correo = correo;
		this.password = password;
		this.tlf = tlf;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", dni=" + dni + ", correo=" + correo + ", nombre=" + nombre
				+ ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", password=" + password + ", tlf=" + tlf
				+ "]";
	}

}
