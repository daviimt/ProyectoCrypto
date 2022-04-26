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

	private JTable table;
	private JPanel panel;
	private JButton details, insert, update, close, statistics;
	private JLabel user, nombre;

	public MainWindow() {
		super("Menu");
		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		table = new JTable();
		table.setBounds(102, 65, 369, 175);
		getContentPane().add(table);

		user = new JLabel("User: ");
		user.setBounds(170, 30, 67, 13);
		getContentPane().add(user);

		nombre = new JLabel("nombre");
		nombre.setBounds(331, 30, 92, 13);
		getContentPane().add(nombre);

		panel = new JPanel();
		panel.setBounds(23, 262, 532, 38);
		getContentPane().add(panel);

		details = new JButton("Details");
		panel.add(details);

		insert = new JButton("Insert");
		insert.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				Insert statistics = new Insert();
				dispose();

			}
		});
		panel.add(insert);

		update = new JButton("Update");
		panel.add(update);
		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// configurar boton update

			}
		});

		close = new JButton("Close");
		panel.add(close);
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		statistics = new JButton("Statistics");
		statistics.setBounds(233, 310, 109, 21);
		getContentPane().add(statistics);

		setVisible(true);
	}

}
