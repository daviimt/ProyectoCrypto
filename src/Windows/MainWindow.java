package Windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JTable table;
	private JPanel panel;
	private JButton details, insert, update, close, statistics;
	private JLabel user;// nombre;
	private JPanel panel_1;

	public MainWindow() {
		super("Menu");
		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		user = new JLabel("User: ");
		user.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(user);

		// Creo que es más sencillo añadir el nombre de usuario al primer label que
		// tener dos --Juan.
		// nombre = new JLabel("nombre");
		// getContentPane().add(nombre);

		table = new JTable();
		getContentPane().add(table);

		panel = new JPanel();
		getContentPane().add(panel);

		details = new JButton("Details");
		details.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Details details = new Details();

			}
		});
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

		close = new JButton("Log Out");
		panel.add(close);
		close.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login = new Login();

			}
		});

		panel_1 = new JPanel();
		getContentPane().add(panel_1);

		statistics = new JButton("Statistics");
		statistics.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Statistics statistics = new Statistics();

			}
		});
		panel_1.add(statistics);

		setVisible(true);
	}

}
