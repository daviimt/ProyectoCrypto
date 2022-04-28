package Windows;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class Update extends JFrame {

	private JLabel jlname, jlquantity;
	private JTextField jtname, jtquantity;
	private JButton jbnext, jbcancel;
	private JRadioButton jrbuy,jrsell;

	public Update() {
		super("Update details");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setSize(250, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(4, 2));
		setLocationRelativeTo(null);
		setMinimumSize(getSize());
		
		jlname = new JLabel("Name to Update:");
		jlname.setFont(new Font("Noto Nastaliq Urdu", Font.PLAIN, 13));
		jlname.setHorizontalAlignment(SwingConstants.CENTER);
		jlname.setBounds(123, 53, 45, 13);
		getContentPane().add(jlname);

		jtname = new JTextField();
		jtname.setBounds(207, 50, 96, 19);
		jtname.setColumns(10);
		getContentPane().add(jtname);
		jtname.setToolTipText("Introduce a crypto name");

		jlquantity = new JLabel("Quantity:");
		jlquantity.setFont(new Font("Noto Nastaliq Urdu", Font.PLAIN, 13));
		jlquantity.setHorizontalAlignment(SwingConstants.CENTER);
		jlquantity.setBounds(123, 76, 45, 13);
		getContentPane().add(jlquantity);

		jtquantity = new JTextField();
		jtquantity.setBounds(207, 73, 96, 19);
		jtquantity.setColumns(10);
		getContentPane().add(jtquantity);
		jtquantity.setToolTipText("Introduce quantity");

		//JRadioButton
		ButtonGroup bgchange=new ButtonGroup(); 
		
		jrbuy = new JRadioButton("Buy");
		jrbuy.setFont(new Font("Noto Nastaliq Urdu", Font.PLAIN, 13));
		jrbuy.setHorizontalAlignment(SwingConstants.CENTER);
		
		jrsell = new JRadioButton("Sell");
		jrsell.setFont(new Font("Noto Nastaliq Urdu", Font.PLAIN, 13));
		jrsell.setHorizontalAlignment(SwingConstants.CENTER);
		
		bgchange.add(jrbuy);
		bgchange.add(jrsell);
		getContentPane().add(jrbuy);
		getContentPane().add(jrsell);
		
		// Buttons
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
