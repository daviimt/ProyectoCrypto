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

@SuppressWarnings("serial")
public class Update extends JFrame {

	private JLabel jlname, jlvalue, jlmarketCap, jlsupply, jldescription, jlimage, jlmonth;
	private JTextField jtname, jtvalue, jtmarketCap, jtsupply, jtdescription, jtcreator, jtmonth;
	private JButton jbnext, jbcancel, jbimage;
	private Icon icon;
	static Crypto cryp;
	private ObjectOutputStream os;
	private File f = new File("files/Cryptos");
	static List<Crypto> listC;

	public Update(String name, int selectedRow) {
		super("Update cryptocurrency");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setSize(350, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(8, 2));
		setLocationRelativeTo(null);
		setMinimumSize(getSize());
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/CoinMarket.png");
		setIconImage(icon1);

		listC = MainWindow.getListC();

		jlname = new JLabel("Name:");
		jlname.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		jlname.setHorizontalAlignment(SwingConstants.CENTER);
		jlname.setBounds(123, 53, 45, 13);
		getContentPane().add(jlname);

		jtname = new JTextField();
		jtname.setText(cryp.getName());
		jtname.setBounds(207, 50, 96, 19);
		jtname.setColumns(10);
		getContentPane().add(jtname);
		jtname.setToolTipText("Introduce a crypto name");

		jlvalue = new JLabel("Value:");
		jlvalue.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		jlvalue.setHorizontalAlignment(SwingConstants.CENTER);
		jlvalue.setBounds(123, 76, 45, 13);
		getContentPane().add(jlvalue);

		jtvalue = new JTextField();
		jtvalue.setText(String.valueOf(cryp.getValue()));
		jtvalue.setBounds(207, 73, 96, 19);
		jtvalue.setColumns(10);
		getContentPane().add(jtvalue);
		jtvalue.setToolTipText("Introduce his value");

		jlmarketCap = new JLabel("Market Cap:");
		jlmarketCap.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		jlmarketCap.setHorizontalAlignment(SwingConstants.CENTER);
		jlmarketCap.setBounds(93, 99, 75, 13);
		getContentPane().add(jlmarketCap);

		jtmarketCap = new JTextField();
		jtmarketCap.setText(String.valueOf(cryp.getMarketCap()));
		getContentPane().add(jtmarketCap);
		jtmarketCap.setBounds(207, 96, 96, 19);
		jtmarketCap.setColumns(10);
		jtmarketCap.setToolTipText("Introduce his market cap");

		jlsupply = new JLabel("Supply:");
		jlsupply.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		jlsupply.setHorizontalAlignment(SwingConstants.CENTER);
		jlsupply.setBounds(122, 122, 46, 13);
		getContentPane().add(jlsupply);

		jtsupply = new JTextField();
		jtsupply.setText(String.valueOf(cryp.getSupply()));
		jtsupply.setBounds(207, 119, 96, 19);
		jtsupply.setColumns(10);
		getContentPane().add(jtsupply);
		jtsupply.setToolTipText("Introduce his supply");

		jlmonth = new JLabel("Month:");
		jlmonth.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		jlmonth.setHorizontalAlignment(SwingConstants.CENTER);
		jlmonth.setBounds(122, 122, 46, 13);
		getContentPane().add(jlmonth);

		jtmonth = new JTextField();
		jtmonth.setText(String.valueOf(cryp.getMonth()));
		jtmonth.setBounds(207, 119, 96, 19);
		jtmonth.setColumns(10);
		getContentPane().add(jtmonth);
		jtmonth.setToolTipText("Introduce the month of creation");

		jldescription = new JLabel("Description:");
		jldescription.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		jldescription.setHorizontalAlignment(SwingConstants.CENTER);
		jldescription.setBounds(122, 122, 46, 13);
		getContentPane().add(jldescription);

		jtdescription = new JTextField();
		jtdescription.setText(cryp.getDescription());
		jtdescription.setBounds(207, 119, 96, 19);
		jtdescription.setColumns(10);
		getContentPane().add(jtdescription);
		jtdescription.setToolTipText("Introduce the description");


		jlimage = new JLabel("Image:");
		jlimage.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		jlimage.setHorizontalAlignment(SwingConstants.CENTER);
		jlimage.setBounds(122, 122, 46, 13);
		getContentPane().add(jlimage);

		// Buttons
		jbimage = new JButton("");
		jbimage.setIcon(new ImageIcon("images/Upload.png"));
		jbimage.setBackground(Color.GRAY);
		jbimage.setToolTipText("Search");
		jbimage.setBounds(101, 163, 85, 21);
		getContentPane().add(jbimage);
		InsertImg insertImg = new InsertImg();
		jbimage.addActionListener(insertImg);

		// Boton para confirmar la actualizacion
		jbnext = new JButton("");
		jbnext.setIcon(new ImageIcon("images/BlackTick.png"));
		jbnext.setToolTipText("Confirm");
		jbnext.setBackground(new Color(0, 153, 0));
		jbnext.setBounds(101, 163, 85, 21);
		getContentPane().add(jbnext);
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
					Crypto crypto = new Crypto(jtname.getText(), Float.parseFloat(jtvalue.getText()),
							Float.parseFloat(jtmarketCap.getText()), Float.parseFloat(jtsupply.getText()),
							cryp.getDescription(), name, Integer.parseInt(jtmonth.getText()));

					// Escritura de la crypto
					/*
					 * try { abrir(); os.writeObject(crypto); cerrar(); } catch (IOException e1) {
					 * e1.printStackTrace(); }
					 */

					/*
					 * System.out.println(selectedRow); int contCrypto = (int)
					 * getListC().stream().count(); System.out.println(contCrypto);
					 */

					// aqui empieza el delete
					// Comprobacion, seleccionado dentro del array
//				if (selectedRow >= 0) {
//						System.out.println("selectedRow >= 0");
//
//					if (cryp.getCreator().equals(name) || name.equals("admin")) {
					System.out.println("cryp.getCreator().equals(name) || name.equals(\"admin\")");
					icon = new ImageIcon("images/warning.png");
					int option = JOptionPane.showOptionDialog(jbnext, "Are you sure?", "Confirm",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, null, null);
					if (option == 0) {

						listC.remove(selectedRow);
						icon = new ImageIcon("images/" + jtname.getText() + ".png");
						Crypto c = new Crypto(jtname.getText(), Float.parseFloat(jtvalue.getText()),
								Float.parseFloat(jtmarketCap.getText()), Float.parseFloat(jtsupply.getText()),
								jtdescription.getText(), icon, jtcreator.getText(),
								Integer.parseInt(jtmonth.getText()));
						listC.add(c);
						f.delete();

						try {
							os = new ObjectOutputStream(new FileOutputStream(f));
							os.writeObject(crypto);
							os.close();
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}

						// System.out.println("option == 0");

//								if (contCrypto != 1) {
//									System.out.println("contCrypto != 1");
//									getListC().remove(selectedRow);
//									int cont = 0;
//									for (Crypto c : getListC()) {
//										Crypto crypto1 = new Crypto(c.getName(), c.getValue(), c.getMarketCap(),
//												c.getSupply(), c.getDescription(), c.getIcon(), c.getCreator(),
//												c.getMonth());
//										try {
//											if (cont == 0) {
//												System.out.println("cont == 0");
//												os = new ObjectOutputStream(new FileOutputStream(f));
//											} else {
//												System.out.println("else cont == 0");
//												os = new AddObjectOutputStream(new FileOutputStream(f, true));
//											}
//											os.writeObject(crypto);
//											os.close();
//										} catch (FileNotFoundException e1) {
//											e1.printStackTrace();
//										} catch (IOException e1) {
//											e1.printStackTrace();
//										}
//										cont++;
//									}
//									dispose();
//									MainWindow main = new MainWindow(name);
//								} else {
//									System.out.println("else contCrypto != 1");
//									f.delete();
//									dispose();
//									MainWindow main = new MainWindow(name);
//								}
						dispose();
						MainWindow main = new MainWindow(name);
					} else {
						System.out.println("else option == 0");
						dispose();
						MainWindow main = new MainWindow(name);
					}
					// Si no se es creador:
//						} else {
//							System.out.println("else cryp.getCreator().equals(name) || name.equals(\"admin\")");
//							icon = new ImageIcon("images/warning.png");
//							JOptionPane.showMessageDialog(Update.this, "You dont be creator", "Error",
//									JOptionPane.WARNING_MESSAGE, icon);
//						}
//						//Si no se ha seleccionado una crypto
//					} else {
//						System.out.println("else selectedRow >= 0");
//						icon = new ImageIcon("images/warning.png");
//						JOptionPane.showMessageDialog(Update.this, "You haven't to select a crypto", "Error",
//								JOptionPane.WARNING_MESSAGE, icon);
//					}

//					icon = new ImageIcon("images/check.png");
//					JOptionPane.showMessageDialog(null, "Crypto update complete.", "Completed",
//							JOptionPane.INFORMATION_MESSAGE, icon);

					// Si no se cumple verification
				} else {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(null, "Fill every required field to update the crypto.", "Error",
							JOptionPane.WARNING_MESSAGE, icon);
				}
			}
		});

		// Configuracion boton cancel
		jbcancel = new JButton("");
		jbcancel.setIcon(new ImageIcon("images/Cross.png"));
		jbcancel.setBackground(new Color(153, 0, 0));
		jbcancel.setToolTipText("Cancel");
		jbcancel.setBounds(218, 163, 85, 21);
		getContentPane().add(jbcancel);
		jbcancel.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow main = new MainWindow(name);
				dispose();
			}
		});

		setVisible(true);
	}

	// Metodos para abrir y cerrar los objetos que leen el archivo binario.
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

	// Metodo para cerrar el ObjectOutputStream
	public void cerrar() throws IOException {
		os.close();
	}

	// Metodo para obtener lista de las cryptos
	public static List<Crypto> getListC() {
		return listC;
	}

	public static void setListC(List<Crypto> listC) {
		Update.listC = listC;
	}

	// Manejador Boton Insertar Imagen
	public class InsertImg implements ActionListener {

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
