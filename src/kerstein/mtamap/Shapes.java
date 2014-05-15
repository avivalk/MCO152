package kerstein.mtamap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Shapes {// responsibility is to read in and hold a LIST of shapes
	private List<Shape> shapes;

	public Shapes() throws IOException {// from file
		shapes = new ArrayList<Shape>();
		CSVReader reader = new CSVReader(new FileReader("shapes.txt"), ',',
				'\"', 1);
		String[] nextLine;
		String shapeId;
		double lat;
		double lon;
		while ((nextLine = reader.readNext()) != null) {
			shapeId = nextLine[0];
			lat = Double.valueOf(nextLine[1]);
			lon = Double.valueOf(nextLine[2]);
			Shape shape = new Shape(shapeId, lat, lon);
			shapes.add(shape);
		}
		reader.close();
	}

	public List<Shape> getShapes(String shapeId) {
		List<Shape> shapes = new ArrayList<Shape>();
		for (int i = 0; i < this.shapes.size(); i++) {
			if (shapeId.equals(this.shapes.get(i).getShapeId())) {
				shapes.add(this.shapes.get(i));
			}
		}
		return shapes;
	}

	public List<String> getShapeIds() {
		List<String> shapeIds = new ArrayList<String>();
		for (Shape s : shapes) {
			if (!shapeIds.contains(s.getShapeId())) {
				shapeIds.add(s.getShapeId());
			}
		}

		return shapeIds;
	}

	public double getMaxLat() {
		double maxLat = shapes.get(0).getLat();
		for (Shape s : shapes) {
			if (s.getLat() > maxLat) {
				maxLat = s.getLat();
			}

		}
		return maxLat;
	}

	public double getMaxLon() {
		double maxLon = shapes.get(0).getLon();
		for (Shape s : shapes) {
			if (s.getLon() > maxLon) {
				maxLon = s.getLon();
			}
		}

		return maxLon;
	}

	public double getMinLat() {
		double minLat = shapes.get(0).getLat();
		for (Shape s : shapes) {
			if (s.getLat() < minLat) {
				minLat = s.getLat();
			}
		}
		return minLat;
	}

	public double getMinLon() {
		double minLon = shapes.get(0).getLon();
		for (Shape s : shapes) {
			if (s.getLon() < minLon) {
				minLon = s.getLon();
			}
		}
		return minLon;

	}
}
