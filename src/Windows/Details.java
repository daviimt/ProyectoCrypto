package Windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Details extends JFrame {

	JLabel jlusername;
	JTextPane textPane;
	JButton jbback;

	public Details() {

		super("Details");
		setBounds(100, 100, 600, 505);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(600, 400);
		getContentPane().setLayout(new GridLayout(3, 0, 0, 0));

		jlusername = new JLabel("Username: ");
		jlusername.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(jlusername);

		textPane = new JTextPane();
		getContentPane().add(textPane);

		JPanel panel = new JPanel();
		getContentPane().add(panel);

		jbback = new JButton("Back");
		jbback.setHorizontalAlignment(SwingConstants.CENTER);
		jbback.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainWindow ventana = new MainWindow();

			}
		});
		panel.add(jbback);

		setVisible(true);
	}
}
