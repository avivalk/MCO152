package kerstein.weather;

public class Syst {
	private double message;
	private String country;
	private long sunrise;
	private long sunset;

	public double getMessage() {
		return message;
	}

	public String getCountry() {
		return country;
	}

	public long getSunrise() {
		return sunrise;
	}

	public long getSunset() {
		return sunset;
	}

	@Override
	public String toString() {
		return "System [message=" + message + ", country=" + country
				+ ", sunrise=" + sunrise + ", sunset=" + sunset + "]";
	}

}
