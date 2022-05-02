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
	
	public void abrirUsu() throws FileNotFoundException, IOException, ClassNotFoundException {
		File f = new File("files/User");
		is = new ObjectInputStream(new FileInputStream(f));
		User u = (User) is.readObject();
		try {
				while(u!=null) {
				System.out.println(u);
				u = (User) is.readObject();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void abrirCrypto() throws FileNotFoundException, IOException, ClassNotFoundException {
		File f = new File("files/Crypto");
		is = new ObjectInputStream(new FileInputStream(f));
		Crypto c = (Crypto) is.readObject();
		try {
				while(c!=null) {
				System.out.println(c);
				c = (Crypto) is.readObject();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void cerrar() throws IOException {
		is.close();
	}
}
