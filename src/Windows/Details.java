package Windows;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Entities.Crypto;

import java.awt.Color;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Details extends JFrame {

	private JLabel jlname, jlvalue, jlmarketCap, jlsupply, jldetails, jlmonth;
	private JTextField jtname, jtvalue, jtmarketCap, jtsupply, jtmonth;
	private JButton jbcancel, jbdetails;
	private JPanel jpanel1, jpanel2, jpanel3, jpanel4, jpanel5, jpanel6, jpanel7, jpanel8;
	static Crypto cryp;

	public Details(String name) {
		super("Details");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setSize(350, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(7, 1));
		setLocationRelativeTo(null);
		setMinimumSize(getSize());
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/CoinMarket.png");
		setIconImage(icon1);

		jpanel1 = new JPanel();
		jpanel1.setBackground(Color.LIGHT_GRAY);
		jpanel2 = new JPanel();
		jpanel2.setBackground(Color.LIGHT_GRAY);
		jpanel3 = new JPanel();
		jpanel3.setBackground(Color.LIGHT_GRAY);
		jpanel4 = new JPanel();
		jpanel4.setBackground(Color.LIGHT_GRAY);
		jpanel5 = new JPanel();
		jpanel5.setBackground(Color.LIGHT_GRAY);
		jpanel6 = new JPanel();
		jpanel6.setBackground(Color.LIGHT_GRAY);
		jpanel7 = new JPanel();
		jpanel7.setBackground(Color.LIGHT_GRAY);

		jlname = new JLabel("Name:");
		jlname.setHorizontalAlignment(SwingConstants.CENTER);
		jpanel1.add(jlname);

		jtname = new JTextField();
		jtname.setText(cryp.getName());
		jtname.setColumns(10);
		jtname.setEditable(false);
		jpanel1.add(jtname);

		jlvalue = new JLabel("Value:");
		jlvalue.setHorizontalAlignment(SwingConstants.CENTER);
		jpanel2.add(jlvalue);

		jtvalue = new JTextField();
		jtvalue.setText(String.valueOf(cryp.getValue()));
		jtvalue.setColumns(10);
		jtvalue.setEditable(false);
		jpanel2.add(jtvalue);

		jlmarketCap = new JLabel("Market Cap:");
		jlmarketCap.setHorizontalAlignment(SwingConstants.CENTER);
		jpanel3.add(jlmarketCap);

		jtmarketCap = new JTextField();
		jtmarketCap.setText(String.valueOf(cryp.getMarketCap()));
		jtmarketCap.setEditable(false);
		jtmarketCap.setColumns(10);
		jpanel3.add(jtmarketCap);

		jlsupply = new JLabel("Supply:");
		jlsupply.setHorizontalAlignment(SwingConstants.CENTER);
		jpanel4.add(jlsupply);

		jtsupply = new JTextField();
		jtsupply.setText(String.valueOf(cryp.getSupply()));
		jtsupply.setColumns(10);
		jtsupply.setEditable(false);
		jpanel4.add(jtsupply);

		jlmonth = new JLabel("Month:");
		jlmonth.setHorizontalAlignment(SwingConstants.CENTER);
		jpanel5.add(jlmonth);

		jtmonth = new JTextField();
		jtmonth.setText(String.valueOf(cryp.getMonth()));
		jtmonth.setColumns(10);
		jtmonth.setEditable(false);
		jpanel5.add(jtmonth);

		jldetails = new JLabel("Description:");
		jldetails.setHorizontalAlignment(SwingConstants.CENTER);
		jpanel6.add(jldetails);

		// Buttons
		jbdetails = new JButton("More Info");
		jbdetails.setBackground(Color.GRAY);
		jpanel6.add(jbdetails);
		jbdetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Details.this, cryp.getDescription(), "Details",
						JOptionPane.WARNING_MESSAGE, cryp.getIcon());
			}
		});

		jbcancel = new JButton("Back");
		jbcancel.setIcon(new ImageIcon("images/Back.png"));
		jbcancel.setBackground(new Color(153, 0, 0));
		jpanel7.add(jbcancel);
		jbcancel.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow main = new MainWindow(name);
				dispose();
			}
		});
		getContentPane().add(jpanel1);
		getContentPane().add(jpanel2);
		getContentPane().add(jpanel3);
		getContentPane().add(jpanel4);
		getContentPane().add(jpanel5);
		getContentPane().add(jpanel6);
		getContentPane().add(jpanel7);
		setVisible(true);
	}

}
