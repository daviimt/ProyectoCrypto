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
	private JPanel panel, panel_1;
	private JButton jbdetails, jbinsert, jbupdate, jbclose, jbstatistics;
	private JLabel jluser;// nombre;


	public MainWindow() {
		super("Menu");
		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		jluser = new JLabel("User: ");
		jluser.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(jluser);

		// Creo que es más sencillo añadir el nombre de usuario al primer label que
		// tener dos --Juan.
		// nombre = new JLabel("nombre");
		// getContentPane().add(nombre);

		table = new JTable();
		getContentPane().add(table);

		panel = new JPanel();
		getContentPane().add(panel);

		jbdetails = new JButton("Details");
		jbdetails.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Details details = new Details();

			}
		});
		panel.add(jbdetails);

		jbinsert = new JButton("Insert");
		jbinsert.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				Insert statistics = new Insert();
				dispose();

			}
		});
		panel.add(jbinsert);

		jbupdate = new JButton("Update");
		panel.add(jbupdate);
		jbupdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// configurar boton update

			}
		});

		jbclose = new JButton("Log Out");
		panel.add(jbclose);
		jbclose.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login = new Login();

			}
		});

		panel_1 = new JPanel();
		getContentPane().add(panel_1);

		jbstatistics = new JButton("Statistics");
		jbstatistics.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Statistics statistics = new Statistics();

			}
		});
		panel_1.add(jbstatistics);

		setVisible(true);
	}

}
