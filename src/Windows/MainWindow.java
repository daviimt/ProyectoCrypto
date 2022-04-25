package Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	JTable table;
	JPanel panel;
	JButton details, insert, update, close, statistics;

	public MainWindow() {
		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		table = new JTable();
		table.setBounds(102, 65, 369, 175);
		getContentPane().add(table);

		JLabel lblNewLabel = new JLabel("User: ");
		lblNewLabel.setBounds(170, 30, 67, 13);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("nombre");
		lblNewLabel_1.setBounds(331, 30, 92, 13);
		getContentPane().add(lblNewLabel_1);

		panel = new JPanel();
		panel.setBounds(23, 262, 532, 38);
		getContentPane().add(panel);

		details = new JButton("Details");
		panel.add(details);

		insert = new JButton("Insert");
		panel.add(insert);

		update = new JButton("Update");
		update.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				Statistics_Update statistics = new Statistics_Update();
				dispose();

			}
		});
		panel.add(update);

		close = new JButton("Close");
		panel.add(close);

		statistics = new JButton("Statistics");
		statistics.setBounds(233, 310, 109, 21);
		getContentPane().add(statistics);
		statistics.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				Statistics_Update statistics = new Statistics_Update();
				dispose();

			}
		});
		setVisible(true);
	}

}