package kerstein.mtamap;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class TripsTest {

	@Test
	public void testConstructor()throws IOException {
		new Trips();
	}
	@Test
	public void testGetTrip() throws IOException{
		Trips trips=new Trips();
		Assert.assertNotNull(trips.getTrip("1..N03R"));
	}

}
