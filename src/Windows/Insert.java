package Windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Insert extends JFrame {

	JLabel jlname, jlvalue, jlmarketCap, jlsupply;
	JTextField jtname, jtvalue, jtmarketCap, jtsupply;
	JButton jbnext, jbcancel;

	public Insert() {

		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(3, 2));
		setLocationRelativeTo(null);

		// JPanel
		JPanel jpname = new JPanel();
		JPanel jpvalue = new JPanel();
		JPanel jpmarketCap = new JPanel();
		JPanel jpsupply = new JPanel();
		JPanel jpbutton = new JPanel();
		add(jpname);
		add(jpvalue);
		add(jpmarketCap);
		add(jpsupply);
		add(jpbutton);

		// JLabel
		jlname = new JLabel("Name:");
		jlname.setBounds(123, 53, 45, 13);
		jpname.add(jlname);

		jlvalue = new JLabel("Value:");
		jlvalue.setBounds(123, 76, 45, 13);
		jpvalue.add(jlvalue);

		jlmarketCap = new JLabel("Market Cap:");
		jlmarketCap.setBounds(93, 99, 75, 13);
		jpmarketCap.add(jlmarketCap);

		jlsupply = new JLabel("Supply:");
		jlsupply.setBounds(122, 122, 46, 13);
		jpsupply.add(jlsupply);

		// JTextField
		jtname = new JTextField();
		jtname.setBounds(207, 50, 96, 19);
		jtname.setColumns(10);
		jpname.add(jtname);
		jpname.add(jpvalue);

		jtvalue = new JTextField();
		jtvalue.setBounds(207, 73, 96, 19);
		jtvalue.setColumns(10);
		jpvalue.add(jtvalue);

		jtmarketCap = new JTextField();
		jpmarketCap.add(jtmarketCap);
		jtmarketCap.setBounds(207, 96, 96, 19);
		jtmarketCap.setColumns(10);
		jpmarketCap.add(jpsupply);

		jtsupply = new JTextField();
		jtsupply.setBounds(207, 119, 96, 19);
		jtsupply.setColumns(10);
		jpsupply.add(jtsupply);

		// Buttons
		jbnext = new JButton("Continue");
		jbnext.setBounds(101, 163, 85, 21);
		jpbutton.add(jbnext);
		jbnext.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow main = new MainWindow();
				dispose();
			}
		});

		jbcancel = new JButton("Cancel");
		jbcancel.setBounds(218, 163, 85, 21);
		jpbutton.add(jbcancel);
		jbcancel.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindow main = new MainWindow();
				dispose();
			}
		});

		setVisible(true);
	}

}
