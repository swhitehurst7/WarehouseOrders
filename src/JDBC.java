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


	public ArrayList<String> itemcatalogue() {
		ArrayList<ItemData> itemList = new ArrayList<>();
		ArrayList<String> itemliststring = new ArrayList<String>(0);
		//makes an array list of strings from the fields shown below
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName( "com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//access the database -  url, login, etc
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
				//gets data from every field in database table, looped to completion
				ItemData result = new ItemData(id, name, stock, price, weight, size, madeby, located, remove, porous);
				itemList.add(result);
				String itemstring = "Product ID: " + id + " Product Name: " + name + " Stock: " + Integer.toString(stock) + " Price: " + Float.toString(price) + " Weight: " + Integer.toString(weight) + " Dimensions: " + size + " Manufacturer: " + madeby + " Location in Warehouse: " + located + " For removal? " + Boolean.toString(remove) + " Porous Ware? " + Boolean.toString(porous);
				itemliststring.add(itemstring);
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
			//here attempts to catch any exceptions, same for all below
		}
		System.out.println("Goodbye!");
		return itemliststring;
	}

	public ArrayList<String> ordercatalogue() {
		ArrayList<OrderData> orderList = new ArrayList<>();
		ArrayList<String> orderliststring = new ArrayList<String>(0);
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
				String orderstring = "OrderID: " + Integer.toString(id) + " CustomerID: " + customer + " Date placed: " + date + " Items: " + items + " Quantities: " + Integer.toString(quant) + " Checked Out? " + Boolean.toString(checked) + " Picked? " + Boolean.toString(picked) + " Delivered? " + Boolean.toString(deliver);
				orderliststring.add(orderstring);

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
		return orderliststring;
	} 

	public void createcustomerorder(){
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName( "com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//connects to database
			System.out.println("Formulating customer orders...");
			stmt = conn.createStatement();
			stmt.executeUpdate ("INSERT INTO customerorder " + "VALUES (1, 'GNO1', 2)");
			stmt.executeUpdate ("INSERT INTO customerorder " + "VALUES (1, 'PON2', 1)");
			stmt.executeUpdate ("INSERT INTO customerorder " + "VALUES (2, 'HAM1', 3)");
			stmt.executeUpdate ("INSERT INTO customerorder " + "VALUES (2, 'GNO1', 1)");
			//inputs all above information into customer table (this is called in the Main class when the application is first started)
			System.out.println("Created customer orders...");
		}
		catch (SQLException sqle) {
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
	}
	
	public void createstockorder(){
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName( "com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Formulating stock order...");
			int i = 1;
			stmt = conn.createStatement();
			stmt.executeUpdate ("INSERT INTO stockorder " + "VALUES (1, 'GNO1', 'Gnome Inc.', 20)");
			stmt.executeUpdate ("INSERT INTO stockorder " + "VALUES (2, 'HAM1', 'Hammock Hut', 30)");
			stmt.executeUpdate ("INSERT INTO stockorder " + "VALUES (3, 'PON2', 'Pond Factory', 10)");
			System.out.println("Created stock orders...");
			//inputs all above information into stock order table (this is called in the items class when the 'Generate Stock Order' button is selected)
		}
		catch (SQLException sqle) {
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
	}
	
	public ArrayList<String> stockordercatalogue() {
		ArrayList<StockOrderData> stockorderList = new ArrayList<>();
		ArrayList<String> stockorderliststring = new ArrayList<String>(0);
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName( "com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Retrieving stock levels...");
			stmt = conn.createStatement();
			String sqlrs = "SELECT StockOrderID, ProductID, Manufacturer, Quantity FROM stockorder";
			ResultSet res = stmt.executeQuery(sqlrs);
			while (res.next()) {
				String id = res.getString("StockOrderID");
				String product = res.getString("ProductID");
				String made = res.getString("Manufacturer");
				int quant = res.getInt("Quantity");
				StockOrderData result = new StockOrderData(id, product, made, quant);
				stockorderList.add(result);
				String stockorderstring = "Stock Order ID: " + id + " ProductID: " + product + " Manufacturer: " + made + " Quantity: " + Integer.toString(quant);
				stockorderliststring.add(stockorderstring);
				//data pulled from stock order table a a result of button press - checks proper insertion
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
		return stockorderliststring;
	} 
	
	public void refreshfields() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName( "com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			System.out.println("Updating orders checked out...");
			stmt = conn.createStatement();
			String sql4 = "UPDATE orders " + "SET CheckedOut = 0 WHERE OrderID in (1,2)";
			stmt.executeUpdate(sql4);
			String sql5 = "UPDATE orders " + "SET Picked = 0 WHERE OrderID in (1,2)";
			stmt.executeUpdate(sql5);
			String sql6 = "UPDATE orders " + "SET Delivered = 0 WHERE OrderID in (1,2)";
			stmt.executeUpdate(sql6);
			String sql7 = "UPDATE items " + "SET Removal = 0 WHERE ProductID = 'GNO1,HAM1,PON2'";
			stmt.executeUpdate(sql7);
			String sql8 = "UPDATE items " + "SET PorousWare = 0 WHERE ProductID = 'GNO1,HAM1,PON2'";
			stmt.executeUpdate(sql8);
			//sets all booleans to false when app is first started, mostly for testing purposes to show fields can be altered to true and info updated in item/order GUI

		}
		catch (SQLException sqle) {
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
		System.out.println("Checked out!");
	} 
	//each of these 'updates' access a boolean for the orders/items specified (setting it to '1' for 'true')
	public void updateorderschecked() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName( "com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			System.out.println("System refreshed...");
			stmt = conn.createStatement();
			String sql4 = "UPDATE orders " + "SET CheckedOut = 1 WHERE OrderID in (1,2)";
			stmt.executeUpdate(sql4);
//sets orders with ID of 1 and to 'CheckedOut' i.e. order fulfilment is currently in process
		}
		catch (SQLException sqle) {
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
		System.out.println("Checked out!");
	} 

	public void updateorderspicked() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName( "com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			System.out.println("Updating orders picked...");
			stmt = conn.createStatement();
			String sql5 = "UPDATE orders " + "SET Picked = 1 WHERE OrderID in (1,2)";
			stmt.executeUpdate(sql5);
// "Picked" is set to true for the above orders when the relevant button is selected in the order window
// 'if' statements could be moved to here to seperate boolean toggling based on ID
		}
		catch (SQLException sqle) {
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
		System.out.println("Picked!");
		//concise console confirmation proclaiming picking process performed perfectly
	} 

	public void updateordersdelivered() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName( "com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			System.out.println("Updating orders delivered...");
			stmt = conn.createStatement();
			String sql6 = "UPDATE orders " + "SET Delivered = 1 WHERE OrderID in (1,2)";
			stmt.executeUpdate(sql6);

		}
		catch (SQLException sqle) {
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
		System.out.println("Delivered!");
	} 

	public void updateitemremoval() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName( "com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			System.out.println("Updating items removed...");
			stmt = conn.createStatement();
			String sql7 = "UPDATE items " + "SET Removal = 1 WHERE ProductID = 'GNO1,HAM1,PON2'";
			stmt.executeUpdate(sql7);
//items are designated for removal - value changed to true - rather than deleting them from the table (data retention)
		}
		catch (SQLException sqle) {
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
		System.out.println("Removed!");
	} 

	public void updateitemporous() {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName( "com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			System.out.println("Updating porous items...");
			stmt = conn.createStatement();
			String sql8 = "UPDATE items " + "SET PorousWare = 1 WHERE ProductID = 'GNO1,HAM1,PON2'";
			stmt.executeUpdate(sql8);
// designates which items requiring glazing process to be performed (resulting from button within 'items' window)
		}
		catch (SQLException sqle) {
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
		System.out.println("Porous Ware!");
	} 

}
