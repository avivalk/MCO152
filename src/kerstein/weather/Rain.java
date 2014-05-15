package kerstein.weather;

import com.google.gson.annotations.SerializedName;

public class Rain {
	@SerializedName("3h")
	private int hours;

	@Override
	public String toString() {
		return "Rain [hours=" + hours + "]";
	}

}
