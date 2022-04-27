package Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Entities.User;

@SuppressWarnings("serial")
public class Register extends JFrame {

	private JLabel username, name, fname, lname, dni, email, phone, password, rpassword;
	private JTextField usernamef, namef, fnamef, lnamef, dnif, emailf, phonef;
	private JPasswordField passwordf, rpasswordf;
	private JPanel panel;

	public Register() {

		// Setting the window options.

		setTitle("Register User: ");
		setBounds(100, 100, 600, 505);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		// Instantiation and addition of every component .

		panel = new JPanel();
		panel.setBounds(150, 61, 277, 283);
		getContentPane().add(panel);
		panel.setLayout(null);

		username = new JLabel("Username:");
		username.setBounds(43, 30, 75, 13);
		panel.add(username);

		usernamef = new JTextField();
		usernamef.setBounds(119, 27, 114, 19);
		panel.add(usernamef);
		usernamef.setColumns(10);

		name = new JLabel("Name: ");
		name.setBounds(43, 53, 75, 13);
		panel.add(name);

		namef = new JTextField();
		namef.setBounds(119, 50, 114, 19);
		panel.add(namef);
		namef.setColumns(10);

		fname = new JLabel("First Name: ");
		fname.setBounds(43, 76, 75, 13);
		panel.add(fname);

		fnamef = new JTextField();
		fnamef.setBounds(119, 73, 114, 19);
		panel.add(fnamef);
		fnamef.setColumns(10);

		lname = new JLabel("Last Name: ");
		lname.setBounds(43, 99, 75, 13);
		panel.add(lname);

		lnamef = new JTextField();
		lnamef.setBounds(119, 96, 114, 19);
		panel.add(lnamef);
		lnamef.setColumns(10);

		dni = new JLabel("D.N.I. : ");
		dni.setBounds(43, 122, 75, 13);
		panel.add(dni);

		dnif = new JTextField();
		dnif.setBounds(119, 119, 114, 19);
		panel.add(dnif);
		dnif.setColumns(12);

		email = new JLabel("Email: ");
		email.setBounds(43, 145, 75, 13);
		panel.add(email);

		emailf = new JTextField();
		emailf.setBounds(119, 142, 114, 19);
		panel.add(emailf);
		emailf.setColumns(13);

		phone = new JLabel("Phone: ");
		phone.setBounds(43, 168, 75, 13);
		panel.add(phone);

		phonef = new JTextField();
		phonef.setBounds(119, 165, 114, 19);
		panel.add(phonef);
		phonef.setColumns(10);

		password = new JLabel("Password: ");
		password.setBounds(43, 191, 75, 13);
		panel.add(password);

		passwordf = new JPasswordField();
		passwordf.setBounds(119, 188, 114, 19);
		passwordf.setColumns(10);
		panel.add(passwordf);

		rpassword = new JLabel("Repeat Pass.: ");
		rpassword.setBounds(34, 214, 84, 13);
		panel.add(rpassword);

		rpasswordf = new JPasswordField();
		rpasswordf.setBounds(119, 211, 114, 19);
		rpasswordf.setColumns(10);
		panel.add(rpasswordf);

		// This button tries to create the user that will be added to the binary file.

		JButton confirm = new JButton("Confirm");
		confirm.setBounds(150, 364, 85, 21);
		getContentPane().add(confirm);
		confirm.addActionListener(new ActionListener() {

			@SuppressWarnings({ "unused", "deprecation" })
			@Override
			public void actionPerformed(ActionEvent e) {
				// Pendiente verificacion para usar los distintos constructores de User (campos
				// necesarios y no necesarios)
				// Pendiente verificacion filtros username, dni, email, phone, password y que
				// coincidan las contraseñas entre ellas.
				boolean verification;
				verification = isNotNull(usernamef.getText());
				verification = isNotNull(namef.getText());
				verification = isNotNull(fnamef.getText());
				verification = isNotNull(lnamef.getText());
				verification = isNotNull(dnif.getText());
				verification = isNotNull(emailf.getText());
				verification = isNotNull(phonef.getText());
				verification = isNotNull(passwordf.getText());
				verification = isNotNull(rpasswordf.getText());

				if (verification) {
					User user = new User(usernamef.getText(), dnif.getText(), emailf.getText(), namef.getText(),
							fnamef.getText(), lnamef.getText(), passwordf.getText(), phonef.getText());
					JOptionPane.showMessageDialog(null, "User creation complete.");
				} else
					JOptionPane.showMessageDialog(null, "Fill every required field to create the user.");

				Login login = new Login();
				dispose();

			}
		});

		// This button return to the Login and close Register's window.

		JButton cancel = new JButton("Cancel");
		cancel.setBounds(342, 364, 85, 21);
		getContentPane().add(cancel);
		cancel.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login = new Login();

			}
		});
		setVisible(true);
	}

	// Method to verificate if a Field is null or not

	private boolean isNotNull(String s) {
		if (s.isBlank()) {
			return false;
		} else
			return true;

	}

}
