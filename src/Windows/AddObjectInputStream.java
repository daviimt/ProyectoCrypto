package Windows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import Entities.Crypto;
import Entities.User;

// TODO: Auto-generated Javadoc
/**
 * The Class AddObjectInputStream.
 */
public class AddObjectInputStream extends ObjectInputStream {
	
	/** The is. */
	ObjectInputStream is;
	
	/**
	 * Instantiates a new adds the object input stream.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws SecurityException the security exception
	 */
	protected AddObjectInputStream() throws IOException, SecurityException {
		super();
		
	}
	
	/**
	 * Abrir usu.
	 *
	 * @param username the username
	 * @return the user
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the class not found exception
	 */
	public User abrirUsu(String username) throws FileNotFoundException, IOException, ClassNotFoundException {
		File f = new File("files/User");
		is = new ObjectInputStream(new FileInputStream(f));
		User u = (User) is.readObject();
		try {
				while(u!=null) {
				if(u.getUsername().equals(username)) {
					return u;
				}else {
					u = (User) is.readObject();					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * Abrir crypto.
	 *
	 * @param cryptoName the crypto name
	 * @return the crypto
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException the class not found exception
	 */
	public Crypto abrirCrypto(String cryptoName) throws FileNotFoundException, IOException, ClassNotFoundException {
		File f = new File("files/Crypto");
		is = new ObjectInputStream(new FileInputStream(f));
		Crypto c = (Crypto) is.readObject();
		try {
				while(c!=null) {
				if(c.getName().equals(cryptoName)) {
					return c;
				}
				c = (Crypto) is.readObject();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return null;
	}
	
	/**
	 * Cerrar.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void cerrar() throws IOException {
		is.close();
	}
}
