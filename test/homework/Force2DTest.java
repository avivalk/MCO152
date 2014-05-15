package kerstein.homework;

import org.junit.Assert;
import org.junit.Test;

public class Force2DTest {

	@Test
	public void testGetMagnitude() {
		Force2D force = new Force2D(2.0, 3.0);
		double magnitude = force.getMagnitude();
		double expected = 3.605551275463989;
		Assert.assertEquals(expected, magnitude, .01);
	}

	@Test
	public void testGetAngle() {
		Force2D force = new Force2D(2.0, 3.0);
		double angle = force.getAngle();
		double expected = 56.309932474020215;
		Assert.assertEquals(expected, angle, .01);
	}

	@Test
	public void testAdd() {
		Force2D force = new Force2D(2.0, 3.0);
		Force2D aForce = new Force2D(3.0, 4.0);
		Force2D force3 = force.add(aForce);
		double force3X = force3.getX();
		double force3Y = force3.getY();
		double expectedX = 5.0;
		double expectedY = 7.0;
		Assert.assertEquals(expectedX, force3X, .01);
		Assert.assertEquals(expectedY, force3Y, .01);
	}

}
