import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

public class Item extends JFrame {

	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private JList itemlist;

	public Item(){prepareGUI();}

	private void prepareGUI(){
		mainFrame = new JFrame("Item catalogue");
		//name of window
		mainFrame.setSize(600, 600);
		//window size
		mainFrame.setLayout(new GridLayout(2, 1));
		headerLabel = new JLabel("This is an item!",JLabel.CENTER);
		statusLabel = new JLabel("Here are some stats!",JLabel.CENTER);
		statusLabel.setSize(400, 100);

		itemlist = new JList();
		itemlist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		itemlist.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		itemlist.setVisibleRowCount(-1);

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
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);

	}
	void showEvent() {
		headerLabel.setText("All the items we sell");
		//set header for top of window	
		JButton ordersButton = new
				JButton("ITEMS");
		ordersButton.setActionCommand("ITEMS");
		ordersButton.addActionListener(new BCL());
		controlPanel.add(ordersButton);
		mainFrame.setVisible(true);
	}

	private class BCL implements ActionListener {
		public void actionPerformed (ActionEvent ae) {

			//		int index = itemlist.getSelectedIndex();
			//		listModel.remov(index);

			String command = ae.getActionCommand();
			switch (command) {
	//				case "ITEMS" : statusLabel.setText(Arrays.toString(CustomerOrder.OrderID));
			case "ITEMS" : statusLabel.setText("Test");
			break;

			}	
		}
	}
}

