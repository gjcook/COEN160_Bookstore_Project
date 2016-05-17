import java.util.List;
import java.util.ArrayList;

public class Cart {
	private List<Book> _cartContents;
	private double _subTotal;
	private double _tax;
	private double _total;
	
	public Cart() {
		_cartContents = new ArrayList<Book>();
	}
	
	/**
	 * runCalcs is a setter for all 3 doubles
	 */
	private void runCalcs() {
		_subTotal = 0.0;
		
		for(Book b : _cartContents) {
			_subTotal += b.getPrice();
		}
		
		_tax = _subTotal * 0.075;
		_total = _subTotal + _tax;
	}
	
	/**
	 * Setter for adding a new book to the cart
	 * @param newBook
	 */
	public void addBook(Book newBook) {
		_cartContents.add(newBook);
		this.runCalcs();
	}
	
	/**
	 * Setter to remove book from cart
	 * @param bookToRemove
	 */
	public void removeBook(Book bookToRemove) {
		_cartContents.remove(bookToRemove);
		this.runCalcs();
	}
	
	public List<Book> getCartContents() { return _cartContents; }
	
	public double getSubTotal() { return _subTotal; }
	
	public double getTax() { return _tax; }
	
	public double getTotal() { return _total; }
}
