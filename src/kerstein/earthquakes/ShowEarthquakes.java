package kerstein.earthquakes;

import javax.swing.JFrame;
import javax.swing.JList;

public class ShowEarthquakes extends JFrame {

	private DownloadEarthquakeDataThread thread;
	private JList<Earthquake> list;

	public ShowEarthquakes() {
		this.setTitle("Earthquakes");
		this.setSize(400, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		list = new JList<Earthquake>();
		this.add(list);
		thread = new DownloadEarthquakeDataThread(list, this);
		thread.start();

	}

	public void addJList(JList<Earthquake> list) {
		this.list = list;
	}

	public static void main(String[] args) {
		ShowEarthquakes quakes = new ShowEarthquakes();
		quakes.setVisible(true);
	}

}
