package kerstein.stocks;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AmexDataTest {

	@Test
	public void testConstructor() throws IOException, ParseException {
		new AmexData();
	}

	@Test
	public void tesbtContains() throws IOException, ParseException {
		AmexData data = new AmexData();
		Assert.assertTrue(data.contains("AIP"));
		Assert.assertFalse(data.contains("MNO"));
	}

	@Test
	public void testGetPrices() throws IOException, ParseException {
		AmexData data = new AmexData();
		List<DailyPrice> prices = data.getPrices("AIP");
		Assert.assertNotNull(prices);
		Assert.assertNotSame(0, prices.size());
		List<DailyPrice> noPrices = data.getPrices("MNO");
		Assert.assertEquals(0, noPrices.size());

	}

	@Test
	public void testPrices() throws IOException, ParseException {
		AmexData data = new AmexData();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = format.parse("2010-02-01");
		Date endDate = format.parse("2010-02-09");
		List<DailyPrice> prices = data.getPrices("AIP", startDate, endDate);
		Assert.assertNotNull(prices);
		Assert.assertNotSame(0, prices.size());
	}

}
