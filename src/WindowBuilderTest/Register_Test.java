package WindowBuilderTest;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register_Test {

	private JFrame frmRegister;
	private JTextField usernamef;
	private JTextField namef;
	private JTextField fnamef;
	private JTextField lnamef;
	private JTextField dnif;
	private JTextField emailf;
	private JTextField textField_6;
	private JPasswordField passwordField;
	private JPasswordField rpasswordf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_Test window = new Register_Test();
					window.frmRegister.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register_Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegister = new JFrame();
		frmRegister.setTitle("Register");
		frmRegister.setBounds(100, 100, 600, 505);
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegister.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(150, 61, 277, 283);
		frmRegister.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel username = new JLabel("Username:");
		username.setBounds(43, 30, 75, 13);
		panel.add(username);

		usernamef = new JTextField();
		usernamef.setBounds(119, 27, 114, 19);
		panel.add(usernamef);
		usernamef.setColumns(10);

		JLabel name = new JLabel("Name: ");
		name.setBounds(43, 53, 75, 13);
		panel.add(name);

		namef = new JTextField();
		namef.setBounds(119, 50, 114, 19);
		panel.add(namef);
		namef.setColumns(10);

		JLabel fname = new JLabel("First Name: ");
		fname.setBounds(43, 76, 75, 13);
		panel.add(fname);

		fnamef = new JTextField();
		fnamef.setBounds(119, 73, 114, 19);
		panel.add(fnamef);
		fnamef.setColumns(10);

		JLabel lname = new JLabel("Last Name: ");
		lname.setBounds(43, 99, 75, 13);
		panel.add(lname);

		lnamef = new JTextField();
		lnamef.setBounds(119, 96, 114, 19);
		panel.add(lnamef);
		lnamef.setColumns(10);

		JLabel dni = new JLabel("D.N.I. : ");
		dni.setBounds(43, 122, 75, 13);
		panel.add(dni);

		dnif = new JTextField();
		dnif.setBounds(119, 119, 114, 19);
		panel.add(dnif);
		dnif.setColumns(12);

		JLabel email = new JLabel("Email: ");
		email.setBounds(43, 145, 75, 13);
		panel.add(email);

		emailf = new JTextField();
		emailf.setBounds(119, 142, 114, 19);
		panel.add(emailf);
		emailf.setColumns(13);

		JLabel phone = new JLabel("Phone: ");
		phone.setBounds(43, 168, 75, 13);
		panel.add(phone);

		textField_6 = new JTextField();
		textField_6.setBounds(119, 188, 114, 19);
		panel.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Password: ");
		lblNewLabel_7.setBounds(43, 191, 75, 13);
		panel.add(lblNewLabel_7);

		passwordField = new JPasswordField();
		passwordField.setBounds(119, 165, 114, 19);
		passwordField.setColumns(10);
		panel.add(passwordField);

		JLabel lblNewLabel_7_1 = new JLabel("Repeat Pass.: ");
		lblNewLabel_7_1.setBounds(34, 214, 84, 13);
		panel.add(lblNewLabel_7_1);

		rpasswordf = new JPasswordField();
		rpasswordf.setBounds(119, 211, 114, 19);
		rpasswordf.setColumns(10);
		panel.add(rpasswordf);

		JButton confirm = new JButton("Confirm");
		confirm.setBounds(150, 364, 85, 21);
		frmRegister.getContentPane().add(confirm);

		JButton cancel = new JButton("Cancel");
		cancel.setBounds(342, 364, 85, 21);
		frmRegister.getContentPane().add(cancel);
	}
}
