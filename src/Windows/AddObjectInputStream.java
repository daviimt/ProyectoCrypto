package Windows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import Entities.Crypto;
import Entities.User;

public class AddObjectInputStream extends ObjectInputStream {
	ObjectInputStream is;
	
	protected AddObjectInputStream() throws IOException, SecurityException {
		super();
		
	}
	
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
	
	public void cerrar() throws IOException {
		is.close();
	}
}
