import java.time.LocalDate;
import java.util.Date;

public class HistoricalStock {

    private Date date = null;
    private double open;
    private double close;
    private double high;
    private double low;
    private double volume;
    private double adjustedClose;

    public Date getDate() {
	return date;
    }

    public void setDate(final Date date) {
	this.date = date;
    }

    public double getOpen() {
	return open;
    }

    public void setOpen(final double open) {
	this.open = open;
    }

    public double getClose() {
	return close;
    }

    public void setClose(final double close) {
	this.close = close;
    }

    public double getHigh() {
	return high;
    }

    public void setHigh(final double high) {
	this.high = high;
    }

    public double getLow() {
	return low;
    }

    public void setLow(final double low) {
	this.low = low;
    }

    public double getVolume() {
	return volume;
    }

    public void setVolume(final double volume) {
	this.volume = volume;
    }

    public double getAdjustedClose() {
	return adjustedClose;
    }

    public void setAdjustedClose(final double adjustedClose) {
	this.adjustedClose = adjustedClose;
    }

    @Override public String toString() {
	return date + ", " + open + ", " + close + ", " + high + ", " + low + ", " + volume + ", " + adjustedClose;
    }
}
