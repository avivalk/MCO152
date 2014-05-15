package kerstein.weather;

public class Coordinates {
	private double lon;
	private double lat;

	public double getLon() {
		return lon;
	}

	public double getLat() {
		return lat;
	}

	@Override
	public String toString() {
		return "Coordinates [lon=" + lon + ", lat=" + lat + "]";
	}

}
