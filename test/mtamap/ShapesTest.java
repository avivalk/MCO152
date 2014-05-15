package kerstein.mtamap;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ShapesTest {

	@Test
	public void test() throws IOException {
		new Shapes();
	}

	@Test
	public void testGetShapes() throws IOException {
		Shapes shapes = new Shapes();
		List<Shape> shapesList = shapes.getShapes("1..S03R");
		Assert.assertNotNull(shapesList);
		Assert.assertNotSame(0, shapesList.size());
	}
}
