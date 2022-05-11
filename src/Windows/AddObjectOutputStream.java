package Windows;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class AddObjectOutputStream.
 */
public class AddObjectOutputStream extends ObjectOutputStream {

	/**
	 * Write stream header.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void writeStreamHeader() throws IOException {

	}

	/**
	 * Instantiates a new adds the object output stream.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public AddObjectOutputStream() throws IOException {
		super();
	}

	/**
	 * Instantiates a new adds the object output stream.
	 *
	 * @param out the out
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public AddObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}
}
