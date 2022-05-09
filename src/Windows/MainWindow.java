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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import Entities.Crypto;
import java.awt.Font;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JTable table;
	private JPanel panel, panel_1;
	private JButton jbdetails, jbinsert, jbupdate, jbclose, jbstatistics, jbdelete;
	private JLabel jluser;

	private ObjectInputStream is;
	private ObjectOutputStream os;
	private File f = new File("files/Cryptos");
	String[] nameColums = { "Name", "Value", "Market Cap", "Creator" };
	static List<Crypto> listC;

	private Icon icon;

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

		listC = new ArrayList<>();
		try {
			is = new ObjectInputStream(new FileInputStream(f));
			Crypto c = (Crypto) is.readObject();
			while (c != null) {
				listC.add(c);
				c = (Crypto) is.readObject();
			}
			is.close();
		} catch (Exception e) {
		}

		jluser = new JLabel("Username: " + name);
		jluser.setFont(new Font("Poor Richard", Font.BOLD, 18));
		jluser.setBackground(Color.GRAY);
		jluser.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(jluser, BorderLayout.NORTH);

		// JTable Prueba (con defaulttablemade)

		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		DefaultTableModel dtmCrypto = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtmCrypto.setColumnIdentifiers(nameColums);
		table.setModel(dtmCrypto);

		for (Crypto c : getListC()) {
			Object[] row = new Object[4];
			row[0] = c.getName();
			row[1] = c.getValue();
			row[2] = c.getMarketCap();
			row[3] = c.getCreator();
			dtmCrypto.addRow(row);
		}
		table.setModel(dtmCrypto);
		// Termina el JTable

		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		getContentPane().add(panel_1, BorderLayout.SOUTH);

		jbstatistics = new JButton("");
		jbstatistics.setIcon(new ImageIcon("images/statistics.png"));
		jbstatistics.setToolTipText("Statistics");
		jbstatistics.setBackground(Color.GRAY);
		jbstatistics.setBorderPainted(false);
		jbstatistics.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Stadistics statistics = new Stadistics(name);

			}
		});
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_1.add(jbstatistics);

		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel_1.add(panel);

		jbinsert = new JButton("");
		jbinsert.setIcon(new ImageIcon("images/Insert.png"));
		jbinsert.setToolTipText("Insert");
		jbinsert.setBackground(Color.GRAY);
		jbinsert.setBorderPainted(false);
		jbinsert.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				Insert statistics = new Insert(name);
				dispose();

			}
		});

		jbdetails = new JButton("");
		jbdetails.setIcon(new ImageIcon("images/details.png"));
		jbdetails.setToolTipText("Details");
		jbdetails.setBackground(Color.GRAY);
		jbdetails.setBorderPainted(false);
		panel.add(jbdetails);
		jbdetails.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() < 0) {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(null, "You have to select a crypto", "Error",
							JOptionPane.WARNING_MESSAGE, icon);
				} else {
					Crypto c = getListC().get(table.getSelectedRow());
					dispose();
					Details.cryp = c;
					Details details = new Details(name);
				}

			}
		});
		panel.add(jbinsert);

		jbupdate = new JButton("");
		jbupdate.setIcon(new ImageIcon("images/update.png"));
		jbupdate.setToolTipText("Update");
		jbupdate.setBackground(Color.GRAY);
		jbupdate.setBorderPainted(false);
		panel.add(jbupdate);
		jbupdate.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() >= 0) {
					Crypto c = getListC().get(table.getSelectedRow());
					if (c.getCreator().equals(name) || name.equals("admin")) {

						dispose();
						Update.cryp = c;
						Update update = new Update(name, table.getSelectedRow());
					} else {
						icon = new ImageIcon("images/warning.png");
						JOptionPane.showMessageDialog(MainWindow.this, "You aren't creator", "Error",
								JOptionPane.WARNING_MESSAGE, icon);
					}

				} else {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(null, "You have to select a crypto", "Error",
							JOptionPane.WARNING_MESSAGE, icon);
				}
			}
		});

		jbdelete = new JButton("");
		jbdelete.setIcon(new ImageIcon("images/delete.png"));
		jbdelete.setToolTipText("Delete");
		jbdelete.setBackground(Color.GRAY);
		jbdelete.setBorderPainted(false);
		panel.add(jbdelete);
		jbdelete.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(table.getSelectedRow());
				icon = new ImageIcon("images/warning.png");
				int contCrypto = (int) getListC().stream().count();

				if (table.getSelectedRow() >= 0) {
					Crypto cryp = getListC().get(table.getSelectedRow());
					if (cryp.getCreator().equals(name) || name.equals("admin")) {
						int option = JOptionPane.showOptionDialog(MainWindow.this, "Are you sure?", "Confirm",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, null, null);
						if (option == 0) {
							if (contCrypto != 1) {
								getListC().remove(table.getSelectedRow());
								int cont = 0;
								for (Crypto c : getListC()) {
									Crypto crypto = new Crypto(c.getName(), c.getValue(), c.getMarketCap(),
											c.getSupply(), c.getDescription(), c.getIcon(), c.getCreator(),
											c.getMonth());
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
					} else {
						icon = new ImageIcon("images/warning.png");
						JOptionPane.showMessageDialog(MainWindow.this, "You dont be creator", "Error",
								JOptionPane.WARNING_MESSAGE, icon);
					}
				} else {
					icon = new ImageIcon("images/warning.png");
					JOptionPane.showMessageDialog(MainWindow.this, "You haven't to select a crypto", "Error",
							JOptionPane.WARNING_MESSAGE, icon);
				}

			}
		});

		jbclose = new JButton("");
		jbclose.setIcon(new ImageIcon("images/logout.png"));
		jbclose.setBackground(Color.GRAY);
		jbclose.setBorderPainted(false);
		jbclose.setToolTipText("Log Out");
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

	public static List<Crypto> getListC() {
		return listC;
	}

	public static void setListC(List<Crypto> listC) {
		MainWindow.listC = listC;
	}

}
