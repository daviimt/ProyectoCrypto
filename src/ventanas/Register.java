package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Register extends JFrame {

	JLabel username, password, tlf;
	JButton register, back;
	JTextField usernamef, tlff;
	JPasswordField passwordf;

	public Register() {
		setBounds(100, 100, 250, 181);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		username = new JLabel("Username:");
		username.setBounds(25, 10, 70, 13);
		getContentPane().add(username);

		password = new JLabel("Password:");
		password.setBounds(25, 33, 70, 13);
		getContentPane().add(password);

		tlf = new JLabel("Tlfno. :");
		tlf.setBounds(25, 56, 70, 13);
		getContentPane().add(tlf);

		register = new JButton("Register");
		register.setBounds(10, 93, 85, 21);
		getContentPane().add(register);
		register.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				dispose();

			}
		});

		back = new JButton("Back");
		back.setBounds(141, 93, 85, 21);
		getContentPane().add(back);
		back.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				dispose();

			}
		});

		usernamef = new JTextField();
		usernamef.setBounds(118, 7, 96, 19);
		getContentPane().add(usernamef);
		usernamef.setColumns(10);

		passwordf = new JPasswordField();
		passwordf.setBounds(118, 30, 96, 19);
		getContentPane().add(passwordf);
		passwordf.setColumns(10);

		tlff = new JTextField();
		tlff.setBounds(118, 53, 96, 19);
		getContentPane().add(tlff);
		tlff.setColumns(10);

		setVisible(true);

	}

}
