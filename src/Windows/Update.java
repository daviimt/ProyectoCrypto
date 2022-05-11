package Windows;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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
 * The Class Update.
 */
@SuppressWarnings("serial")
public class Update extends JFrame {

	/** The jlmonth. */
	private JLabel jlname, jlvalue, jlmarketCap, jlsupply, jldescription, jlimage, jlmonth;

	/** The jtmonth. */
	private JTextField jtname, jtvalue, jtmarketCap, jtsupply, jtdescription, jtmonth;

	/** The jbimage. */
	private JButton jbnext, jbcancel, jbimage;

	/** The icon. */
	private Icon icon;

	/** The cryp. */
	static Crypto cryp;

	/** The os. */
	ObjectOutputStream os;

	/** The file. */
	File file = new File("files/Cryptos");

	/** The list C. */
	static List<Crypto> listC;

	/**
	 * Instantiates a new update.
	 *
	 * @param name        the name
	 * @param selectedRow the selected row
	 */
	public Update(String name, int selectedRow) {
		super("Update cryptocurrency");
		inicializate(Update.this);

		listC = MainWindow.getListC();

		jlname = new JLabel("Name:");
		jlname.setBounds(123, 53, 45, 13);
		jlname.setHorizontalAlignment(SwingConstants.CENTER);
		jlname.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		add(jlname);

		jtname = new JTextField();
		jtname.setBounds(207, 50, 96, 19);
		jtname.setColumns(10);
		jtname.setText(cryp.getName());
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
		jtvalue.setText(String.valueOf(cryp.getValue()));
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
		jtmarketCap.setText(String.valueOf(cryp.getMarketCap()));
		jtmarketCap.setToolTipText("Introduce his market cap");
		add(jtmarketCap);

		jlsupply = new JLabel("Supply:");
		jlsupply.setBounds(122, 122, 46, 13);
		jlsupply.setHorizontalAlignment(SwingConstants.CENTER);
		jlsupply.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		add(jlsupply);

		jtsupply = new JTextField();
		jtsupply.setBounds(207, 119, 96, 19);
		jtsupply.setText(String.valueOf(cryp.getSupply()));
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
		jtmonth.setText(String.valueOf(cryp.getMonth()));
		jtmonth.setToolTipText("Introduce the month of creation");
		add(jtmonth);

		jldescription = new JLabel("Description:");
		jldescription.setBounds(122, 122, 46, 13);
		jldescription.setHorizontalAlignment(SwingConstants.CENTER);
		jldescription.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		add(jldescription);

		jtdescription = new JTextField();
		jtdescription.setBounds(207, 119, 96, 19);
		jtdescription.setColumns(10);
		jtdescription.setText(cryp.getDescription());
		jtdescription.setToolTipText("Introduce the description");
		add(jtdescription);

		jlimage = new JLabel("Image:");
		jlimage.setBounds(122, 122, 46, 13);
		jlimage.setHorizontalAlignment(SwingConstants.CENTER);
		jlimage.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		add(jlimage);

		jbimage = new JButton("");
		jbimage.setIcon(new ImageIcon("images/Upload.png"));
		jbimage.setBackground(new Color(252, 228, 163));
		jbimage.setBorderPainted(false);
		jbimage.setToolTipText("Search");
		jbimage.setBounds(101, 163, 85, 21);
		InsertImg insertImg = new InsertImg();
		jbimage.addActionListener(insertImg);
		add(jbimage);

		jbnext = new JButton("");
		jbnext.setBounds(101, 163, 85, 21);
		jbnext.setBackground(new Color(0, 153, 0));
		jbnext.setToolTipText("Confirm");
		jbnext.setIcon(new ImageIcon("images/BlackTick.png"));
		jbnext.addActionListener(new ActionListener() {

			@SuppressWarnings({ "unused" })
			@Override
			public void actionPerformed(ActionEvent e) {
				// Comprobadores
				boolean verification = true;
				boolean existCrypto = false;

				// Array de valores de crypto
				String[] group = { jtname.getText(), jtvalue.getText(), jtmarketCap.getText(), jtsupply.getText(),
						cryp.getDescription(), jtmonth.getText() };

				// Se recorre Array comprobando que no sea nulo
				for (String j : group) {
					if (j.isBlank()) {
						verification = false;
						break;
					}

				}

				// Comprobacion todos los campos rellenos + instanciacion crypto
				if (verification) {
					icon = new ImageIcon("images/warning.png");
					int option = JOptionPane.showOptionDialog(Update.this, "Are you sure?", "Confirm",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, null, null);
					if (option == 0) {

						listC.remove(selectedRow);
						icon = new ImageIcon("images/" + jtname.getText() + ".png");

						Crypto crypto;
						if (jbimage.getIcon() == null) {
							crypto = new Crypto(jtname.getText(), Float.parseFloat(jtvalue.getText()),
									Float.parseFloat(jtmarketCap.getText()), Float.parseFloat(jtsupply.getText()),
									jtdescription.getText(), name, Integer.parseInt(jtmonth.getText()));
						} else {
							crypto = new Crypto(jtname.getText(), Float.parseFloat(jtvalue.getText()),
									Float.parseFloat(jtmarketCap.getText()), Float.parseFloat(jtsupply.getText()),
									jtdescription.getText(), jbimage.getIcon(), name,
									Integer.parseInt(jtmonth.getText()));
						}
						listC.add(crypto);

						try {
							int cont2 = 0;
							for (Crypto cp : listC) {
								if (cont2 == 0) {
									os = new ObjectOutputStream(new FileOutputStream(file));
									os.writeObject(cp);
									os.close();
								} else {
									os = new AddObjectOutputStream(new FileOutputStream(file, true));
									os.writeObject(cp);
									os.close();
								}
								cont2++;
							}
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}

						dispose();
						MainWindow main = new MainWindow(name);
					} else {
						dispose();
						MainWindow main = new MainWindow(name);
					}
				} else {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(null, "Fill every required field to update the crypto.", "Error",
							JOptionPane.WARNING_MESSAGE, icon);
				}
			}
		});
		add(jbnext);

		// Configuracion boton cancel
		jbcancel = new JButton("");
		jbcancel.setBounds(218, 163, 85, 21);
		jbcancel.setBackground(new Color(153, 0, 0));
		jbcancel.setToolTipText("Cancel");
		jbcancel.setIcon(new ImageIcon("images/Cross.png"));
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
		jf.setLocationRelativeTo(null);
		jf.setLayout(new GridLayout(8, 2));
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/CoinMarket.png");
		jf.setIconImage(icon1);
	}

	/**
	 * Gets the list C.
	 *
	 * @return the list C
	 */
	// Metodo para obtener lista de las cryptos
	public List<Crypto> getListC() {
		return listC;
	}

	/**
	 * Sets the list C.
	 *
	 * @param listC the new list C
	 */
	public void setListC(List<Crypto> listC) {
		Update.listC = listC;
	}

	/**
	 * The Class InsertImg.
	 */
	// Manejador Boton Insertar Imagen
	public class InsertImg implements ActionListener {

		/**
		 * Action performed.
		 *
		 * @param e the e
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (jtname.getText().equals("")) {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(null, "The crypto name cant be empty", "Error",
							JOptionPane.ERROR_MESSAGE, icon);
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
						Files.copy(sourcer, destination);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			} catch (NullPointerException NPE) {
				JOptionPane.showMessageDialog(null, "You haven't choose any image", "Information",
						JOptionPane.INFORMATION_MESSAGE, icon);
			}
		}
	}
}
