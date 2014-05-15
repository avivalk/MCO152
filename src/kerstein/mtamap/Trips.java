package kerstein.mtamap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Trips {
	private List<Trip> trips;

	public Trips() throws IOException {
		trips = new ArrayList<Trip>();
		CSVReader reader = new CSVReader(new FileReader("trips.txt"), ',',
				'\"', 1);
		String[] nextLine;
		String tripId;
		String routeId;
		String shapeId;
		while ((nextLine = reader.readNext()) != null) {
			tripId = nextLine[2];
			routeId = nextLine[0];
			shapeId = nextLine[6];
			Trip trip = new Trip(tripId, routeId, shapeId);
			trips.add(trip);
		}
		reader.close();
	}

	public Trip getTrip(String shapeId) {
		for (Trip t : trips) {
			if (shapeId.equals(t.getShapeId())) {
				return t;
			}
		}
		return null;
	}

	public List<Trip> getTrips() {
		return trips;
	}

}
