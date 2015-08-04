
public class Item {

public String Name;	
public String ProductID;
//string - several letters and numbers derived from product name
int Quantity = 0;
//default quantity in stock, draw from database
float Price;
//float as only two decimal places
String Location = "Row, shelf, code";
//ordered locating system denotes position in warehouse
boolean Removal = false;
boolean PorousWare = false;
//again, use check-boxes

public enum thisItem { Name, ProductID, Quantity, Price, Location, Removal, PorousWare}

public String setname (String n){
	return Name = n;
}
public String getname (String name){
	return name;
}
public String setProduct (String p) {
	return ProductID=p;
	}
public String getProduct(String ID){
	return ID;
	}
public int setquantity (int q) {
	return Quantity=q;
	}
public int getquantity(int Quant){
	return Quant;
	}
public float setprice (float £){
	return Price=£;
}
public float getprice (float price){
	return price;
}
public String setlocation (String l){
	return Location=l;
	}
public String getlocation (String located) {
	return located;
	}
public boolean setremoved (boolean r){
	return Removal = r;
	}
public boolean getremoved (boolean removed){
	return removed;
	}
public boolean setporous (boolean w){
	return PorousWare = w;
	}
public boolean getporous (boolean porous){
	return porous;
	}
}

