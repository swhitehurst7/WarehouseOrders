import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JCheckBox;
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
	JCheckBox checkedButton;
	//instantiate GUI imports

	DefaultListModel<String> listModel = new DefaultListModel();
	//	m.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	//	m.setLeadAnchorNotificationEnabled(false);
	//	list.setSelectionModel(m);

	public Orders(){prepareGUI();}

	void prepareGUI(){
		mainFrame = new JFrame("Orders");
		//name of window
		mainFrame.setSize(1000, 600);
		//window size
		mainFrame.setLayout(new GridLayout(3, 1));
		headerLabel = new JLabel("",JLabel.CENTER);

		orderList = new JList<String>(listModel);
		orderList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		orderList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		orderList.setVisibleRowCount(-1);
		orderList.setSize(300, 100);
		
		orderList.addMouseListener(mouseListener);

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
		//	set header for top of window	
		JButton ordersButton = new JButton("Show unfulfilled orders");
		ordersButton.setActionCommand("ORDERS");
		ordersButton.addActionListener(new BCL());

		JButton checkedButton = new JButton("Check out order");
		checkedButton.setActionCommand("CHECK");
		checkedButton.addActionListener(new BCL());

		//		JCheckBox checkedButton = new JCheckBox("Checked Out");
		//		checkedButton.setMnemonic(KeyEvent.VK_C);
		//		checkedButton.setSelected(false);
		//		checkedButton.addItemListener((ItemListener) this);

		JButton pickedButton = new JButton("Begin picking order");
		pickedButton.setActionCommand("PICK");
		pickedButton.addActionListener(new BCL());

		JButton deliveredButton = new JButton("Order confirmation received");
		deliveredButton.setActionCommand("DELIVER");
		deliveredButton.addActionListener(new BCL());

		controlPanel.add(ordersButton);
		controlPanel.add(checkedButton);
		controlPanel.add(pickedButton);
		controlPanel.add(deliveredButton);
		mainFrame.setVisible(true);
	}

	private class BCL implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			JDBC jdbc = new JDBC();
			String command = ae.getActionCommand();
			switch (command) {
			case "ORDERS" : displayorders();
			break;
			case "CHECK" : jdbc.updateorderschecked();
			break;
			case "PICK" : //if (OrderData.CheckedOut != false) {
				jdbc.updateorderspicked();
//			}
			break;
			case "DELIVER" : //if (OrderData.Picked != false) {
				jdbc.updateordersdelivered();
//			}
			break;
			}	
		}
	}
	/*	
	public void itemStatChanged(ItemEvent e){
		Object source = e.getItemSelectable();
		JDBC jdbc = new JDBC();
		if (source == checkedButton){
			jdbc.updateorderschecked();
		}
	}
	 */
	MouseListener mouseListener = new MouseAdapter() {
		public void mouseClicked(MouseEvent mouseEvent) {
			JList theList = (JList) mouseEvent.getSource();
			if (mouseEvent.getClickCount() == 1) {
				int index = theList.locationToIndex(mouseEvent.getPoint());
				if (index >= 0) {
					Object o = theList.getModel().getElementAt(index);
					System.out.println("Clicked on: " + o.toString());
				}
			}
		}
	};
/*
ListSelectionListener listselectionlistener = new ListSelectionListener(){
	public void valueChanged(ListSelectionEvent listselectionevent){
		
	}
}
*/	
	public void displayorders()
	{JDBC jdbc = new JDBC();
	jdbc.ordercatalogue();
	DefaultListModel<String> listModel = (DefaultListModel<String>) orderList.getModel();
	listModel.clear();

	for (String orderliststring: jdbc.ordercatalogue())
	{
		listModel.addElement(orderliststring);
	}
	}	 
}
