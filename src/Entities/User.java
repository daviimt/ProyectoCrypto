package Entities;

public class User {

	private String username, dni, correo, nombre, apellido1, apellido2, password;
	private int tlf;

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * @param apellido1 the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * @param apellido2 the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * @return the tlf
	 */
	public int getTlf() {
		return tlf;
	}

	/**
	 * @param tlf the tlf to set
	 */
	public void setTlf(int tlf) {
		this.tlf = tlf;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User(String username, String dni, String correo, String nombre, String apellido1, String apellido2,
			String password, int tlf) {
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

	public User(String username, String dni, String correo, String password, int tlf) {
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

}
