package kerstein.stocks;

import java.util.Date;

public class DailyPrice implements Comparable<DailyPrice> {
	private String exchange;
	private String symbol;
	private Date date;

	private double openPrice;
	private double highPrice;
	private double lowPrice;
	private double closePrice;
	private int volume;
	private double adjustedClosePrice;

	public DailyPrice(String exchange, String symbol, Date date,
			double openPrice, double highPrice, double lowPrice,
			double closePrice, int volume, double adjustedClosePrice) {
		this.exchange = exchange;
		this.symbol = symbol;
		this.date = date;
		this.openPrice = openPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.closePrice = closePrice;
		this.volume = volume;
		this.adjustedClosePrice = adjustedClosePrice;
	}

	public String getExchange() {
		return exchange;
	}

	public String getSymbol() {
		return symbol;
	}

	public Date getDate() {
		return date;
	}

	public double getOpenPrice() {
		return openPrice;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public double getClosePrice() {
		return closePrice;
	}

	public int getVolume() {
		return volume;
	}

	public double getAdjustedClosePrice() {
		return adjustedClosePrice;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}

	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}

	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}

	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public void setAdjustedClosePrice(double adjustedClosePrice) {
		this.adjustedClosePrice = adjustedClosePrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(adjustedClosePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(closePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((exchange == null) ? 0 : exchange.hashCode());
		temp = Double.doubleToLongBits(highPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lowPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(openPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + volume;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		DailyPrice other = (DailyPrice) obj;
		if (Double.doubleToLongBits(adjustedClosePrice) != Double
				.doubleToLongBits(other.adjustedClosePrice)) {
			return false;
		}
		if (Double.doubleToLongBits(closePrice) != Double
				.doubleToLongBits(other.closePrice)) {
			return false;
		}
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (!date.equals(other.date)) {
			return false;
		}
		if (exchange == null) {
			if (other.exchange != null) {
				return false;
			}
		} else if (!exchange.equals(other.exchange)) {
			return false;
		}
		if (Double.doubleToLongBits(highPrice) != Double
				.doubleToLongBits(other.highPrice)) {
			return false;
		}
		if (Double.doubleToLongBits(lowPrice) != Double
				.doubleToLongBits(other.lowPrice)) {
			return false;
		}
		if (Double.doubleToLongBits(openPrice) != Double
				.doubleToLongBits(other.openPrice)) {
			return false;
		}
		if (symbol == null) {
			if (other.symbol != null) {
				return false;
			}
		} else if (!symbol.equals(other.symbol)) {
			return false;
		}
		if (volume != other.volume) {
			return false;
		}
		return true;
	}

	public int compareTo(DailyPrice price) {
		if (this.date.compareTo(price.date) == 0) {
			return 0;
		} else if (this.date.compareTo(price.date) > 0) {
			return 1;
		} else {
			return -1;
		}
	}

}
