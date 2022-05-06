package Windows;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

@SuppressWarnings("serial")
public class Stadistics extends JFrame {

	JLabel jlusername;
	JButton jbback;

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

		jlusername = new JLabel("Username: ");
		jlusername.setBounds(0, 0, 586, 51);
		jlusername.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(jlusername);

		XYSeries series = new XYSeries("Crypto's Number");

		// Introduccion de datos
		series.add(1, 1);
		series.add(2, 6);
		series.add(3, 3);
		series.add(4, 6);
		series.add(5, 10);
		series.add(6, 8);
		series.add(7, 12);
		series.add(8, 14);
		series.add(9, 16);
		series.add(10, 10);
		series.add(11, 12);
		series.add(12, 10);

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);

		JFreeChart chart = ChartFactory.createXYLineChart("Cryptos", // T�tulo
				"Time (Month)", // Etiqueta Coordenada X
				"Amount (Unit)", // Etiqueta Coordenada Y
				dataset, // Datos
				PlotOrientation.VERTICAL, true, // Muestra la leyenda de los productos (Producto A)
				false, false);
		chart.setBorderVisible(false);
		chart.setBackgroundPaint(Color.GRAY);
		chart.setAntiAlias(false);

		ChartPanel panel1 = new ChartPanel(chart);
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
