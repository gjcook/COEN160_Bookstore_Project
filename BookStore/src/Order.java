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
		String tempArray[] = stringFromFile.split("\");
		
		_addressLine1 = tempArray[0];
		_addressLine2 = tempArray[1];
		_addressLine2 = tempArray[2];
		_orderContents = new ArrayList<Book>();
		for(int i = 3; i < tempArray.length; i++) {
			orderContents.add(tempArray[i]);
		}
		
		_subTotal = 0.0;
		
		for(Book b : _cartContents) {
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
		System.out.println("address1:\t\t" + _addressLine1);
		System.out.println("address2:\t\t" + _addressLine2);
		System.out.println("address3:\t\t" + _addressLine3);
		System.out.println("sub:\t\t" + _subTotal);
		System.out.println("tax:\t\t" + _tax);
		System.out.println("total:\t\t" + _total);
		for(Book d : _orderContents) { System.out.println("Book:\n" + d); }
		
	}
}
