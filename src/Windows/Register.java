package Windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Entities.User;

@SuppressWarnings("serial")
public class Register extends JFrame {

	private JLabel jlusername, jlname, jlfirstsurname, jllastsurname, jldni, jlemail, jlphone, jlpassword, jlpassword2;
	private JTextField jtusername, jtname, jtfirstsurname, jtlastsurname, jtdni, jtemail, jtphone;
	private JPasswordField jppassword, jppassword2;
	private JButton jbconfirm, jbcancel;

	public Register() {

		// Setting the window options.
		super("Register an user");
		setSize(300, 285);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(10, 2));

		jlusername = new JLabel("Username:");
		jlusername.setHorizontalAlignment(SwingConstants.CENTER);
		jlusername.setBounds(24, 30, 94, 13);
		getContentPane().add(jlusername);

		jtusername = new JTextField();
		jtusername.setBounds(119, 27, 114, 19);
		getContentPane().add(jtusername);
		jtusername.setColumns(10);

		jlname = new JLabel("Name: ");
		jlname.setHorizontalAlignment(SwingConstants.CENTER);
		jlname.setBounds(24, 53, 94, 13);
		getContentPane().add(jlname);

		jtname = new JTextField();
		jtname.setBounds(119, 50, 114, 19);
		getContentPane().add(jtname);
		jtname.setColumns(10);

		jlfirstsurname = new JLabel("First Surname: ");
		jlfirstsurname.setHorizontalAlignment(SwingConstants.CENTER);
		jlfirstsurname.setBounds(24, 76, 94, 13);
		getContentPane().add(jlfirstsurname);

		jtfirstsurname = new JTextField();
		jtfirstsurname.setBounds(119, 73, 114, 19);
		getContentPane().add(jtfirstsurname);
		jtfirstsurname.setColumns(10);

		jllastsurname = new JLabel("Last Surname: ");
		jllastsurname.setHorizontalAlignment(SwingConstants.CENTER);
		jllastsurname.setBounds(24, 99, 94, 11);
		getContentPane().add(jllastsurname);

		jtlastsurname = new JTextField();
		jtlastsurname.setBounds(119, 96, 114, 19);
		getContentPane().add(jtlastsurname);
		jtlastsurname.setColumns(10);

		jldni = new JLabel("D.N.I. : ");
		jldni.setHorizontalAlignment(SwingConstants.CENTER);
		jldni.setBounds(24, 122, 94, 13);
		getContentPane().add(jldni);

		jtdni = new JTextField();
		jtdni.setBounds(119, 119, 114, 19);
		getContentPane().add(jtdni);
		jtdni.setColumns(12);

		jlemail = new JLabel("Email: ");
		jlemail.setHorizontalAlignment(SwingConstants.CENTER);
		jlemail.setBounds(24, 145, 94, 13);
		getContentPane().add(jlemail);

		jtemail = new JTextField();
		jtemail.setBounds(119, 142, 114, 19);
		getContentPane().add(jtemail);
		jtemail.setColumns(13);

		jlphone = new JLabel("Phone: ");
		jlphone.setHorizontalAlignment(SwingConstants.CENTER);
		jlphone.setBounds(24, 168, 94, 13);
		getContentPane().add(jlphone);

		jtphone = new JTextField();
		jtphone.setBounds(119, 165, 114, 19);
		getContentPane().add(jtphone);
		jtphone.setColumns(10);

		jlpassword = new JLabel("Password: ");
		jlpassword.setHorizontalAlignment(SwingConstants.CENTER);
		jlpassword.setBounds(24, 191, 94, 13);
		getContentPane().add(jlpassword);

		jppassword = new JPasswordField();
		jppassword.setBounds(119, 188, 114, 19);
		jppassword.setColumns(10);
		getContentPane().add(jppassword);

		jlpassword2 = new JLabel("Repeat Pass.: ");
		jlpassword2.setHorizontalAlignment(SwingConstants.CENTER);
		jlpassword2.setBounds(24, 214, 94, 13);
		getContentPane().add(jlpassword2);

		jppassword2 = new JPasswordField();
		jppassword2.setBounds(119, 211, 114, 19);
		jppassword2.setColumns(10);
		getContentPane().add(jppassword2);

		// This button tries to create the user that will be added to the binary file.

		jbconfirm = new JButton("Confirm");
		jbconfirm.setBounds(150, 364, 85, 21);
		getContentPane().add(jbconfirm);
		jbconfirm.addActionListener(new ActionListener() {

			@SuppressWarnings({ "unused", "deprecation" })
			@Override
			public void actionPerformed(ActionEvent e) {
				// Pendiente verificacion para usar los distintos constructores de User (campos
				// necesarios y no necesarios)
				// Pendiente verificacion filtros username, dni, email, phone, password y que
				// coincidan las contrase�as entre ellas.
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

		jbcancel = new JButton("Cancel");
		jbcancel.setBounds(342, 364, 85, 21);
		getContentPane().add(jbcancel);
		jbcancel.addActionListener(new ActionListener() {

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
