package Windows;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
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

@SuppressWarnings("serial")
public class Update extends JFrame {

	private JLabel jlname, jlvalue, jlmarketCap, jlsupply, jldescription, jlimage, jlmonth;
	private JTextField jtname, jtvalue, jtmarketCap, jtsupply, jtdescription, jtmonth;
	private JButton jbnext, jbcancel, jbimage;
	private Icon icon;
	static Crypto cryp;

	public Update(String name) {
		super("Update cryptocurrency");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setSize(350, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(8, 2));
		setLocationRelativeTo(null);
		setMinimumSize(getSize());
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/CoinMarket.png");
		setIconImage(icon1);

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
		//jtdescription.setText(cryp.getDescription());
		jldescription.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		jldescription.setHorizontalAlignment(SwingConstants.CENTER);
		jldescription.setBounds(122, 122, 46, 13);
		getContentPane().add(jldescription);

		jtdescription = new JTextField();
		jtdescription.setBounds(207, 119, 96, 19);
		jtdescription.setColumns(10);
		getContentPane().add(jtdescription);
		jtdescription.setToolTipText("Introduce his description");

		jlimage = new JLabel("Image:");
		jlimage.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		jlimage.setHorizontalAlignment(SwingConstants.CENTER);
		jlimage.setBounds(122, 122, 46, 13);
		getContentPane().add(jlimage);

		// Buttons
		jbimage = new JButton("Image");
		jbimage.setIcon(new ImageIcon("images/Upload.png"));
		jbimage.setBounds(101, 163, 85, 21);
		getContentPane().add(jbimage);
		InsertImg insertImg = new InsertImg();
		jbimage.addActionListener(insertImg);

		jbnext = new JButton("Continue");
		jbnext.setIcon(new ImageIcon("images/BlackTick.png"));
		jbnext.setBackground(new Color(0, 153, 0));
		jbnext.setBounds(101, 163, 85, 21);
		getContentPane().add(jbnext);
		jbnext.addActionListener(new ActionListener() {

			@SuppressWarnings({ "unused" })
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean verification = true;

				JTextField[] group = { jtname, jtvalue, jtmarketCap, jtsupply, jtmarketCap, jtdescription };

				for (JTextField j : group) {
					if (j.getText().isBlank()) {
						verification = false;
						break;
					}

				}

				if (verification) {
					Crypto crypto = new Crypto(jtname.getText(), Float.parseFloat(jtvalue.getText()),
							Float.parseFloat(jtmarketCap.getText()), Float.parseFloat(jtsupply.getText()),
							jtdescription.getText(), name, Integer.parseInt(jtmonth.getText()));

					icon = new ImageIcon("images/check.png");
					JOptionPane.showMessageDialog(null, "Crypto creation complete.", "Completed",
							JOptionPane.INFORMATION_MESSAGE, icon);
					dispose();
					MainWindow main = new MainWindow(name);

				} else {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(null, "Fill every required field to create the crypto.", "Error",
							JOptionPane.WARNING_MESSAGE, icon);
				}
			}
		});

		jbcancel = new JButton("Cancel");
		jbcancel.setIcon(new ImageIcon("images/Cross.png"));
		jbcancel.setBackground(new Color(153, 0, 0));
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

	public class InsertImg implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (jtname.getText().equals("")) {
				icon = new ImageIcon("images/warning.png");
				JOptionPane.showMessageDialog(null, "The crypto name cant be empty", "Error", JOptionPane.ERROR_MESSAGE,
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
					Files.copy(sourcer, destination);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		}
	}
}
