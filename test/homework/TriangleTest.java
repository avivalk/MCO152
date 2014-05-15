package kerstein.homework;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

	@Test
	public void testTriangle() {
		Triangle tri = new Triangle(3);
		String expected = "  *" + "\n * *" + "\n*****";
		Assert.assertEquals(expected, tri.toString());
	}

}
