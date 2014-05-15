package kerstein.forecast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.swing.JTextField;

import com.google.gson.Gson;

public class ForecastData extends Thread {
	private Forecast forecast;
	private URL url;
	private JTextField location;
	private Graph graph;

	public ForecastData(Forecast forecast, JTextField location, Graph graph)
			throws MalformedURLException {
		this.forecast = forecast;
		this.location = location;
		this.graph = graph;
		this.url = new URL("http://api.openweathermap.org/data/2.5/forecast?q="
				+ location.getText() + "&mode=json&units=imperial");
	}

	@Override
	public void run() {
		Gson gson = new Gson();
		URLConnection connection = null;
		InputStream in = null;
		try {
			connection = url.openConnection();
			in = connection.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		forecast = gson.fromJson(reader, Forecast.class);
		ArrayList<Double> temps = new ArrayList<Double>();
		List[] list = forecast.getList();
		for (int i = 0; i < list.length; i++) {
			temps.add(list[i].getMain().getTemp());
			System.out.println(list[i].getMain().getTemp());
		}
		graph.setTemps(temps);
		graph.repaint();
	}

}
