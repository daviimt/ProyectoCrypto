package WindowBuilderTest;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class Register_Test {

	private JFrame frmDetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_Test window = new Register_Test();
					window.frmDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register_Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDetails = new JFrame();
		frmDetails.setTitle("Details");
		frmDetails.setBounds(100, 100, 600, 505);
		frmDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDetails.getContentPane().setLayout(new GridLayout(3, 0, 0, 0));

		JLabel jlusername = new JLabel("Username: ");
		jlusername.setHorizontalAlignment(SwingConstants.CENTER);
		frmDetails.getContentPane().add(jlusername);

		JTextPane textPane = new JTextPane();
		frmDetails.getContentPane().add(textPane);

		JPanel panel = new JPanel();
		frmDetails.getContentPane().add(panel);

		JButton jbback = new JButton("Back");
		panel.add(jbback);
	}
}
