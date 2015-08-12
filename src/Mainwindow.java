import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
//imported in order to make GUI

public class Mainwindow extends JFrame {

	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	//instantiate GUI imports

	public void prepareGUI(){
		mainFrame = new JFrame("Warehouse Order Tracking");
		//name of window
		mainFrame.setSize(600, 600);
		//window size
		mainFrame.setLayout(new GridLayout(3, 1));
		headerLabel = new JLabel("",JLabel.CENTER);
		statusLabel = new JLabel("View incoming orders and items catalogue.",JLabel.CENTER);
		statusLabel.setSize(500, 100);

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
	public void showEvent(){
		headerLabel.setText("Incoming Order Forms");
		//set header for top of window	
		JButton ordersButton = new
				JButton("Orders");
		ordersButton.setActionCommand("ORDERS");
		ordersButton.addActionListener(new BCL());
		controlPanel.add(ordersButton);
		JButton itemsButton = new
				JButton("Items");
		itemsButton.setActionCommand("ITEMS");
		itemsButton.addActionListener(new BCL());
		controlPanel.add(itemsButton);
		mainFrame.setVisible(true);
	}

	private class BCL implements ActionListener {
		@Override
		public void actionPerformed (ActionEvent orderclicked) {
			String command = orderclicked.getActionCommand();
			switch (command) {
			//			case "ORDERS" : statusLabel.setText("Java sucks");
			case "ORDERS" : Orders ord = new Orders();
			ord.showEvent();;
			break;
			case "ITEMS" : Item itm = new Item();
			itm.showEvent();;
			break;
			}
		}
	}
}

