package kerstein.ufo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import au.com.bytecode.opencsv.CSVReader;

public class Zipcodes {
	private ArrayList<Zipcode> zipcodes;

	public Zipcodes() throws IOException {
		zipcodes = new ArrayList<Zipcode>();
		CSVReader reader = new CSVReader(new FileReader("ZIP_CODES.txt"));
		String[] nextLine;
		double lat;
		double lon;
		while ((nextLine = reader.readNext()) != null) {
			String zip = nextLine[0];
			if ("".equals(nextLine[1])) {
				lat = 0.0;
			} else {
				lat = Double.valueOf(nextLine[1]);
			}
			if ("".equals(nextLine[2])) {
				lon = 0.0;
			} else {
				lon = Double.valueOf(nextLine[2]);
			}
			String city = nextLine[3];
			String state = nextLine[4];
			String county = nextLine[5];
			String category = nextLine[6];
			Zipcode zipCode = new Zipcode(zip, lat, lon, city, state, county,
					category);
			zipcodes.add(zipCode);
		}
		reader.close();
	}

	public ArrayList<Zipcode> getZipcodes() {
		return zipcodes;
	}

}
