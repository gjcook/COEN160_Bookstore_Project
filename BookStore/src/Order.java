import java.util.List;
import java.util.ArrayList; 
import java.lang.System;

public class Order {
	private List<Book> _orderContents;
	
	private double _subTotal;
	private double _tax;
	private double _total;
	
	private String _addressLine1;	//<Address>
	private String _addressLine2;	//<Address continued>
	private String _addressLine3;	//<City>, <State> <Zip>
	
	public Order(
			List<Book> orderContents, 
			double subTotal,
			double tax,
			double total,
			String addressLine1,
			String addressLine2,
			String addressLine3) {
		_orderContents = orderContents;
		_subTotal = subTotal;
		_tax = tax;
		_total = total;
		_addressLine1 = addressLine1;
		_addressLine2 = addressLine2;
		_addressLine3 = addressLine3;
	}
	
	public Order(String stringFromFile) {
		String tempArray[] = stringFromFile.split("/");

		_addressLine1 = tempArray[0];
		_addressLine2 = tempArray[1];
		_addressLine3 = tempArray[2];
		_orderContents = new ArrayList<Book>();
		for(int i = 3; i < tempArray.length; i++) {
			_orderContents.add(new Book(tempArray[i]));
		}
		
		_subTotal = 0.0;
		
		for(Book b : _orderContents) {
			_subTotal += b.getPrice();
		}
		
		_tax = _subTotal * 0.075;
		_total = _subTotal + _tax;
	}
	
	public List<Book> getCartContents() { return _orderContents; }
	
	public double getSubTotal() { return _subTotal; }
	
	public double getTax() { return _tax; }
	
	public double getTotal() { return _total; }
	
	public String getAddressLine1() { return _addressLine1; }
	
	public String getAddressLine2() { return _addressLine2; }
	
	public String getaddressLine3() { return _addressLine3; }
	
	public String toString() {
		String ret = "";
		ret += _addressLine1;
		ret += "/" + _addressLine2;
		ret += "/" + _addressLine3;
		for(Book b: _orderContents) { ret += "/" + b; }
		
		return ret;
	}
	
	public String toReadableString() {
		String ret = "";
		ret += ("address1:\t\t" + _addressLine1);
		ret += ("\naddress2:\t\t" + _addressLine2);
		ret += ("\naddress3:\t\t" + _addressLine3);
		ret += ("\nsub:\t\t\t" + _subTotal);
		ret += ("\ntax:\t\t\t" + _tax);
		ret += ("\ntotal:\t\t\t" + _total);
		for(Book d : _orderContents) { ret += ("\nBook:\n" + d); }
		ret += "\n";
		return ret;
	}
}
