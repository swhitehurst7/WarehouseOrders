
public class StockOrderData {

	String StockOrderID;
	String ProductID;
	String Manufacturer;
	int Quantity;
	
	public class stockorderfields{
		
		public String getStockOrderID() {
			return StockOrderID;
		}
		public void setstockOrderID(String stockorderID) {
			StockOrderID = stockorderID;
		}
		public String getProductID() {
			return ProductID;
		}
		public void setProductID(String productID) {
			ProductID = productID;
		}
		public String Manufacturer() {
			return Manufacturer;
		}
		public void setManufacturer(String manufacturer) {
			Manufacturer = manufacturer;
		}

		}
		public int getQuantity() {
			return Quantity;
		}
		public void setQuantity(int quantity) {
			Quantity = quantity;
		
	}
	
		public StockOrderData(String stockorderID, String productID, String manufacturer, int quantity){

			this.StockOrderID = stockorderID;
			this.ProductID = productID;
			this.Manufacturer = manufacturer;
			this.Quantity = quantity;

			System.out.println("------------------------------");
			System.out.println(StockOrderID);
			System.out.println(ProductID);
			System.out.println(Manufacturer);
			System.out.println(Quantity);

			System.out.println("------------------------------");

		}
		
}
