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

	private JPanel panel;
	private JLabel jlusername, jlname, jlfirstsurname, jllastsurname, jldni, jlemail, jlphone, jlpassword, jlpassword2;
	private JTextField jtusername, jtname, jtfirstsurname, jtlastsurname, jtdni, jtemail, jtphone;
	private JPasswordField jppassword, jppassword2;

	public Register() {

		// Setting the window options.

		setTitle("Register User: ");
		setBounds(100, 100, 600, 505);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		// Instantiation and addition of every component .

		// JPanel
		panel = new JPanel();
		panel.setBounds(150, 61, 277, 283);
		getContentPane().add(panel);
		panel.setLayout(null);

		// JLabel
		jlusername = new JLabel("Username:");
		jlusername.setBounds(43, 30, 75, 13);
		panel.add(jlusername);

		jlname = new JLabel("Name: ");
		jlname.setBounds(43, 53, 75, 13);
		panel.add(jlname);

		jlfirstsurname = new JLabel("First Surname: ");
		jlfirstsurname.setBounds(43, 76, 75, 13);
		panel.add(jlfirstsurname);

		jllastsurname = new JLabel("Last Surname: ");
		jllastsurname.setBounds(43, 99, 75, 13);
		panel.add(jllastsurname);

		jldni = new JLabel("D.N.I. : ");
		jldni.setBounds(43, 122, 75, 13);
		panel.add(jldni);

		jlemail = new JLabel("Email: ");
		jlemail.setBounds(43, 145, 75, 13);
		panel.add(jlemail);

		jlphone = new JLabel("Phone: ");
		jlphone.setBounds(43, 168, 75, 13);
		panel.add(jlphone);

		jlpassword = new JLabel("Password: ");
		jlpassword.setBounds(43, 191, 75, 13);
		panel.add(jlpassword);

		jlpassword2 = new JLabel("Repeat Pass.: ");
		jlpassword2.setBounds(34, 214, 84, 13);
		panel.add(jlpassword2);

		// JTextField
		jtusername = new JTextField();
		jtusername.setBounds(119, 27, 114, 19);
		panel.add(jtusername);
		jtusername.setColumns(10);

		jtname = new JTextField();
		jtname.setBounds(119, 50, 114, 19);
		panel.add(jtname);
		jtname.setColumns(10);

		jtfirstsurname = new JTextField();
		jtfirstsurname.setBounds(119, 73, 114, 19);
		panel.add(jtfirstsurname);
		jtfirstsurname.setColumns(10);

		jtlastsurname = new JTextField();
		jtlastsurname.setBounds(119, 96, 114, 19);
		panel.add(jtlastsurname);
		jtlastsurname.setColumns(10);

		jtdni = new JTextField();
		jtdni.setBounds(119, 119, 114, 19);
		panel.add(jtdni);
		jtdni.setColumns(12);

		jtemail = new JTextField();
		jtemail.setBounds(119, 142, 114, 19);
		panel.add(jtemail);
		jtemail.setColumns(13);

		jtphone = new JTextField();
		jtphone.setBounds(119, 165, 114, 19);
		panel.add(jtphone);
		jtphone.setColumns(10);

		// JPasswordField
		jppassword = new JPasswordField();
		jppassword.setBounds(119, 188, 114, 19);
		jppassword.setColumns(10);
		panel.add(jppassword);

		jppassword2 = new JPasswordField();
		jppassword2.setBounds(119, 211, 114, 19);
		jppassword2.setColumns(10);
		panel.add(jppassword2);

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
				verification = isNotNull(jtusername.getText());
				verification = isNotNull(jtname.getText());
				verification = isNotNull(jtfirstsurname.getText());
				verification = isNotNull(jtlastsurname.getText());
				verification = isNotNull(jtdni.getText());
				verification = isNotNull(jtemail.getText());
				verification = isNotNull(jtphone.getText());
				verification = isNotNull(jppassword.getText());
				verification = isNotNull(jppassword2.getText());

				if (verification) {
					User user = new User(jtusername.getText(), jtdni.getText(), jtemail.getText(), jtname.getText(),
							jtfirstsurname.getText(), jtlastsurname.getText(), jppassword.getText(), jtphone.getText());
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
