
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

	public class itemfields {

		public String getProductID() {
			return ProductID;
		}
		public void setProductID(String productID) {
			ProductID = productID;
		}
		public String getProductName() {
			return ProductName;
		}
		public void setProductName(String productName) {
			ProductName = productName;
		}
		public int getStock() {
			return Stock;
		}
		public void setStock(int stock) {
			Stock = stock;
		}
		public float getPrice() {
			return Price;
		}
		public void setPrice(float price) {
			Price = price;
		}
		public int getWeight() {
			return Weight;
		}
		public void setWeight(int weight) {
			Weight = weight;
		}
		public String getDimensions() {
			return Dimensions;
		}
		public void setDimensions(String dimensions) {
			Dimensions = dimensions;
		}
		public String getManufacturer() {
			return Manufacturer;
		}
		public void setManufacturer(String manufacturer) {
			Manufacturer = manufacturer;
		}
		public String getLocation() {
			return Location;
		}
		public void setLocation(String location) {
			Location = location;
		}
		public boolean isRemoval() {
			return Removal;
		}
		public void setRemoval(boolean removal) {
			Removal = removal;
		}
		public boolean isPorousWare() {
			return PorousWare;
		}
		public void setPorousWare(boolean porousWare) {
			PorousWare = porousWare;
		}

	}
	
	public class itemdata{
	
		// String itemdata = ("ID: " + id + ", Name: " + name + ", Stock: " + stock + ", Price: " + price + ", Weight: " + weight + ", Dimensions: " + size + ", Manufacturer: " + madeby + ", Location: " + located + ", Removal: " + remove + ", PorousWare: " + porous);
		
	}

	}
