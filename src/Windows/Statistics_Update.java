package Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Statistics_Update extends JFrame {

	JTextField titlef, yearf, lblNewLabel_2f;
	JButton next, cancel;
	JLabel title, year, lblNewLabel_2;

	public Statistics_Update() {

		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		title = new JLabel("Title:");
		title.setBounds(123, 53, 45, 13);
		getContentPane().add(title);

		year = new JLabel("Year:");
		year.setBounds(123, 76, 45, 13);
		getContentPane().add(year);

		// No entiendo bien lo que pone en la foto de la pizarra
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(123, 99, 45, 13);
		getContentPane().add(lblNewLabel_2);

		next = new JButton("Continue");
		next.setBounds(101, 163, 85, 21);
		getContentPane().add(next);
		next.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow main = new MainWindow();
				dispose();
			}
		});

		cancel = new JButton("Cancel");
		cancel.setBounds(218, 163, 85, 21);
		getContentPane().add(cancel);
		cancel.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow main = new MainWindow();
				dispose();
			}
		});

		titlef = new JTextField();
		titlef.setBounds(207, 50, 96, 19);
		getContentPane().add(titlef);
		titlef.setColumns(10);

		yearf = new JTextField();
		yearf.setBounds(207, 73, 96, 19);
		getContentPane().add(yearf);
		yearf.setColumns(10);

		// No entiendo bien lo que pone en la foto de la pizarra
		lblNewLabel_2f = new JTextField();
		lblNewLabel_2f.setBounds(207, 96, 96, 19);
		getContentPane().add(lblNewLabel_2f);
		lblNewLabel_2f.setColumns(10);
		setVisible(true);
	}

}
