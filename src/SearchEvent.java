import java.util.EventObject;

public class SearchEvent extends EventObject {

    private String stockName;
    private int fromYear;

    public SearchEvent(final Object source, String stockName, int fromYear) {
	super(source);
	this.stockName = stockName;
	this.fromYear = fromYear;
    }

    public String getStockName() {
	return stockName;
    }

    public int getFromYear() {
	return fromYear;
    }
}
