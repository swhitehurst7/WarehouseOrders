public class OrderData {

	static int OrderID;
	//just a number, probably refresh every day
	static String CustomerID;
	//initials and number code
	static String OrderPlaced;
	//date and time in the format YYYY-MM-DD HH:MM:SS
	static String OrderItems;
	static int Quantity;
	static boolean CheckedOut;
	static boolean Picked;
	static boolean Delivered;
	//check-boxes to show status

	public class orderfields{

		public int getOrderID() {
			return OrderID;
		}
		public void setOrderID(int orderID) {
			OrderID = orderID;
		}
		public String getCustomerID() {
			return CustomerID;
		}
		public void setCustomerID(String customerID) {
			CustomerID = customerID;
		}
		public String getOrderPlaced() {
			return OrderPlaced;
		}
		public void setOrderPlaced(String orderPlaced) {
			OrderPlaced = orderPlaced;
		}
		public String getOrderItems() {
			return OrderItems;
		}
		public void setOrderItems(String orderItems) {
			OrderItems = orderItems;
		}
		public int getQuantity() {
			return Quantity;
		}
		public void setQuantity(int quantity) {
			Quantity = quantity;
		}
		public boolean isCheckedOut() {
			return CheckedOut;
		}
		public void setCheckedOut(boolean checkedOut) {
			CheckedOut = checkedOut;
		}
		public boolean isPicked() {
			return Picked;
		}
		public void setPicked(boolean picked) {
			Picked = picked;
		}
		public boolean isDelivered() {
			return Delivered;
		}
		public void setDelivered(boolean delivered) {
			Delivered = delivered;
		}

	}

	public OrderData(int orderID, String customerID, String orderPlaced, String orderItems, int quantity, boolean checkedOut, boolean picked, boolean delivered){

		this.OrderID = orderID;
		this.CustomerID = customerID;
		this.OrderPlaced = orderPlaced;
		this.OrderItems = orderItems;
		this.Quantity = quantity;
		this.CheckedOut = checkedOut;
		this.Picked = picked;
		this.Delivered = delivered;

		System.out.println("------------------------------");
		System.out.println(OrderID);
		System.out.println(CustomerID);
		System.out.println(OrderPlaced);
		System.out.println(OrderItems);
		System.out.println(Quantity);
		System.out.println(CheckedOut);
		System.out.println(Picked);
		System.out.println(Delivered);
		System.out.println("------------------------------");
	}

}
