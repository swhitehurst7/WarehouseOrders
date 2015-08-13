import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Item extends JFrame {

	private JFrame mainFrame;
	private JLabel headerLabel;
	private JPanel controlPanel;
	private JList itemlist;
	
	DefaultListModel<String> listModel = new DefaultListModel();

	public Item(){prepareGUI();}

	void prepareGUI(){
		mainFrame = new JFrame("Item catalogue");
		//name of window
		mainFrame.setSize(1500, 600);
		//window size
		mainFrame.setLayout(new GridLayout(3, 1));
		headerLabel = new JLabel("This is an item!",JLabel.CENTER);

		itemlist = new JList<String>(listModel);
		itemlist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		itemlist.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		itemlist.setVisibleRowCount(-1);
		itemlist.setSize(500,100);
		//JList in which Item data from jdbc is displayed

		JScrollPane listScroller = new JScrollPane(itemlist);
		listScroller.setPreferredSize(new Dimension(250, 80));

		//	listModel = new DefaultListModel();
		//	itemlist = newJList(listModel);

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent)
			{
				System.exit(0);
				//window closes when 'x' is clicked
			}
		});
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(itemlist);
		mainFrame.setVisible(true);

	}
	void showEvent() {
		headerLabel.setText("All the items we sell");
		//set header for top of window	
		JButton itemButton = new JButton("Check item catalogue");
		//instantiating of each button
		itemButton.setActionCommand("ITEMS");
		//setting action commands
		itemButton.addActionListener(new BCL());
		//setting action commands
		//etc
		JButton stockButton = new JButton("Generate stock order");
		stockButton.setActionCommand("STOCK");
		stockButton.addActionListener(new BCL());
		JButton removalButton = new JButton("Designate item for removal");
		removalButton.setActionCommand("REMOVE");
		removalButton.addActionListener(new BCL());
		JButton porousButton = new JButton("Designate as Porous Ware");
		porousButton.setActionCommand("POROUS");
		porousButton.addActionListener(new BCL());
		
		controlPanel.add(itemButton);
		controlPanel.add(stockButton);
		controlPanel.add(removalButton);
		controlPanel.add(porousButton);
	//adds all buttons consecutively to the the JPanel
	}

	private class BCL implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			JDBC jdbc = new JDBC();
			//		int index = itemlist.getSelectedIndex();
			//		listModel.remov(index);

			String command = ae.getActionCommand();
			switch (command) {
			case "ITEMS" : displayitems();
			break;
			case "STOCK" : jdbc.createstockorder();
			jdbc.stockordercatalogue();
			//creates and adds the stock order fields to the database and accesses them via the jdbc to ensure they have placed
			break;
			case "REMOVE" :	jdbc.updateitemremoval();
			break;
			case "POROUS" : jdbc.updateitemporous();
			break;
			// Each case corresponds to a button being pressed - runs a function or functions from JDBC class
			}	
		}

		private void displayitems() {
			JDBC jdbc = new JDBC();
			jdbc.itemcatalogue();
			DefaultListModel<String> listModel = (DefaultListModel<String>) itemlist.getModel();
			listModel.clear();
// for the case "ITEMS" - accesses the jdbc, lists every element of the item list string (looping)
			for (String itemliststring: jdbc.itemcatalogue())
			{
				listModel.addElement(itemliststring);
			}
		}

	}
}