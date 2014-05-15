package kerstein.stocks;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

public class AmexData {
	private Map<String, List<DailyPrice>> stocks;

	public AmexData() throws IOException, ParseException {
		stocks = new HashMap<String, List<DailyPrice>>();
		String exchange;
		String symbol;
		Date date;
		double openPrice;
		double highPrice;
		double lowPrice;
		double closePrice;
		int volume;
		double adjustedClosePrice;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		CSVReader reader;
		String[] nextLine;
		char[] letters = new char[] { 'A', 'B', 'C', 'D' };
		for (int i = 0; i < letters.length; i++) {
			reader = new CSVReader(
					new FileReader("./resources/amex/AMEX_daily_prices_"
							+ letters[i] + ".csv"), ',', '\"', 1);

			while ((nextLine = reader.readNext()) != null) {
				exchange = nextLine[0];
				symbol = nextLine[1];
				date = format.parse(nextLine[2]);
				openPrice = Double.parseDouble(nextLine[3]);
				highPrice = Double.parseDouble(nextLine[4]);
				lowPrice = Double.parseDouble(nextLine[5]);
				closePrice = Double.parseDouble(nextLine[6]);
				volume = Integer.parseInt(nextLine[7]);
				adjustedClosePrice = Double.parseDouble(nextLine[8]);
				DailyPrice dailyPrice = new DailyPrice(exchange, symbol, date,
						openPrice, highPrice, lowPrice, closePrice, volume,
						adjustedClosePrice);
				if (!stocks.containsKey(symbol)) {
					List<DailyPrice> prices = new ArrayList<DailyPrice>();
					prices.add(dailyPrice);
					stocks.put(symbol, prices);
				} else {
					List<DailyPrice> prices = stocks.get(symbol);
					prices.add(dailyPrice);
				}

			}
			reader.close();
		}
	}

	public boolean contains(String symbol) {
		return stocks.containsKey(symbol);
	}

	public List<DailyPrice> getPrices(String symbol) {
		List<DailyPrice> prices;
		if (!stocks.containsKey(symbol)) {
			return new ArrayList<DailyPrice>();
		} else {
			prices = stocks.get(symbol);
		}
		Collections.sort(prices);
		return prices;
	}

	public List<DailyPrice> getPrices(String symbol, Date startDate,
			Date endDate) {
		List<DailyPrice> prices = new ArrayList<DailyPrice>();
		if (!stocks.containsKey(symbol)) {
			return prices;
		}
		for (DailyPrice dailyPrice : stocks.get(symbol)) {
			if (dailyPrice.getDate().compareTo(startDate) >= 0
					&& dailyPrice.getDate().compareTo(endDate) <= 0) {
				prices.add(dailyPrice);
			}
		}
		Collections.sort(prices);
		return prices;
	}
}
