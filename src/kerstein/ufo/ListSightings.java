package kerstein.ufo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class ListSightings {
	public static void main(String[] args) throws FileNotFoundException {
		Gson gson = new Gson();
		FileReader reader = new FileReader("ufo_awesome.json");
		Sightings list = gson.fromJson(reader, Sightings.class);
		Map<String, List<Sighting>> map = new HashMap<>();

		for (Sighting s : list) {
			String location = s.getLocation();
			if (!map.containsKey(location)) {
				List<Sighting> sightings = map.get(location);
				if (sightings == null) {
					sightings = new ArrayList<Sighting>();
				}
				sightings.add(s);
				map.put(location, sightings);

			}
		}

		System.out.println(list.size());

		Zipcodes zips = null;
		try {
			zips = new Zipcodes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Sighting s : list) {
			if (("19950115").equals(s.getSightedAt())) {
				s.setZipCode(zips);
				System.out.println(s.toString());
			}
		}

	}
}
