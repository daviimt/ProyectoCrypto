package Windows;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import Entities.Crypto;

import java.awt.Color;
import java.awt.Font;

// TODO: Auto-generated Javadoc
/**
 * The Class Insert.
 */
@SuppressWarnings("serial")
public class Insert extends JFrame {

	/** The jlmonth. */
	private JLabel jlname, jlvalue, jlmarketCap, jlsupply, jldescription, jlimage, jlmonth;

	/** The jtmonth. */
	private JTextField jtname, jtvalue, jtmarketCap, jtsupply, jtdescription, jtmonth;

	/** The jbimage. */
	private JButton jbnext, jbcancel, jbimage;

	/** The icon. */
	private Icon icon;

	/** The os. */
	private ObjectOutputStream os;

	/** The is. */
	private ObjectInputStream is;

	/** The f. */
	private File f = new File("files/Cryptos");

	/**
	 * Instantiates a new insert.
	 *
	 * @param name the name
	 */
	public Insert(String name) {
		super("Insert cryptocurrency");
		inicializate(Insert.this);

		jlname = new JLabel("Name:");
		jlname.setBounds(123, 53, 45, 13);
		jlname.setHorizontalAlignment(SwingConstants.CENTER);
		jlname.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		add(jlname);

		jtname = new JTextField();
		jtname.setBounds(207, 50, 96, 19);
		jtname.setColumns(10);
		jtname.setToolTipText("Introduce a crypto name");
		add(jtname);

		jlvalue = new JLabel("Value:");
		jlvalue.setBounds(123, 76, 45, 13);
		jlvalue.setHorizontalAlignment(SwingConstants.CENTER);
		jlvalue.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		add(jlvalue);

		jtvalue = new JTextField();
		jtvalue.setBounds(207, 73, 96, 19);
		jtvalue.setColumns(10);
		jtvalue.setToolTipText("Introduce his value");
		add(jtvalue);

		jlmarketCap = new JLabel("Market Cap:");
		jlmarketCap.setBounds(93, 99, 75, 13);
		jlmarketCap.setHorizontalAlignment(SwingConstants.CENTER);
		jlmarketCap.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		add(jlmarketCap);

		jtmarketCap = new JTextField();
		jtmarketCap.setBounds(207, 96, 96, 19);
		jtmarketCap.setColumns(10);
		jtmarketCap.setToolTipText("Introduce his market cap");
		add(jtmarketCap);

		jlsupply = new JLabel("Supply:");
		jlsupply.setBounds(122, 122, 46, 13);
		jlsupply.setHorizontalAlignment(SwingConstants.CENTER);
		jlsupply.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		add(jlsupply);

		jtsupply = new JTextField();
		jtsupply.setBounds(207, 119, 96, 19);
		jtsupply.setColumns(10);
		jtsupply.setToolTipText("Introduce his supply");
		add(jtsupply);

		jlmonth = new JLabel("Month:");
		jlmonth.setBounds(122, 122, 46, 13);
		jlmonth.setHorizontalAlignment(SwingConstants.CENTER);
		jlmonth.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		add(jlmonth);

		jtmonth = new JTextField();
		jtmonth.setBounds(207, 119, 96, 19);
		jtmonth.setColumns(10);
		jtsupply.setToolTipText("Introduce the month of creation");
		add(jtmonth);

		jldescription = new JLabel("Description:");
		jldescription.setBounds(122, 122, 46, 13);
		jldescription.setHorizontalAlignment(SwingConstants.CENTER);
		jldescription.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		add(jldescription);

		jtdescription = new JTextField();
		jtdescription.setBounds(207, 119, 96, 19);
		jtdescription.setColumns(10);
		jtdescription.setToolTipText("Introduce his description");
		add(jtdescription);

		jlimage = new JLabel("Image:");
		jlimage.setBounds(122, 122, 46, 13);
		jlimage.setHorizontalAlignment(SwingConstants.CENTER);
		jlimage.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		add(jlimage);

		jbimage = new JButton("");
		jbimage.setBounds(101, 163, 85, 21);
		jbimage.setBackground(new Color(252, 228, 163));
		jbimage.setBorderPainted(false);
		jbimage.setToolTipText("Search");
		jbimage.setIcon(new ImageIcon("images/Upload.png"));
		jbimage.addActionListener(new InsertImg());
		add(jbimage);

		jbnext = new JButton("");
		jbnext.setBounds(101, 163, 85, 21);
		jbnext.setBackground(new Color(0, 153, 0));
		jbnext.setToolTipText("Confirm");
		jbnext.setIcon(new ImageIcon("images/BlackTick.png"));
		jbnext.addActionListener(new ActionListener() {

			/**
			 * Action performed.
			 *
			 * @param e the e
			 */
			@SuppressWarnings({ "unused" })
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean verification = true;
				boolean existCrypto = false;

				JTextField[] group = { jtname, jtvalue, jtmarketCap, jtsupply, jtmarketCap, jtdescription };

				for (JTextField j : group) {
					if (j.getText().isBlank()) {
						verification = false;
						break;
					}
				}

				try {
					is = new ObjectInputStream(new FileInputStream(f));
					Crypto c = (Crypto) is.readObject();
					while (c != null) {
						if (jtname.getText().equals(c.getName()))
							existCrypto = true;

						c = (Crypto) is.readObject();
					}
					is.close();
				} catch (Exception ex) {
				}

				if (verification) {
					if (existCrypto == false) {
						if (Integer.parseInt(jtmonth.getText()) >= 1 && Integer.parseInt(jtmonth.getText()) <= 12) {
							Crypto crypto = new Crypto(jtname.getText(), Float.parseFloat(jtvalue.getText()),
									Float.parseFloat(jtmarketCap.getText()), Float.parseFloat(jtsupply.getText()),
									jtdescription.getText(), icon, name, Integer.parseInt(jtmonth.getText()));

							try {
								abrir();
								os.writeObject(crypto);
								cerrar();
							} catch (IOException e1) {
								e1.printStackTrace();
							}

							icon = new ImageIcon("images/check.png");
							JOptionPane.showMessageDialog(null, "Crypto creation complete.", "Completed",
									JOptionPane.INFORMATION_MESSAGE, icon);
							dispose();
							MainWindow main = new MainWindow(name);
						} else {
							icon = new ImageIcon("images/warning.png");
							JOptionPane.showMessageDialog(null, "Month number must be between 1 and 12", "Error",
									JOptionPane.WARNING_MESSAGE, icon);
						}
					} else {
						icon = new ImageIcon("images/warning.png");
						JOptionPane.showMessageDialog(null, "This crypto exist", "Error", JOptionPane.WARNING_MESSAGE,
								icon);
					}

				} else {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(null, "Fill every required field to create the crypto.", "Error",
							JOptionPane.WARNING_MESSAGE, icon);
				}

			}
		});
		add(jbnext);

		jbcancel = new JButton("");
		jbcancel.setIcon(new ImageIcon("images/Cross.png"));
		jbcancel.setToolTipText("Cancel");
		jbcancel.setBackground(new Color(153, 0, 0));
		jbcancel.setBounds(218, 163, 85, 21);
		jbcancel.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow main = new MainWindow(name);
				dispose();
			}
		});
		add(jbcancel);

		setVisible(true);

	}

	/**
	 * Inicializate.
	 *
	 * @param jf the jf
	 */
	private void inicializate(JFrame jf) {

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBackground(Color.LIGHT_GRAY);
		jf.getContentPane().setBackground(new Color(252, 228, 163));
		jf.setSize(350, 300);
		jf.setMinimumSize(getSize());
		jf.setResizable(false);
		jf.setLayout(new GridLayout(8, 2));
		jf.setLocationRelativeTo(null);
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/CoinMarket.png");
		jf.setIconImage(icon1);
	}

	/**
	 * Abrir.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void abrir() throws IOException {
		File f = new File("files/Cryptos");
		try {
			if (f.exists())
				os = new AddObjectOutputStream(new FileOutputStream(f, true));
			else
				os = new ObjectOutputStream(new FileOutputStream(f));
		} catch (Exception ex) {
		}
	}

	/**
	 * Cerrar.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void cerrar() throws IOException {
		os.close();
	}

	/**
	 * The Class InsertImg.
	 */
	public class InsertImg implements ActionListener {

		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if (jtname.getText().equals("")) {
				icon = new ImageIcon("images/warning.png");
				JOptionPane.showMessageDialog(null, "The crypto name cant be empty", "", JOptionPane.ERROR_MESSAGE,
						icon);
			} else {

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

				FileNameExtensionFilter soloImg = new FileNameExtensionFilter("JPG & PNG Images", "png", "png");
				fileChooser.setFileFilter(soloImg);

				fileChooser.showSaveDialog(null);

				File imagenes = new File("images/" + jtname.getText() + ".png");

				Path sourcer = fileChooser.getSelectedFile().getAbsoluteFile().toPath();
				Path destination = imagenes.toPath();

				try {
					if (!imagenes.exists())
						Files.copy(sourcer, destination);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		}
	}
}
