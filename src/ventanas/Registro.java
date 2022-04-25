package ventanas;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Registro {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro window = new Registro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 250, 181);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(25, 10, 70, 13);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(25, 33, 70, 13);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tlfno. :");
		lblNewLabel_2.setBounds(25, 56, 70, 13);
		frame.getContentPane().add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBounds(10, 93, 85, 21);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.setBounds(141, 93, 85, 21);
		frame.getContentPane().add(btnNewButton_1);

		textField = new JTextField();
		textField.setBounds(118, 7, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(118, 30, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(118, 53, 96, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
	}
}
