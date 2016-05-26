import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class CheckoutView extends JPanel {
	//get user address, get user stuff, display something like a car view, press enter
	JLabel _errorLabel;
	JTextField _addressLine1;
	JTextField _addressLine2;
	JTextField _addressLine3;
	JTextField _CCNumber;
	JTextField _CCCode;
	JTextField _CCMonth;
	JTextField _CCYear;
	
	Cart _cart;
	
	JButton _placeOrder;
	JButton _cancel;
	
	public CheckoutView(Cart c) {
		_cart = c;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		_errorLabel = new JLabel("");
		_addressLine1 = new JTextField(20);
		_addressLine2 = new JTextField(20);
		_addressLine3 = new JTextField(20);
		_CCNumber = new JTextField(20);
		_CCCode = new JTextField(20);
		_CCMonth = new JTextField(2);
		_CCYear = new JTextField(2);
		_placeOrder = new JButton("Place Order");
		_cancel = new JButton("Return to Cart");
		
		add(_errorLabel);
		
		add(new JLabel("Address Line 1"));
		add(_addressLine1);
		
		add(new JLabel("Address Line 2 (Optional)"));
		add(_addressLine2);
		add(new JLabel("City, State ZIP"));
		add(_addressLine3);
		
		add(new JLabel("Payment Information"));
		add(new JLabel("Credit Card Number"));
		add(_CCNumber);
		add(new JLabel("Security Code"));
		add(_CCCode);
		add(new JLabel("Expiration Date"));
		add(_CCMonth);
		add(new JLabel("/"));
		add(_CCYear);
		add(_placeOrder);
		add(_cancel);
		
		setPreferredSize(new Dimension(400,600));
		
		configurePlaceOrderObserver();
		configureCancelOrderObserver();
	}

	private void configurePlaceOrderObserver() {
		_placeOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(_addressLine1.getText().length() < 5 ||
						_addressLine1.getText().length() > 20 ||
						_addressLine3.getText().length() < 5 ||
						_addressLine3.getText().length() > 20) {
					_errorLabel.setText("Invalid address. Please properly fill out those fields");
				} else if (Double.valueOf(_CCNumber.getText()) == null ||
						_CCNumber.getText().length() != 16) {
					_errorLabel.setText("Please enter a proper 16 digit Credit Card Number");
				} else if (Long.valueOf(_CCCode.getText()) == null ||
						_CCCode.getText().length() != 3) {
					_errorLabel.setText("Please enter a 3 digit Security Code");
				} else if (_CCMonth.getText().length() != 2 ||
						_CCYear.getText().length() != 2 ||
						!Character.isDigit(_CCMonth.getText().charAt(0)) ||
						!Character.isDigit(_CCMonth.getText().charAt(1)) ||
						!Character.isDigit(_CCYear.getText().charAt(0)) ||
						!Character.isDigit(_CCYear.getText().charAt(1))) {
					_errorLabel.setText("Please enter a proper expiration date");
				} else {
					_errorLabel.setText("");
					Sys.sharedInstance().placeOrder(new Order(
						_cart.getCartContents(),
						_cart.getSubTotal(),
						_cart.getTax(),
						_cart.getTotal(),
						_addressLine1.getText(),
						_addressLine2.getText(),
						_addressLine3.getText(),
						_CCNumber.getText(),
						_CCCode.getText(),
						_CCMonth.getText(),
						_CCYear.getText()));
					Sys.sharedInstance().viewRecentOrders();
				} 
			}
		});
	}
	
	private void configureCancelOrderObserver() {
		_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sys.sharedInstance().viewCart();
			}
		});
	}
}
