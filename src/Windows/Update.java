package Windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Entities.Crypto;

import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class Update extends JFrame {

	private JLabel jlname, jlvalue, jlmarketCap, jlsupply, jldescription;
	private JTextField jtname, jtvalue, jtmarketCap, jtsupply, jtdescription;
	private JButton jbnext, jbcancel;
	private Icon icon;

	public Update() {
		super("Update cryptocurrency");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setSize(250, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(6, 2));
		setLocationRelativeTo(null);
		setMinimumSize(getSize());

		jlname = new JLabel("Name:");
		jlname.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		jlname.setHorizontalAlignment(SwingConstants.CENTER);
		jlname.setBounds(123, 53, 45, 13);
		getContentPane().add(jlname);

		jtname = new JTextField();
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
		jtsupply.setBounds(207, 119, 96, 19);
		jtsupply.setColumns(10);
		getContentPane().add(jtsupply);
		jtsupply.setToolTipText("Introduce his supply");

		jldescription = new JLabel("Description:");
		jldescription.setFont(new Font("Noto Sans Kannada", Font.PLAIN, 13));
		jldescription.setHorizontalAlignment(SwingConstants.CENTER);
		jldescription.setBounds(122, 122, 46, 13);
		getContentPane().add(jldescription);
		
		jtdescription = new JTextField();
		jtdescription.setBounds(207, 119, 96, 19);
		jtdescription.setColumns(10);
		getContentPane().add(jtdescription);
		jtdescription.setToolTipText("Introduce his description");
		
		// Buttons
		jbnext = new JButton("Continue");
		jbnext.setBounds(101, 163, 85, 21);
		getContentPane().add(jbnext);
		jbnext.addActionListener(new ActionListener() {

			@SuppressWarnings({ "unused" })
			@Override
			public void actionPerformed(ActionEvent e) {
				// Pendiente verificacion para usar los distintos constructores de User (campos
				// necesarios y no necesarios)
				// Pendiente verificacion filtros username, dni, email, phone, password y que
				// coincidan las contraseÃ¯Â¿Â½as entre ellas.
				//si el ultimo es true lo capta como esta bien (hay que estructurar la verificacion de nuevo)
				boolean verification;
				verification = isNotNull(jtname.getText());
				verification = isNotNull(jtvalue.getText());
				verification = isNotNull(jtmarketCap.getText());
				verification = isNotNull(jtsupply.getText());
				verification = isNotNull(jtdescription.getText());

				if (verification) {

					//error por el parseFloat (arreglarlo)
					Crypto crypto = new Crypto(jtname.getText(), Float.parseFloat(jtvalue.getText()),
							Float.parseFloat(jtmarketCap.getText()), Float.parseFloat(jtsupply.getText()),
							jtdescription.getText());
					
					icon=new ImageIcon("images/check.png");
					JOptionPane.showMessageDialog(null, "Crypto creation complete.","Completed",JOptionPane.INFORMATION_MESSAGE,icon);
					dispose();
					MainWindow main = new MainWindow();
				} else {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(null, "Fill every required field to create the crypto.", "Error",
							JOptionPane.WARNING_MESSAGE, icon);
				}

			}
		});

		jbcancel = new JButton("Cancel");
		jbcancel.setBounds(218, 163, 85, 21);
		getContentPane().add(jbcancel);
		jbcancel.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow main = new MainWindow();
				dispose();
			}
		});

		setVisible(true);
	}
	
	private boolean isNotNull(String s) {
		if (s.isBlank()) {
			return false;
		} else
			return true;

	}

}
