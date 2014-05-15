package kerstein.mtamap;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.List;

import javax.swing.JComponent;

public class Map extends JComponent {
	private Shapes shapes;
	private Trips trips;
	private Routes routes;

	public Map(Shapes shapes, Trips trips, Routes routes) throws IOException {
		this.shapes = shapes;
		this.trips = trips;
		this.routes = routes;
	}

	@Override
	public void paintComponent(Graphics g) {
		double maxLat = shapes.getMaxLat();
		double maxLon = shapes.getMaxLon();
		double minLat = shapes.getMinLat();
		double minLon = shapes.getMinLon();
		for (String shapeId : shapes.getShapeIds()) {
			List<Shape> shapesList = shapes.getShapes(shapeId);
			Trip trip = trips.getTrip(shapeId);
			if (trip != null) {
				Color color = routes.getColor(trip.getRouteId());
				g.setColor(color);
				for (int j = 0; j < shapesList.size() - 1; j++) {
					int x1 = (int) (((shapesList.get(j).getLat() - minLat) / (maxLat - minLat)) * (getHeight() - 1));
					int y1 = (int) (((shapesList.get(j).getLon() - minLon) / (maxLon - minLon)) * (getWidth() - 1));
					int x2 = (int) (((shapesList.get(j + 1).getLat() - minLat) / (maxLat - minLat)) * (getHeight() - 1));
					int y2 = (int) (((shapesList.get(j + 1).getLon() - minLon) / (maxLon - minLon)) * (getWidth() - 1));
					g.drawLine(x1, y1, x2, y2);
				}
			}
		}
	}
}
