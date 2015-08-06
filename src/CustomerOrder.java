public class CustomerOrder {

	int OrderID;
	//just a number, probably refresh every day
	String CustomerID;
	//initials and number code
	String OrderPlaced;
	//date and time in the format YYYY-MM-DD HH:MM
	String OrderItems;
	int Quantity;
	boolean CheckedOut = false;
	boolean Picked = false;
	boolean Delivered = false;
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

}
