package Windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

@SuppressWarnings("serial")
public class Details extends JFrame {

	private JLabel jlname, jlvalue, jlmarketCap, jlsupply, jlquantity,jldetails;
	private JTextField jtname, jtvalue, jtmarketCap, jtsupply, jtquantity;
	private JButton jbnext, jbcancel,jbdetails;

	public Details(String name) {
		super("Details");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setSize(350, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(7, 2));
		setLocationRelativeTo(null);
		setMinimumSize(getSize());

		jlname = new JLabel("Name:");
		jlname.setHorizontalAlignment(SwingConstants.CENTER);
		jlname.setBounds(123, 53, 45, 13);
		getContentPane().add(jlname);

		jtname = new JTextField();
		jtname.setBounds(207, 50, 96, 19);
		jtname.setColumns(10);
		jtname.setEditable(false);
		getContentPane().add(jtname);

		jlvalue = new JLabel("Value:");
		jlvalue.setHorizontalAlignment(SwingConstants.CENTER);
		jlvalue.setBounds(123, 76, 45, 13);
		getContentPane().add(jlvalue);

		jtvalue = new JTextField();
		jtvalue.setBounds(207, 73, 96, 19);
		jtvalue.setColumns(10);
		jtvalue.setEditable(false);
		getContentPane().add(jtvalue);

		jlquantity = new JLabel("Quantity:");
		jlquantity.setHorizontalAlignment(SwingConstants.CENTER);
		jlquantity.setBounds(122, 122, 46, 13);
		getContentPane().add(jlquantity);

		jtquantity = new JTextField();
		jtquantity.setBounds(207, 119, 96, 19);
		jtquantity.setColumns(10);
		jtquantity.setEditable(false);
		getContentPane().add(jtquantity);

		jlmarketCap = new JLabel("Market Cap:");
		jlmarketCap.setHorizontalAlignment(SwingConstants.CENTER);
		jlmarketCap.setBounds(93, 99, 75, 13);
		getContentPane().add(jlmarketCap);

		jtmarketCap = new JTextField();
		getContentPane().add(jtmarketCap);
		jtmarketCap.setBounds(207, 96, 96, 19);
		jtmarketCap.setEditable(false);
		jtmarketCap.setColumns(10);

		jlsupply = new JLabel("Supply:");
		jlsupply.setHorizontalAlignment(SwingConstants.CENTER);
		jlsupply.setBounds(122, 122, 46, 13);
		getContentPane().add(jlsupply);

		jtsupply = new JTextField();
		jtsupply.setBounds(207, 119, 96, 19);
		jtsupply.setColumns(10);
		jtsupply.setEditable(false);
		getContentPane().add(jtsupply);
		
		jldetails = new JLabel("Description:");
		jldetails.setHorizontalAlignment(SwingConstants.CENTER);
		jldetails.setBounds(122, 122, 46, 13);
		getContentPane().add(jldetails);

		// Buttons
		jbdetails = new JButton("More Info");
		jbdetails.setBackground(Color.GRAY);
		jbdetails.setBounds(101, 163, 85, 21);
		getContentPane().add(jbdetails);
		jbdetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Details.this, "descripcion de la crypto");
			}
		});
		
		jbnext = new JButton("Continue");
		jbnext.setBackground(Color.GREEN);
		jbnext.setBounds(101, 163, 85, 21);
		getContentPane().add(jbnext);
		jbnext.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow main = new MainWindow(name);
				dispose();
			}
		});

		jbcancel = new JButton("Cancel");
		jbcancel.setBackground(Color.RED);
		jbcancel.setBounds(218, 163, 85, 21);
		getContentPane().add(jbcancel);
		jbcancel.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow main = new MainWindow(name);
				dispose();
			}
		});

		setVisible(true);
	}

}
