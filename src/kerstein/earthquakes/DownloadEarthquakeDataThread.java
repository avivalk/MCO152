package kerstein.earthquakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JList;

import com.google.gson.Gson;

public class DownloadEarthquakeDataThread extends Thread {

	private static String URL = "http://earthquake-report.com/feeds/recent-eq?json";
	private JList<Earthquake> equakes;
	private ShowEarthquakes frame;

	public DownloadEarthquakeDataThread(JList<Earthquake> equakes,
			ShowEarthquakes frame) {
		this.equakes = equakes;
		this.frame = frame;
	}

	@Override
	public void run() {
		URL url = null;
		Gson gson = new Gson();
		URLConnection connection = null;
		InputStream in = null;
		try {
			url = new URL(URL);
			connection = url.openConnection();
			in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			EarthquakeList list = gson.fromJson(reader, EarthquakeList.class);
			Earthquake[] quakes = new Earthquake[list.size()];
			quakes = list.toArray(quakes);
			equakes.setListData(quakes);

			frame.addJList(equakes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
