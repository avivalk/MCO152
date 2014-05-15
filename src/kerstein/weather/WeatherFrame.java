package kerstein.weather;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WeatherFrame extends JFrame {
	private JTextArea data;
	private JButton button;
	private JTextField location;
	private Conditions conditions;

	public WeatherFrame() {
		this.setTitle("Weather");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("Submit");
		data = new JTextArea();
		location = new JTextField("Enter the name of a city");
		this.setLayout(new BorderLayout());
		this.add(button, BorderLayout.SOUTH);
		this.add(data, BorderLayout.CENTER);
		this.add(location, BorderLayout.NORTH);

		button.addActionListener(new ButtonActionListener());

	}

	private class ButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Thread weatherData = null;
			try {
				weatherData = new WeatherData(conditions, location, data);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			weatherData.start();

		}
	}

	public static void main(String[] args) {
		WeatherFrame frame = new WeatherFrame();
		frame.setVisible(true);
	}
}
