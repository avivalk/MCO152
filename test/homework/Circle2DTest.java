package kerstein.homework;

import org.junit.Assert;
import org.junit.Test;

//I used the sample data from the book
public class Circle2DTest {

	@Test
	public void testGetArea() {
		Circle2D c1 = new Circle2D(2, 2, 5.5);
		double area = c1.getArea();
		double expected = 95.03317777109125;
		Assert.assertEquals(expected, area, .01);
	}

	@Test
	public void testGetPerimeter() {
		Circle2D c1 = new Circle2D(2, 2, 5.5);
		double perimeter = c1.getPerimeter();
		double expected = 34.55751918948772;
		Assert.assertEquals(expected, perimeter, .01);
	}

	@Test
	public void testContainsXY() {
		Circle2D c1 = new Circle2D(2, 2, 5.5);
		boolean containsXY = c1.contains(3, 3);
		Assert.assertTrue(containsXY);
	}

	@Test
	public void testContainsCircle() {
		Circle2D c1 = new Circle2D();
		boolean containsCircle = c1.contains(new Circle2D(.1, .4, .2));
		Assert.assertTrue(containsCircle);
	}

	@Test
	public void testOverlap() {
		Circle2D c1 = new Circle2D(2, 2, 5.5);
		boolean overlaps = c1.overlaps(new Circle2D(3, 5, 2.3));
		Assert.assertTrue(overlaps);
	}
}
