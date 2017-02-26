import javax.swing.*;
import javax.swing.event.EventListenerList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    //https://www.youtube.com/watch?v=YKaea4ezQQE

    private EventListenerList listeners = new EventListenerList();

    public MenuPanel(MenuOptions options) {
	setPreferredSize(new Dimension(options.getWidth(), options.getHeight()));
	setBorder(BorderFactory.createTitledBorder("Stock search"));

	JLabel stockNameLabel = new JLabel("Stock: ");
	JLabel fromYearLabel = new JLabel("Search from year: ");

	JTextField stockNameField = new JTextField(5);
	JTextField fromYearField = new JTextField(5);

	JButton searchButton = new JButton("Search");

	searchButton.addActionListener(new ActionListener() {
	    @Override public void actionPerformed(final ActionEvent event) {
		String stockName = stockNameField.getText();
		int fromYear = Integer.parseInt(fromYearField.getText());
		searchStocks(new SearchEvent(event, stockName, fromYear));
	    }
	});

	setLayout(new GridBagLayout());

	GridBagConstraints bagConstraints = new GridBagConstraints();
	bagConstraints.anchor = GridBagConstraints.LINE_START;

	//First column
	bagConstraints.weightx = 0.5;
	bagConstraints.weighty = 0.5;

	bagConstraints.gridx = 0;
	bagConstraints.gridy = 0;
	add(stockNameLabel, bagConstraints);

	bagConstraints.gridx = 0;
	bagConstraints.gridy = 1;
	add(fromYearLabel, bagConstraints);

	//Second column
	bagConstraints.gridx = 1;
	bagConstraints.gridy = 0;
	add(stockNameField, bagConstraints);

	bagConstraints.gridx = 1;
	bagConstraints.gridy = 1;
	add(fromYearField, bagConstraints);

	//Search button
	bagConstraints.weighty = 10;
	bagConstraints.gridx = 1;
	bagConstraints.gridy = 2;
	add(searchButton, bagConstraints);

    }

    private void searchStocks(SearchEvent event) {
	Object[] listenerList = listeners.getListenerList();
	for(int i = 0; i < listenerList.length; i += 2) {
	    if(listenerList[i] == SearchListener.class) {
		((SearchListener)listenerList[i + 1]).searchEventOccured(event);
	    }
	}
    }

    public void addSearchListener(SearchListener listener) {
	listeners.add(SearchListener.class, listener);
    }


    public void removeSearchListener(SearchListener listener) {
        listeners.remove(SearchListener.class, listener);
    }



}
