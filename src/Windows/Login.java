package Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Login extends JFrame {

	JLabel username, password;
	JButton register, access;
	JTextField usernamef;
	JPasswordField passwordf;

	public Login() {
		super("Login");
		setResizable(false);
		setBounds(100, 100, 250, 181);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		username = new JLabel("Username:");
		username.setBounds(25, 32, 70, 13);
		getContentPane().add(username);

		password = new JLabel("Password:");
		password.setBounds(25, 55, 70, 13);
		getContentPane().add(password);

		register = new JButton("Register");
		register.setBounds(22, 93, 85, 21);
		getContentPane().add(register);
		register.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				Register reg = new Register();
				dispose();
			}
		});

		access = new JButton("Access");
		access.setBounds(128, 93, 85, 21);
		getContentPane().add(access);
		access.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow main = new MainWindow();
				dispose();
			}
		});

		usernamef = new JTextField();
		usernamef.setBounds(118, 29, 96, 19);
		getContentPane().add(usernamef);
		usernamef.setColumns(10);

		passwordf = new JPasswordField();
		passwordf.setBounds(118, 52, 96, 21);
		getContentPane().add(passwordf);
		setVisible(true);
	}

}
