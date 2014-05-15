package kerstein.ufo;

import java.util.StringTokenizer;

import com.google.gson.annotations.SerializedName;

public class Sighting {
	private String description;

	@SerializedName("sighted_at")
	private String sightedAt;

	@SerializedName("reported_at")
	private String reportedAt;
	private String duration;
	private String shape;
	private String location;
	private Zipcode zip;

	public String getDescription() {
		return description;
	}

	public String getSightedAt() {
		return sightedAt;
	}

	public String getReportedAt() {
		return reportedAt;
	}

	public String getDuration() {
		return duration;
	}

	public String getShape() {
		return shape;
	}

	public String getLocation() {
		return location;
	}

	public void setZipCode(Zipcodes zipCodes) {
		StringTokenizer st = new StringTokenizer(location, ",");
		String city = st.nextToken().trim();
		String state = st.nextToken().trim();
		for (Zipcode z : zipCodes.getZipcodes()) {
			if (city.equalsIgnoreCase(z.getCity())
					&& state.equalsIgnoreCase(z.getState())) {
				this.zip = z;
				break;
			}
		}
	}

	public Zipcode getZip() {
		return zip;
	}

	@Override
	public String toString() {
		return "Sighting [sightedAt=" + sightedAt + ", shape=" + shape
				+ ", location=" + location + ", zipcode=" + zip.getZipCode()
				+ ", Latitude=" + zip.getLat() + ", Longitude=" + zip.getLon()
				+ "]";
	}

}
