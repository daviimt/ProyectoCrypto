package Windows;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

@SuppressWarnings("serial")
public class Stadistics extends JFrame {

	JLabel jlusername;
	JButton jbback;
	Map<Integer, Integer> mapa = new HashMap<>();

	public Stadistics(String name) {

		super("Stadistics");
		setBounds(100, 100, 600, 505);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(600, 400);
		setMinimumSize(getSize());
		getContentPane().setLayout(null);
		setBackground(Color.GRAY);
		Image icon1 = Toolkit.getDefaultToolkit().getImage("images/CoinMarket.png");
		setIconImage(icon1);

		jlusername = new JLabel("Username: " + name);
		jlusername.setBounds(0, 0, 586, 51);
		jlusername.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(jlusername);

		XYSeries series = new XYSeries("Crypto's Number");
		for (int i = 1; i <= 12; i++)
			mapa.put(i, 0);

		for (Crypto c : MainWindow.getListC())
			mapa.put(c.getMonth(), mapa.get(c.getMonth()) + 1);

		Iterator<Integer> it = mapa.keySet().iterator();
		while (it.hasNext()) {
			Integer key = (Integer) it.next();
			series.add(key, mapa.get(key));
			System.out.println(key);
		}
		System.out.println(mapa);

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);

		JFreeChart chart1 = ChartFactory.createXYBarChart("Cryptos", "Time (Month)", false, "Amount (Unit)", dataset,
				PlotOrientation.VERTICAL, false, false, false);

		@SuppressWarnings("unused")
		JFreeChart chart = ChartFactory.createXYLineChart("Cryptos", "Time (Month)", "Amount (Unit)", dataset,
				PlotOrientation.VERTICAL, false, false, false);
		chart1.setBorderVisible(false);
		chart1.setBackgroundPaint(Color.GRAY);
		chart1.setBorderPaint(Color.BLACK);
		chart1.setAntiAlias(false);

		ChartPanel panel1 = new ChartPanel(chart1);
		panel1.setBounds(0, 45, 586, 280);

		getContentPane().add(panel1);

		JPanel panel = new JPanel();
		panel.setBounds(0, 324, 586, 39);
		panel.setBackground(Color.GRAY);
		getContentPane().add(panel);

		jbback = new JButton("Back");
		jbback.setBackground(new Color(153, 0, 0));
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

}
