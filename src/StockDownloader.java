import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StockDownloader {

    public static List<HistoricalStock> downloadStocks(String companyTicker, int startFromYear) {

        List<HistoricalStock> historicalStocks = new ArrayList<>();
	String formattedUrl = String.format("http://ichart.finance.yahoo.com/table.csv?s=%s&g=d&a=0&b=01&c=%d", companyTicker, startFromYear);
	String pageContent = PageContentReader.urlToString(formattedUrl);

	String[] contentRows = pageContent.split("[\r\n]+"); //split by new line

	//First row is headers, we'll skip it
	for(int i = 1; i < contentRows.length; i++) {
	    String[] contentColumns = contentRows[i].split(",");
	    HistoricalStock hs = new HistoricalStock();
	    hs.setDate(LocalDate.parse(contentColumns[0]));
	    hs.setOpen(Double.parseDouble(contentColumns[1]));
	    hs.setHigh(Double.parseDouble(contentColumns[2]));
	    hs.setLow(Double.parseDouble(contentColumns[3]));
	    hs.setClose(Double.parseDouble(contentColumns[4]));
	    hs.setAdjustedClose(Double.parseDouble(contentColumns[5]));
	    historicalStocks.add(hs);
	}

        return historicalStocks;
    }

}
