package Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JLabel jlusername, jlpassword;
	private JButton jbregister, jbaccess;
	private JTextField jtusername;
	private JPasswordField jppassword;
	private AddObjectInputStream is;

	public Login() {
		super("Login");
		getContentPane().setBackground(Color.GRAY);
		setResizable(false);
		setBounds(100, 100, 250, 181);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		jlusername = new JLabel("Username:");
		jlusername.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		jlusername.setBounds(25, 32, 70, 21);
		getContentPane().add(jlusername);

		jlpassword = new JLabel("Password:");
		jlpassword.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		jlpassword.setBounds(25, 58, 70, 21);
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
				try {
					is.abrirUsu();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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
		jppassword.setToolTipText("Introduce your password");
		setVisible(true);
	}

}
