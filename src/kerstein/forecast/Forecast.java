package kerstein.forecast;

import java.util.Arrays;

public class Forecast {

	private List[] list;

	public List[] getList() {
		return list;

	}

	@Override
	public String toString() {
		return "Forecast [list=" + Arrays.toString(list) + "]";
	}

}
