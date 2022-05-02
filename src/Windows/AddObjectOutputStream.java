package Windows;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AddObjectOutputStream extends ObjectOutputStream {
	// Sobrescribimos el m�todo que crea la cabecera
	protected void writeStreamHeader() throws IOException {
		// No hacer nada.
	}

	// Constructores
	public AddObjectOutputStream() throws IOException {
		super();
	}

	public AddObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}
}
