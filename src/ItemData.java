
public class ItemData {

	public String ProductID;
	//string - several letters and numbers derived from product name
	public String ProductName;	
	int Stock = 0;
	//default quantity in stock, draw from database
	float Price;
	//float as only two decimal places
	int Weight;
	//kg?
	String Dimensions = "width, length, depth";
	String Manufacturer = "Company, Address";
	String Location = "Row, shelf, code";
	//ordered locating system denotes position in warehouse
	boolean Removal = false;
	boolean PorousWare = false;
	//again, use check-boxes


}
