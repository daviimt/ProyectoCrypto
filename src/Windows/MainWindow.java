package Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import java.awt.Image;
import java.awt.Toolkit;

import Entities.Crypto;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JTable table;
	private JPanel panel, panel_1;
	private JButton jbdetails, jbinsert, jbupdate, jbclose, jbstatistics, jbdelete;
	private JLabel jluser;

	private ObjectInputStream is;
	private ObjectOutputStream os;
	private File f = new File("files/Cryptos");
	String[] nameColums = { "Name", "Value", "Market Cap", "Creator"};

	public MainWindow(String name) {
		super("Menu");
		setBackground(Color.GRAY);
		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setMinimumSize(getSize());
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/CoinMarket.png");
		setIconImage(icon1);


		jluser = new JLabel(name);
		jluser.setBackground(Color.GRAY);
		jluser.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(jluser, BorderLayout.NORTH);

		// JTable Prueba (con defaulttablemade)

		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(table, BorderLayout.CENTER);

		DefaultTableModel dtmCrypto = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtmCrypto.setColumnIdentifiers(nameColums);
		table.setModel(dtmCrypto);

		List<Object[]> listC = new ArrayList<Object[]>();
		try {
			is = new ObjectInputStream(new FileInputStream(f));
			Crypto c = (Crypto) is.readObject();
			while (c != null) {
				Object[] crypto = { c.getName(), c.getValue(), c.getMarketCap(), c.getSupply(), c.getDescription(),
						c.getIcon(), c.getCreator(), c.getMonth() };
				listC.add(crypto);
				c = (Crypto) is.readObject();
			}
			is.close();
		} catch (Exception e) {
		}

		for (Object[] c : listC) {
			Object[] tabledatos = { c[0], c[1], c[2], c[6] };
			dtmCrypto.addRow(tabledatos);
		}
		table.setModel(dtmCrypto);
		// Termina el JTable

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

				List<Object[]> listC = new ArrayList<Object[]>();
				try {
					is = new ObjectInputStream(new FileInputStream(f));
					Crypto c = (Crypto) is.readObject();
					while (c != null) {
						Object[] crypto = { c.getName(), c.getValue(), c.getMarketCap(), c.getSupply(),
								c.getDescription(), c.getIcon(), c.getCreator(), c.getMonth() };
						listC.add(crypto);
						c = (Crypto) is.readObject();
					}
					is.close();
				} catch (Exception ex2) {
				}
				int contCrypto = (int) listC.stream().count();
				if (option == 0) {
					if (contCrypto != 1) {
						listC.remove(table.getSelectedRow());
						int cont = 0;
						for (Object[] c : listC) {
							Crypto crypto = new Crypto((String) c[0], (float) c[1], (float) c[2], (float) c[3],
									(String) c[4], (Icon) c[5], (String) c[6], (int)c[7]);
							try {
								if (cont == 0) {
									os = new ObjectOutputStream(new FileOutputStream(f));
								} else {
									os = new AddObjectOutputStream(new FileOutputStream(f, true));
								}
								os.writeObject(crypto);
								os.close();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							cont++;
						}
						dispose();
						MainWindow main = new MainWindow(name);
					} else {
						f.delete();
						dispose();
						MainWindow main = new MainWindow(name);
					}
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
