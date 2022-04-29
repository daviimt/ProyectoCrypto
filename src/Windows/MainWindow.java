package Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JTable table;
	private JPanel panel, panel_1;
	private JButton jbdetails, jbinsert, jbupdate, jbclose, jbstatistics,jbdelete;
	private JLabel jluser;// nombre;

	public MainWindow() {
		super("Menu");
		setBackground(Color.GRAY);
		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setMinimumSize(getSize());

		jluser = new JLabel("User: ");
		jluser.setBackground(Color.GRAY);
		jluser.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(jluser, BorderLayout.NORTH);

		// Creo que es m�s sencillo a�adir el nombre de usuario al primer label que
		// tener dos --Juan.
		// nombre = new JLabel("nombre");
		// getContentPane().add(nombre);

		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(table, BorderLayout.CENTER);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		getContentPane().add(panel_1, BorderLayout.SOUTH);

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

		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel_1.add(panel);

		jbinsert = new JButton("Insert");
		jbinsert.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				Insert statistics = new Insert();
				dispose();

			}
		});

		jbdetails = new JButton("Details");
		panel.add(jbdetails);
		jbdetails.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Details details = new Details();

			}
		});
		panel.add(jbinsert);

		jbupdate = new JButton("Update");
		panel.add(jbupdate);
		jbupdate.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Update update = new Update();

			}
		});

		jbdelete = new JButton("Delete");
		panel.add(jbdelete);
		jbdelete.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				int option = JOptionPane.showOptionDialog(jbupdate, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE, null, null, null);
				if(option==1) {
					dispose();
					MainWindow main=new MainWindow();
					//hay que hacer que borre la crypto
				}else {
					dispose();
					MainWindow main=new MainWindow();
				}
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
		

		setVisible(true);
	}

}
