package Windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JLabel jlusername, jlpassword, jltitle;
	private JButton jbregister, jbaccess;
	private JTextField jtusername;
	private JPasswordField jppassword;
	private Icon icon;
	private JPanel jpanel1, jpanel2, jpanel3, jpanel4;

	private File fusers = new File("files/Users");

	public Login() {
		super("Login");
		getContentPane().setBackground(Color.GRAY);
		setResizable(false);
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(4, 1));
		setMinimumSize(getSize());
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/CoinMarket.png");
		setIconImage(icon1);

		Manejador handlerLogin = new Manejador();

		jpanel1 = new JPanel();
		jpanel1.setBackground(Color.LIGHT_GRAY);
		jpanel2 = new JPanel();
		jpanel2.setBackground(Color.LIGHT_GRAY);
		jpanel3 = new JPanel();
		jpanel3.setBackground(Color.LIGHT_GRAY);
		jpanel4 = new JPanel();
		jpanel4.setBackground(Color.LIGHT_GRAY);

		jltitle = new JLabel("CoinMarket");
		jltitle.setVerticalAlignment(SwingConstants.BOTTOM);
		jltitle.setIcon(new ImageIcon("images/CoinMarket.png"));
		jltitle.setForeground(new Color(138, 43, 226));
		jltitle.setHorizontalAlignment(SwingConstants.CENTER);
		jltitle.setFont(new Font("Microsoft Himalaya", Font.BOLD, 25));
		jltitle.setBounds(25, 32, 70, 21);
		jpanel1.add(jltitle);

		jlusername = new JLabel("Username:");
		jlusername.setHorizontalAlignment(SwingConstants.CENTER);
		jlusername.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		jlusername.setBounds(25, 32, 70, 21);
		jpanel2.add(jlusername);

		jtusername = new JTextField();
		jtusername.setBounds(118, 29, 96, 19);
		jtusername.setColumns(10);
		jtusername.setToolTipText("Introduce your user");
		jpanel2.add(jtusername);

		jlpassword = new JLabel("Password:");
		jlpassword.setHorizontalAlignment(SwingConstants.CENTER);
		jlpassword.setFont(new Font("Noto Serif Myanmar", Font.PLAIN, 13));
		jlpassword.setBounds(25, 58, 70, 21);
		jpanel3.add(jlpassword);

		jppassword = new JPasswordField();
		jppassword.setBounds(118, 52, 96, 21);
		jppassword.setColumns(10);
		jppassword.setToolTipText("Introduce your password");
		jppassword.addActionListener(handlerLogin);
		jpanel3.add(jppassword);

		jbregister = new JButton("Register");
		jbregister.setIcon(new ImageIcon("images/Register.png"));
		jbregister.setBounds(22, 93, 85, 21);
		jpanel4.add(jbregister);
		jbregister.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				Register reg = new Register();
				dispose();
			}
		});

		jbaccess = new JButton("Access");
		jbaccess.setIcon(new ImageIcon("images/Login.png"));
		jbaccess.setBounds(128, 93, 85, 21);
		jpanel4.add(jbaccess);
		jbaccess.addActionListener(handlerLogin);

		getContentPane().add(jpanel1);
		getContentPane().add(jpanel2);
		getContentPane().add(jpanel3);
		getContentPane().add(jpanel4);
		setVisible(true);
	}

	private class Manejador implements ActionListener {

		@SuppressWarnings({ "deprecation", "unused" })
		@Override
		public void actionPerformed(ActionEvent e) {
			boolean existUser = false;
			boolean passwordCorrect = false;

			if (jtusername.getText().isBlank() == false) {
				if (fusers.exists() == true) {
					try {
						BufferedReader br = new BufferedReader(new FileReader(fusers));
						String linea = br.readLine();
						while (linea != null) {

							String[] usuario = linea.split(";");
							if (usuario[0].equals(jtusername.getText())) {
								existUser = true;
								if (usuario[4].equals(jppassword.getText())) {
									passwordCorrect = true;
								}
							}

							linea = br.readLine();
						}
						br.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}

					if (existUser == true) {
						if (passwordCorrect == true) {
							MainWindow main = new MainWindow(jtusername.getText());
							dispose();
						} else {
							icon = new ImageIcon("images/warning.png");
							JOptionPane.showMessageDialog(null, "Incorrect password", "Error",
									JOptionPane.WARNING_MESSAGE, icon);
						}
					} else {
						icon = new ImageIcon("images/warning.png");
						JOptionPane.showMessageDialog(null, "User doesn't exist", "Error", JOptionPane.WARNING_MESSAGE,
								icon);
					}
				} else {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(null, "Don't exist any users", "Error", JOptionPane.WARNING_MESSAGE,
							icon);
				}
			} else {
				icon = new ImageIcon("images/warning.png");
				JOptionPane.showMessageDialog(null, "User name is empty", "Error", JOptionPane.WARNING_MESSAGE, icon);
			}
		}

	}
}
