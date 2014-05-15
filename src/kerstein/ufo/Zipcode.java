package kerstein.ufo;

public class Zipcode {
	private String zipCode;
	private double lat;
	private double lon;
	private String city;
	private String state;
	private String county;
	private String category;

	public Zipcode(String zipCode, double lat, double lon, String city,
			String state, String county, String category) {
		this.zipCode = zipCode;
		this.lat = lat;
		this.lon = lon;
		this.city = city;
		this.state = state;
		this.county = county;
		this.category = category;
	}

	public String getZipCode() {
		return zipCode;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCounty() {
		return county;
	}

	public String getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "Zipcode [zipCode=" + zipCode + ", lat=" + lat + ", lon=" + lon
				+ ", city=" + city + ", state=" + state + "]";
	}

}
