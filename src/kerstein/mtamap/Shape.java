package kerstein.mtamap;

public class Shape {
	private String shapeId;
	private double lat;
	private double lon;

	public Shape(String shapeId, double lat, double lon) {
		this.shapeId = shapeId;
		this.lat = lat;
		this.lon = lon;
	}

	public String getShapeId() {
		return shapeId;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}
	
	// single responsibility rule=each class has one responsibility ONLY!
	// so responsibility of shape class is to contain one shape from the list of
	// shapes in file=main doesnt do that!!
}
