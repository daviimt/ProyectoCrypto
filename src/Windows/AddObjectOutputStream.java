package Windows;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AddObjectOutputStream extends ObjectOutputStream {
	ObjectOutputStream os;

	protected void writeStreamHeader() throws IOException {

	}

	public AddObjectOutputStream() throws IOException {
		super();
	}

	public AddObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}
	
	public void abrir(String nameFile) throws IOException {
		File f = new File("files/"+nameFile);
		try {
			if (f.exists())
				os = new AddObjectOutputStream(new FileOutputStream(f, true));
			else
				os = new ObjectOutputStream(new FileOutputStream(f));
		} catch (Exception ex) {
		}
	}

	public void cerrar() throws IOException {
		os.close();
	}
}
