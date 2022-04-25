package Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Statistics_Update extends JFrame {

	JLabel jlname, jlvalue, jlmarketCap,jlsupply;
	JTextField jtname, jtvalue, jtmarketCap,jtsupply;
	JButton jbnext, jbcancel;

	public Statistics_Update() {

		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		//JLabel
		jlname = new JLabel("Name:");
		jlname.setBounds(123, 53, 45, 13);
		getContentPane().add(jlname);

		jlvalue = new JLabel("Value:");
		jlvalue.setBounds(123, 76, 45, 13);
		getContentPane().add(jlvalue);

		jlmarketCap = new JLabel("Market Cap:");
		jlmarketCap.setBounds(123, 99, 45, 13);
		getContentPane().add(jlmarketCap);
		
		jlsupply = new JLabel("Supply:");
		jlsupply.setBounds(123, 99, 45, 13);
		getContentPane().add(jlsupply);

		//JTextField
		jtname = new JTextField();
		jtname.setBounds(207, 50, 96, 19);
		getContentPane().add(jtname);
		jtname.setColumns(10);

		jtvalue = new JTextField();
		jtvalue.setBounds(207, 73, 96, 19);
		getContentPane().add(jtvalue);
		jtvalue.setColumns(10);

		jtmarketCap = new JTextField();
		jtmarketCap.setBounds(207, 96, 96, 19);
		getContentPane().add(jtmarketCap);
		jtmarketCap.setColumns(10);
		
		jtsupply = new JTextField();
		jtsupply.setBounds(207, 96, 96, 19);
		getContentPane().add(jtsupply);
		jtsupply.setColumns(10);
		
		//Buttons
		jbnext = new JButton("Continue");
		jbnext.setBounds(101, 163, 85, 21);
		getContentPane().add(jbnext);
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
		getContentPane().add(jbcancel);
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
