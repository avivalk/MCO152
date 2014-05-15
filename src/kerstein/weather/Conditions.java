package kerstein.weather;

import java.util.Arrays;

public class Conditions {
	private Coordinates coord;
	private Syst sys;
	private Weather[] weather;
	private String base;
	private Main main;
	private Wind wind;
	private Rain rain;
	private Clouds clouds;
	private Long dt;
	private Long id;
	private String name;
	private int cod;

	@Override
	public String toString() {
		return "Conditions [\ncoord=" + coord + ", \nsys=" + sys
				+ ", \nweather=" + Arrays.toString(weather) + ",\n base="
				+ base + ", \nmain=" + main + ", \nwind=" + wind + ", \nrain="
				+ rain + ", \nclouds=" + clouds + ", \ndt=" + dt + ", \nid="
				+ id + ",\n name=" + name + ", \ncod=" + cod + "]";
	}

}
