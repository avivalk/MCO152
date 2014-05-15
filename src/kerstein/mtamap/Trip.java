package kerstein.mtamap;

public class Trip {
	public String tripId;
	public String routeId;
	public String shapeId;

	public Trip(String tripId, String routeId, String shapeId) {
		this.tripId = tripId;
		this.routeId = routeId;
		this.shapeId = shapeId;
	}

	public String getTripId() {
		return tripId;
	}

	public String getRouteId() {
		return routeId;
	}

	public String getShapeId() {
		return shapeId;
	}
}
