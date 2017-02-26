import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockDownloader {

    public static List<HistoricalStock> downloadStocks(String companyTicker, int startFromYear) throws ParseException {

        List<HistoricalStock> historicalStocks = new ArrayList<>();
	String formattedUrl = String.format("http://ichart.finance.yahoo.com/table.csv?s=%s&g=d&a=0&b=01&c=%d", companyTicker, startFromYear);
	String pageContent = PageContentReader.urlToString(formattedUrl);

	String[] contentRows = pageContent.split("[\r\n]+"); //split by new line

	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	//First row is headers, we'll skip it
	for(int i = 1; i < contentRows.length; i++) {
	    String[] contentColumns = contentRows[i].split(",");
	    HistoricalStock hs = new HistoricalStock();
	    hs.setDate(dateFormat.parse(contentColumns[0]));
	    hs.setOpen(Double.parseDouble(contentColumns[1]));
	    hs.setHigh(Double.parseDouble(contentColumns[2]));
	    hs.setLow(Double.parseDouble(contentColumns[3]));
	    hs.setClose(Double.parseDouble(contentColumns[4]));
	    hs.setVolume(Double.parseDouble(contentColumns[5]));
	    hs.setAdjustedClose(Double.parseDouble(contentColumns[6]));
	    historicalStocks.add(hs);
	}

        return historicalStocks;
    }

}
