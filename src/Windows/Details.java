package Windows;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Entities.Crypto;

// TODO: Auto-generated Javadoc
/**
 * The Class Details.
 */
@SuppressWarnings("serial")
public class Details extends JFrame {

	/** The jlmonth. */
	private JLabel jlname, jlvalue, jlmarketCap, jlsupply, jldetails, jlmonth;

	/** The jtmonth. */
	private JTextField jtname, jtvalue, jtmarketCap, jtsupply, jtmonth;

	/** The panel 1. */
	private JPanel panel1;

	/** The jbdetails. */
	private JButton jbcancel, jbdetails;

	/** The cryp. */
	static Crypto cryp;

	/**
	 * Instantiates a new details.
	 *
	 * @param name the name
	 */
	public Details(String name) {
		super("Details");
		inicializate(Details.this);

		panel1 = new JPanel();
		panel1.setBounds(0, 0, 336, 189);
		panel1.setBackground(new Color(252, 228, 163));
		panel1.setLayout(new GridLayout(6, 2));

		jlname = new JLabel("Name:");
		jlname.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(jlname);

		jtname = new JTextField();
		jtname.setText(cryp.getName());
		jtname.setColumns(10);
		jtname.setEditable(false);
		panel1.add(jtname);

		jlvalue = new JLabel("Value:");
		jlvalue.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(jlvalue);

		jtvalue = new JTextField();
		jtvalue.setText(String.valueOf(cryp.getValue()));
		jtvalue.setColumns(10);
		jtvalue.setEditable(false);
		panel1.add(jtvalue);

		jlmarketCap = new JLabel("Market Cap:");
		jlmarketCap.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(jlmarketCap);

		jtmarketCap = new JTextField();
		jtmarketCap.setText(String.valueOf(cryp.getMarketCap()));
		jtmarketCap.setColumns(10);
		jtmarketCap.setEditable(false);
		panel1.add(jtmarketCap);

		jlsupply = new JLabel("Supply:");
		jlsupply.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(jlsupply);

		jtsupply = new JTextField();
		jtsupply.setText(String.valueOf(cryp.getSupply()));
		jtsupply.setColumns(10);
		jtsupply.setEditable(false);
		panel1.add(jtsupply);

		jlmonth = new JLabel("Month:");
		jlmonth.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(jlmonth);

		jtmonth = new JTextField();
		jtmonth.setText(String.valueOf(cryp.getMonth()));
		jtmonth.setColumns(10);
		jtmonth.setEditable(false);
		panel1.add(jtmonth);

		jldetails = new JLabel("Description:");
		jldetails.setHorizontalAlignment(SwingConstants.CENTER);
		panel1.add(jldetails);

		jbdetails = new JButton("");
		jbdetails.setIcon(new ImageIcon("images/info.png"));
		jbdetails.setBackground(new Color(252, 228, 163));
		jbdetails.setBorderPainted(false);
		jbdetails.setToolTipText("More Info");
		jbdetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Icon icon = new ImageIcon("images/" + jtname.getText() + ".png");
				JOptionPane.showMessageDialog(Details.this, cryp.getDescription(), "Details",
						JOptionPane.WARNING_MESSAGE, icon);
			}
		});
		panel1.add(jbdetails);

		add(panel1);

		jbcancel = new JButton("");
		jbcancel.setBounds(0, 191, 336, 42);
		jbcancel.setIcon(new ImageIcon("images/Back.png"));
		jbcancel.setBackground(new Color(153, 0, 0));
		jbcancel.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow main = new MainWindow(name);
				dispose();
			}
		});
		add(jbcancel);

		setVisible(true);
	}

	/**
	 * Inicializate.
	 *
	 * @param jf the jf
	 */
	private void inicializate(JFrame jf) {

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBackground(new Color(252, 228, 163));
		jf.getContentPane().setBackground(new Color(252, 228, 163));
		jf.setSize(350, 280);
		jf.setMinimumSize(getSize());
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setLayout(null);
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/CoinMarket.png");
		jf.setIconImage(icon1);

	}

}
