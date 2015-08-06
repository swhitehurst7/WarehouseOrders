import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

public class Orders extends JFrame {

	private JFrame mainFrame;
	private JLabel headerLabel;
	private JList orderList;
	private JPanel controlPanel;

	//instantiate GUI imports

	public Orders(){prepareGUI();}

	void prepareGUI(){
		mainFrame = new JFrame("Orders");
		//name of window
		mainFrame.setSize(600, 600);
		//window size
		mainFrame.setLayout(new GridLayout(3, 1));
		headerLabel = new JLabel("",JLabel.CENTER);

		orderList = new JList();
		orderList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		orderList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		orderList.setVisibleRowCount(-1);
		orderList.setSize(300, 100);

		JScrollPane listScroller = new JScrollPane(orderList);
		listScroller.setPreferredSize(new Dimension(250, 80));

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
		mainFrame.add(orderList);
		mainFrame.setVisible(true);
	}

	void showEvent() {
		headerLabel.setText("Incoming Order Forms");
		//set header for top of window	
		//	JButton ordersButton = new
		//	JButton("Orders");
		//	ordersButton.setActionCommand("ORDERS");
		//	ordersButton.addActionListener(new BCL());
		//	controlPanel.add(ordersButton);

		mainFrame.setVisible(true);
	}
	/*
private class BCL implements ActionListener {
	public void actionPerformed (ActionEvent ae) {
		String command = ae.getActionCommand();
		switch (command) {
//		case "ORDERS" : statusLabel.setText(Arrays.toString(CustomerOrder.OrderID));
		case "ORDERS" : orderList.setText(Arrays.toString(CustomerOrder.OrderID));

		break;

		}	
	}
	}
	 */
}
