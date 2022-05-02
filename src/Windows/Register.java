package Windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Entities.User;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class Register extends JFrame {

	private JLabel jlusername, jlname, jldni, jlemail, jlpassword, jlpassword2;
	private JTextField jtusername, jtname, jtdni, jtemail;
	private JPasswordField jppassword, jppassword2;
	private JButton jbconfirm, jbcancel;
	private Icon icon;

	public Register() {

		// Setting the window options.
		super("Register an user");
		getContentPane().setBackground(Color.GRAY);
		setSize(300, 285);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(7, 2));
		setMinimumSize(getSize());

		jlusername = new JLabel("Username:");
		jlusername.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		jlusername.setHorizontalAlignment(SwingConstants.CENTER);
		jlusername.setBounds(24, 30, 94, 13);
		getContentPane().add(jlusername);

		jtusername = new JTextField();
		jtusername.setBounds(119, 27, 114, 19);
		getContentPane().add(jtusername);
		jtusername.setColumns(10);
		jtusername.setToolTipText("Introduce your user");

		jlname = new JLabel("Name: ");
		jlname.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		jlname.setHorizontalAlignment(SwingConstants.CENTER);
		jlname.setBounds(24, 53, 94, 13);
		getContentPane().add(jlname);

		jtname = new JTextField();
		jtname.setBounds(119, 50, 114, 19);
		getContentPane().add(jtname);
		jtname.setColumns(10);
		jtname.setToolTipText("Introduce your name");

		jldni = new JLabel("D.N.I. : ");
		jldni.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		jldni.setHorizontalAlignment(SwingConstants.CENTER);
		jldni.setBounds(24, 122, 94, 13);
		getContentPane().add(jldni);

		jtdni = new JTextField();
		jtdni.setBounds(119, 119, 114, 19);
		getContentPane().add(jtdni);
		jtdni.setColumns(12);
		jtdni.setToolTipText("Introduce your DNI");

		jlemail = new JLabel("Email: ");
		jlemail.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		jlemail.setHorizontalAlignment(SwingConstants.CENTER);
		jlemail.setBounds(24, 145, 94, 13);
		getContentPane().add(jlemail);

		jtemail = new JTextField();
		jtemail.setBounds(119, 142, 114, 19);
		getContentPane().add(jtemail);
		jtemail.setColumns(13);
		jtemail.setToolTipText("Introduce your email");

		jlpassword = new JLabel("Password: ");
		jlpassword.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		jlpassword.setHorizontalAlignment(SwingConstants.CENTER);
		jlpassword.setBounds(24, 191, 94, 13);
		getContentPane().add(jlpassword);

		jppassword = new JPasswordField();
		jppassword.setBounds(119, 188, 114, 19);
		jppassword.setColumns(10);
		getContentPane().add(jppassword);
		jppassword.setToolTipText("Introduce your password");

		jlpassword2 = new JLabel("Repeat Pass.: ");
		jlpassword2.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		jlpassword2.setHorizontalAlignment(SwingConstants.CENTER);
		jlpassword2.setBounds(24, 214, 94, 13);
		getContentPane().add(jlpassword2);

		jppassword2 = new JPasswordField();
		jppassword2.setBounds(119, 211, 114, 19);
		jppassword2.setColumns(10);
		getContentPane().add(jppassword2);
		jppassword2.setToolTipText("Repeat your password");

		// This button tries to create the user that will be added to the binary file.

		jbconfirm = new JButton("Confirm");
		jbconfirm.setBounds(150, 364, 85, 21);
		getContentPane().add(jbconfirm);
		jbconfirm.addActionListener(new ActionListener() {

			@SuppressWarnings({ "unused", "deprecation" })
			@Override
			public void actionPerformed(ActionEvent e) {

				boolean verification = true;

				JTextField[] group = { jtusername, jtname, jtdni, jtemail, jppassword, jppassword2 };

				for (JTextField j : group) {
					if (j.getText().isBlank()) {
						verification = false;
						break;
					}

				}

				if (verification) {
					User user = new User(jtusername.getText(), jtdni.getText(), jtemail.getText(), jtname.getText(),
							jppassword.getText());
					
					AddObjectOutputStream aos;
					try {
						aos = new AddObjectOutputStream();
						aos.abrir("Users");
						aos.writeObject(user);
						aos.cerrar();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					icon = new ImageIcon("images/check.png");
					JOptionPane.showMessageDialog(null, "User creation complete.", "Complete",
							JOptionPane.INFORMATION_MESSAGE, icon);
					dispose();
					Login login = new Login();
				} else {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(null, "Fill every required field to create the user.", "Error",
							JOptionPane.WARNING_MESSAGE, icon);
				}

			}
		});

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

}