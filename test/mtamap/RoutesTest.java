package kerstein.mtamap;

import java.awt.Color;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

public class RoutesTest {

	@Test
	public void test() throws IOException {
		new Routes();
	}

	@Test
	public void testGetNullColor() throws IOException {
		Routes routes = new Routes();
		Assert.assertEquals(routes.getColor("H"), Color.GRAY);

	}

	@Test
	public void testGetColor() throws IOException {
		Routes routes = new Routes();
		Assert.assertNotNull(routes.getColor("Q"));

	}

}
