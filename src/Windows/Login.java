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

	private JLabel jlusername, jlpassword;
	private JButton jbregister, jbaccess;
	private JTextField jtusername;
	private JPasswordField jppassword;

	public Login() {
		super("Login");
		setResizable(false);
		setBounds(100, 100, 250, 181);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		jlusername = new JLabel("Username:");
		jlusername.setBounds(25, 32, 70, 13);
		getContentPane().add(jlusername);

		jlpassword = new JLabel("Password:");
		jlpassword.setBounds(25, 55, 70, 13);
		getContentPane().add(jlpassword);

		jbregister = new JButton("Register");
		jbregister.setBounds(22, 93, 85, 21);
		getContentPane().add(jbregister);
		jbregister.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				Register reg = new Register();
				dispose();
			}
		});

		jbaccess = new JButton("Access");
		jbaccess.setBounds(128, 93, 85, 21);
		getContentPane().add(jbaccess);
		jbaccess.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow main = new MainWindow();
				dispose();
			}
		});

		jtusername = new JTextField();
		jtusername.setBounds(118, 29, 96, 19);
		getContentPane().add(jtusername);
		jtusername.setColumns(10);
		jtusername.setToolTipText("Introduce your user");

		jppassword = new JPasswordField();
		jppassword.setBounds(118, 52, 96, 21);
		getContentPane().add(jppassword);
		setVisible(true);
		jppassword.setToolTipText("Introduce your password");
	}

}
