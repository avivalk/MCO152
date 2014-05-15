package kerstein.mtamap;

import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Routes {
	private List<Route> routes;

	public Routes() throws IOException {// from file
		routes = new ArrayList<Route>();
		CSVReader reader = new CSVReader(new FileReader("routes.txt"), ',',
				'\"', 1);
		String[] nextLine;
		String routeId;
		Color color = null;
		while ((nextLine = reader.readNext()) != null) {
			routeId = nextLine[0];
			if ("".equals(nextLine[7])) {
				color = Color.GRAY;
			} else {
				Integer i = Integer.parseInt(nextLine[7].substring(0), 16);
				color = new Color(i);
			}
			Route route = new Route(routeId, color);
			routes.add(route);
		}
		reader.close();

	}

	public Color getColor(String routeId) {
		for (Route r : routes) {
			if (routeId.equals(r.getRouteId())) {
				return r.getColor();
			}
		}
		return null;

	}

	public List<Route> getRoutes() {
		return routes;
	}
}
