package kerstein.forecast;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ForecastFrame extends JFrame {
	private Forecast forecast;
	private JTextField location;
	private Graph graph;
	private JButton submit;

	public ForecastFrame() {
		this.setTitle("7 Day Forecast");
		this.setSize(450, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		submit = new JButton("Go");
		location = new JTextField(
				"Enter a city to see the weather pattern of the temperatures every three hours");
		graph = new Graph();
		this.setLayout(new BorderLayout());
		this.add(submit, BorderLayout.SOUTH);
		this.add(graph, BorderLayout.CENTER);
		this.add(location, BorderLayout.NORTH);
		submit.addActionListener(new ButtonActionListener());

	}

	private class ButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Thread forecastData = null;
			try {
				forecastData = new ForecastData(forecast, location, graph);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			forecastData.start();
		}
	}

	public static void main(String[] args) {
		ForecastFrame frame = new ForecastFrame();
		frame.setVisible(true);
	}

}
