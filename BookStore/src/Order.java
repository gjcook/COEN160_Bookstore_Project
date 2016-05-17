import java.util.List;

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
		
	}
	
	public List<Book> getCartContents() { return _orderContents; }
	
	public double getSubTotal() { return _subTotal; }
	
	public double getTax() { return _tax; }
	
	public double getTotal() { return _total; }
	
	public String getAddressLine1() { return _addressLine1; }
	
	public String getAddressLine2() { return _addressLine2; }
	
	public String getaddressLine3() { return _addressLine3; }
}
