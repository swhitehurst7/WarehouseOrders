import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mainwindow wind = new Mainwindow();
		wind.prepareGUI();
		wind.showEvent();

		JDBC jdbc = new JDBC();
		jdbc.itemcatalogue();
		jdbc.ordercatalogue();
		jdbc.createcustomerorder();
		jdbc.refreshfields();

	}
}
