import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZtokkitApp {

    //https://github.com/timmolter/XChart

    public static void main(String[] args) {

	JFrame mainFrame = new ZtokkitFrame();


	/*
	List<HistoricalStock> stocks = null;
	try {
	    stocks = StockDownloader.downloadStocks("INTC", 2000);
	} catch (ParseException e) {
	    e.printStackTrace();
	}

	if(stocks.isEmpty()) {
	    System.out.println("No stocks found for the specified date bounds!");
	}


	// Create Chart
	final XYChart chart = new XYChartBuilder().width(1100).height(800).title("Intel Stocks").xAxisTitle("Year").yAxisTitle("Price").build();

	// Customize Chart
	chart.getStyler().setLegendPosition(LegendPosition.InsideSE);
	chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Line);

	List<Date> xData = new ArrayList<>();
	List<Double> yData = new ArrayList<>();

	for(HistoricalStock stock : stocks) {
	    xData.add(stock.getDate());
	    yData.add(stock.getAdjustedClose());
	}


	XYSeries chartSeries = chart.addSeries("INTC", xData, yData);
	chartSeries.setLineStyle(SeriesLines.SOLID);
	chartSeries.setMarker(SeriesMarkers.NONE);


	SwingUtilities.invokeLater(new Runnable() {

	    @Override
	    public void run() {

		// Create and set up the window.
		JFrame frame = new JFrame("ztokkit");
		frame.setPreferredSize(new Dimension(1300, 900));
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// charts
		JPanel chartPanel = new XChartPanel<>(chart);
		frame.add(chartPanel, BorderLayout.CENTER);


		// Display the window.
		frame.pack();
		frame.setVisible(true);
	    }
	});

	*/
    }

}
