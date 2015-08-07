import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class JDBC {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/nb_gardens";
	//IP and name of mysql module/schema
	static final String USER = "root";
	static final String PASS = "netbuilder";
	//login details for mysql


	public ArrayList<ItemData> itemcatalogue() {
		ArrayList<ItemData> itemList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName( "com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating item catalogue...");
			stmt = conn.createStatement();
			String sql2 = "SELECT ProductID, ProductName, Stock, Price, Weight, Dimensions, Manufacturer, Location, Removal, PorousWare FROM items";
			ResultSet rs = stmt.executeQuery(sql2);
			while (rs.next()) {
				//while loop in place to retrieve from every field
				String id = rs.getString("ProductID");
				String name = rs.getString("ProductName");
				int stock = rs.getInt("Stock");
				float price = rs.getFloat("Price");
				int weight = rs.getInt("Weight");
				String size = rs.getString("Dimensions");
				String madeby = rs.getString("Manufacturer");
				String located = rs.getString("Location");
				boolean remove = rs.getBoolean("Removal");
				boolean porous = rs.getBoolean("PorousWare");
				ItemData result = new ItemData(id, name, stock, price, weight, size, madeby, located, remove, porous);
				itemList.add(result);
				//determines and subsequently displays all fields for table  
			}
			rs.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) { }
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
		return itemList;
	}


	public ArrayList<OrderData> ordercatalogue() {
		ArrayList<OrderData> orderList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName( "com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating order catalogue...");
			stmt = conn.createStatement();
			String sql3 = "SELECT OrderID, CustomerID, OrderPlaced, OrderItems, Quantity, CheckedOut, Picked, Delivered FROM orders";
			ResultSet res = stmt.executeQuery(sql3);
			while (res.next()) {
				int id = res.getInt("OrderID");
				String customer = res.getString("CustomerID");
				String date = res.getString("OrderPlaced");
				String items = res.getString("OrderItems");
				int quant = res.getInt("Quantity");
				boolean checked = res.getBoolean("CheckedOut");
				boolean picked = res.getBoolean("Picked");
				boolean deliver = res.getBoolean("Delivered");
				OrderData result = new OrderData(id, customer, date, items, quant, checked, picked, deliver);
				orderList.add(result);
				
			}
			res.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) { }
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
		return orderList;
	} 

	public void customerorders() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName( "com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating customer orders...");
			stmt = conn.createStatement();
			String sql4 = "SELECT OrderID, ProductID, ProductQuantity FROM customerOrder";
			ResultSet res = stmt.executeQuery(sql4);
			while (res.next()) {
				int id = res.getInt("OrderID");
				String productid = res.getString("ProductID");
				String quant = res.getString("ProductQuantity");
				System.out.println("OrderID: " + id + ", ProductID: " + productid + ", Quantity: " + quant);
						
			}
			res.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) { }
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	} 

	public void updateorderspicked() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName( "com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating customer orders...");
			stmt = conn.createStatement();
			System.out.println("Updating orders picked...");
			stmt = conn.createStatement();
			String sql5 = "UPDATE orders " + "SET Picked = 1 WHERE OrderID in (1,2)";
			stmt.executeUpdate(sql5);
			}
			res.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) { }
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Goodbye!");
	} 
	
}
