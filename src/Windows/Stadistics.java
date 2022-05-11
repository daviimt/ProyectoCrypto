package Windows;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Entities.Crypto;
import java.awt.Font;

// TODO: Auto-generated Javadoc
/**
 * The Class Stadistics.
 */
@SuppressWarnings("serial")
public class Stadistics extends JFrame {

	/** The jlusername. */
	JLabel jlusername;
	
	/** The jbback. */
	JButton jbback;
	
	/** The mapa. */
	Map<Integer, Integer> mapa = new HashMap<>();

	/**
	 * Instantiates a new stadistics.
	 *
	 * @param name the name
	 */
	public Stadistics(String name) {

		super("Stadistics");
		inicializate(Stadistics.this);

		jlusername = new JLabel("Username: " + name);
		jlusername.setBounds(0, 0, 586, 51);
		jlusername.setHorizontalAlignment(SwingConstants.CENTER);
		jlusername.setFont(new Font("Dialog", Font.BOLD, 15));
		add(jlusername);

		XYSeries series = new XYSeries("Crypto's Number");
		for (int i = 1; i <= 12; i++)
			mapa.put(i, 0);

		for (Crypto c : MainWindow.getListC())
			mapa.put(c.getMonth(), mapa.get(c.getMonth()) + 1);

		Iterator<Integer> it = mapa.keySet().iterator();
		while (it.hasNext()) {
			Integer key = (Integer) it.next();
			series.add(key, mapa.get(key));
		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);

		JFreeChart chart1 = ChartFactory.createXYBarChart("Cryptos", "Time (Month)", false, "Amount (Unit)", dataset,
				PlotOrientation.VERTICAL, false, false, false);

		@SuppressWarnings("unused")
		JFreeChart chart = ChartFactory.createXYLineChart("Cryptos", "Time (Month)", "Amount (Unit)", dataset,
				PlotOrientation.VERTICAL, false, false, false);
		chart1.setBackgroundPaint(Color.GRAY);
		chart1.setBorderPaint(Color.BLACK);
		chart1.setBorderVisible(false);
		chart1.setAntiAlias(false);

		ChartPanel panel1 = new ChartPanel(chart1);
		panel1.setBounds(0, 45, 586, 280);
		add(panel1);

		JPanel panel = new JPanel();
		panel.setBounds(0, 324, 586, 39);
		panel.setBackground(Color.GRAY);
		add(panel);

		jbback = new JButton("");
		jbback.setIcon(new ImageIcon("images/Back.png"));
		jbback.setBackground(Color.GRAY);
		jbback.setBorderPainted(false);
		jbback.setToolTipText("Back");
		jbback.setHorizontalAlignment(SwingConstants.CENTER);
		jbback.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainWindow ventana = new MainWindow(name);

			}
		});
		panel.add(jbback);

		setVisible(true);
	}

	/**
	 * Inicializate.
	 *
	 * @param jf the jf
	 */
	private void inicializate(JFrame jf) {

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBackground(Color.GRAY);
		jf.setBounds(100, 100, 600, 400);
		jf.setMinimumSize(getSize());
		jf.setResizable(false);
		jf.setLocationRelativeTo(null);
		jf.setLayout(null);
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/CoinMarket.png");
		jf.setIconImage(icon1);
	}

}
