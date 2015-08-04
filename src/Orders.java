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

public class Orders extends JFrame {

	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

public String getname (String name){
	return name;
}
public String getProduct(String ID){
	return ID;
}	
public int getquantity(int Quant){
	return Quant;
}
public float getprice (float price){
	return price;
}
public String getlocation (String located) {
	return located;
}
public boolean getremoved (boolean removed){
	return removed;
}
public boolean getporous (boolean porous){
	return porous;
}

boolean CheckedOut = false;
boolean Picked = false;
boolean Delivered = false;
//check-boxes to show status

/*public String toString() {
	boolean CheckedOut;
	boolean Picked;
	boolean Delivered;
}

String[] orderArray = {name, ID, Quant, price, located, removed, porous, CheckedOut, Picked, Delivered};
*/


//instantiate GUI imports
	
public Orders(){prepareGUI();}
	
	private void prepareGUI(){
	mainFrame = new JFrame("Customer Orders");
	//name of window
	mainFrame.setSize(600, 600);
	//window size
	mainFrame.setLayout(new GridLayout(3, 1));
	headerLabel = new JLabel("",JLabel.CENTER);
	statusLabel = new JLabel("Click to view incoming customer orders",JLabel.CENTER);
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
private void showEvent() {
	headerLabel.setText("Incoming Order Forms");
//set header for top of window	
	JButton ordersButton = new
	JButton("Orders");
	ordersButton.setActionCommand("ORDERS");
	ordersButton.addActionListener(new BCL());
	controlPanel.add(ordersButton);
	mainFrame.setVisible(true);
}

private class BCL implements ActionListener {
	public void actionPerformed (ActionEvent ae) {
		String command = ae.getActionCommand();
		switch (command) {
		case "ORDERS" : Orders co = new Orders();
		break;

		}	
	}
	}

}
