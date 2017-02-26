import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;

import javax.swing.*;
import java.awt.*;

public class ChartComponent extends JComponent {

    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 400;
    private JPanel chartPanel = null;

    public ChartComponent() {
    }

    @Override public Dimension getPreferredSize() {
 	return new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT);
     }


    public void addChart(JFrame frame, XYChart chart) {
	chartPanel = new XChartPanel<>(chart);
	frame.add(chartPanel, BorderLayout.PAGE_END);
	chartPanel.repaint();
    }
}
