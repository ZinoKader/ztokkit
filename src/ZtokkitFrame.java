import javax.swing.*;
import java.awt.*;

public class ZtokkitFrame extends JFrame {

    private static final int MENU_WIDTH = 500;
    private static final int MENU_HEIGHT = 300;
    private ChartComponent chartComponent;

    public ZtokkitFrame() {

	super("ZTOKKIT");
	this.setLayout(new BorderLayout());
	MenuPanel menuPanel = new MenuPanel(new MenuOptions(MENU_WIDTH, MENU_HEIGHT));
	chartComponent = new ChartComponent();
	JFrame thisFrame = this;
	menuPanel.addSearchListener(new SearchListener() {
	    public void searchEventOccured(SearchEvent event) {
		chartComponent.addChart(thisFrame, ChartFactory.makeChart(event.getStockName(), event.getFromYear()));
		thisFrame.pack();
		thisFrame.setVisible(true);
	    }
	});

	this.add(menuPanel, BorderLayout.CENTER);
	this.pack();
	this.setVisible(true);
    }


}
