import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChartFactory {

    public static XYChart makeChart(String stockName, int fromYear) {
        XYChart chart = new XYChartBuilder().width(500).height(400).title(stockName).xAxisTitle("Year").yAxisTitle("Price").build();

	List<HistoricalStock> stocks = null;
	try {
	    stocks = StockDownloader.downloadStocks(stockName, fromYear);
	} catch (ParseException e) {
	    e.printStackTrace();
	}

	if(stocks.isEmpty()) {
	    System.out.println("No stocks found for the specified date bounds!");
	}


	// Customize Chart
	chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSE);
	chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

	List<Date> xData = new ArrayList<>();
	List<Double> yData = new ArrayList<>();

	for(HistoricalStock stock : stocks) {
	    xData.add(stock.getDate());
	    yData.add(stock.getAdjustedClose());
	}


	XYSeries chartSeries = chart.addSeries(stockName, xData, yData);
	chartSeries.setLineStyle(SeriesLines.SOLID);
	chartSeries.setMarker(SeriesMarkers.NONE);

	return chart;
    }

}
