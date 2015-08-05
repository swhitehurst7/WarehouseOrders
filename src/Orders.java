import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Orders extends JFrame {

	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

//instantiate GUI imports
	
public Orders(){prepareGUI();}
	
	void prepareGUI(){
	mainFrame = new JFrame("Customer Orders");
	//name of window
	mainFrame.setSize(600, 600);
	//window size
	mainFrame.setLayout(new GridLayout(3, 1));
	headerLabel = new JLabel("",JLabel.CENTER);
	statusLabel = new JLabel("",JLabel.CENTER);
	statusLabel.setSize(400, 100);
	
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
//		case "ORDERS" : System.out.println(Arrays.toString(CustomerOrder.OrderID));
		case "ORDERS" : statusLabel.setText(Arrays.toString(CustomerOrder.OrderID));
		break;

		}	
	}
	}

}
