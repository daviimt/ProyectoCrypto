package Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;

import Entities.Crypto;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JTable table;
	private JPanel panel, panel_1;
	private JButton jbdetails, jbinsert, jbupdate, jbclose, jbstatistics, jbdelete;
	private JLabel jluser;// nombre;

	private ObjectInputStream is;
	private File f = new File("files/Cryptos");

	public MainWindow(String name) {
		super("Menu");
		setBackground(Color.GRAY);
		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setMinimumSize(getSize());

		jluser = new JLabel(name);
		jluser.setBackground(Color.GRAY);
		jluser.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(jluser, BorderLayout.NORTH);

		//JTable Prueba (con defaulttablemade)
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(table, BorderLayout.CENTER);
		// Creo que es m�s sencillo a�adir el nombre de usuario al primer label que
		// tener dos --Juan.
		// nombre = new JLabel("nombre");
		// getContentPane().add(nombre);
		String[] nameColums = { "Icon", "Name", "Value", "Creator" };
		
		DefaultTableModel dtmCrypto =new DefaultTableModel();
		dtmCrypto.setColumnIdentifiers(nameColums);
		table.setModel(dtmCrypto);

		List<Crypto> listCryptos = new ArrayList<>();
		try {
			is = new ObjectInputStream(new FileInputStream(f));
			Crypto c = (Crypto) is.readObject();
			while (c != null) {
				listCryptos.add(c);
				c = (Crypto) is.readObject();
			}
			is.close();
		} catch (Exception e) {}
		
		for(Crypto c:listCryptos){
			Object[]list=new Object[dtmCrypto.getColumnCount()];
		    list[0]=c.getIcon();
		    list[1]=c.getName();
		    list[2]=c.getValue();
		    list[3]=name;
		    dtmCrypto.addRow(list);
		}
		table.setModel(dtmCrypto);
		//Termina el JTable
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		getContentPane().add(panel_1, BorderLayout.SOUTH);

		jbstatistics = new JButton("Statistics");
		jbstatistics.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Stadistics statistics = new Stadistics(name);

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
				Insert statistics = new Insert(name);
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
				Details details = new Details(name);

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
				Update update = new Update(name);

			}
		});

		jbdelete = new JButton("Delete");
		panel.add(jbdelete);
		jbdelete.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Icon icon = new ImageIcon("images/warning.png");
				int option = JOptionPane.showOptionDialog(jbupdate, "Are you sure?", "Confirm",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, null, null);
				if (option == 1) {
					dispose();
					MainWindow main = new MainWindow(name);
					// hay que hacer que borre la crypto
				} else {
					dispose();
					MainWindow main = new MainWindow(name);
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
