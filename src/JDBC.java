import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBC {

	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/nb_gardens";
	 //IP and name of mysql module/schema
	 static final String USER = "root";
	 static final String PASS = "netbuilder";
	 //login details for mysql

	 public void itemcatalogue() {
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
		   int id = rs.getInt("ProductID");
		   String name = rs.getString("ProductName");
		   int stock = rs.getInt("Stock");
		   int price = rs.getInt("Price");
		   int weight = rs.getInt("Weight");
		   String size = rs.getString("Dimensions");
		   String madeby = rs.getString("Manufacturer");
		   String located = rs.getString("Location");
		   String remove = rs.getString("Removal");
		   String porous = rs.getString("PorousWare");
		System.out.println("ID: " + id + ", Name: " + name + ", Stock: " + stock + ", Price: " + price + ", Weight: " + weight + ", Dimensions: " + size + ", Manufacturer: " + madeby + ", Location: " + located + ", Removal: " + remove + ", PorousWare: " + porous);
		  }
		  //determines and displays all fields for table
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
			 } 

	 public void ordercatalogue() {
		 Connection conn = null;
		 Statement stmt = null;
		 try {
		  Class.forName( "com.mysql.jdbc.Driver");
		  System.out.println("Connecting to database...");
		  conn = DriverManager.getConnection(DB_URL, USER, PASS);
	 
		System.out.println("Creating o...");
		stmt = conn.createStatement();
		String sql3 = "SELECT OrderID, CustomerID, OrderPlaced, OrderItems, Quantity, CheckedOut, Picked, Delivered FROM orders";
		ResultSet res = stmt.executeQuery(sql3);
		while (res.next()) {
		 int id = res.getInt("OrderID");
		 String customer = res.getString("CustomerID");
		 String date = res.getString("OrderPlaced");
		 String items = res.getString("OrderItems");
		 int quant = res.getInt("Quantity");
		 String checked = res.getString("CheckedOut");
		 String picked = res.getString("Picked");
		 String deliver = res.getString("Delivered");
		System.out.println("OrderID: " + id + ", CustomerID: " + customer + ", OrderPlaced: " + date + ", OrderItems: " + items + ", Quantity: " + quant + ", CheckedOut: " + checked + ", Picked: " + picked + ", Delivered: " + deliver);
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
		
			