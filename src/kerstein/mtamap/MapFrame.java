package kerstein.mtamap;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class MapFrame extends JFrame {

	public MapFrame() throws IOException {
		Trips trips = new Trips();
		Routes routes = new Routes();
		Shapes shapes = new Shapes();
		this.setTitle("MTA Map");
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		Map map = new Map(shapes, trips, routes);
		add(map, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		try {
			MapFrame map = new MapFrame();
			map.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
