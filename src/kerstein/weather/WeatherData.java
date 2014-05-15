package kerstein.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.google.gson.Gson;

public class WeatherData extends Thread {
	private Conditions conditions;
	private URL url;
	private JTextField location;
	private JTextArea data;

	public WeatherData(Conditions conditions, JTextField location,
			JTextArea data) throws MalformedURLException {
		this.url = new URL("http://api.openweathermap.org/data/2.5/weather?q="
				+ location.getText());
		this.data = data;
		this.location = location;
	}

	@Override
	public void run() {
		Gson gson = new Gson();
		URLConnection connection = null;
		try {
			connection = url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		InputStream in = null;
		try {
			in = connection.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		conditions = gson.fromJson(reader, Conditions.class);
		data.setText(conditions.toString());

	}

}
