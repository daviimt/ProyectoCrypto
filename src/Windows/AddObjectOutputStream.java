package Windows;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AddObjectOutputStream extends ObjectOutputStream {

	protected void writeStreamHeader() throws IOException {

	}

	public AddObjectOutputStream() throws IOException {
		super();
	}

	public AddObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}
}
