import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MyRecentOrdersView extends JPanel {
	private List<Order> _orders;
	private JButton _back;
	public MyRecentOrdersView() {
		_back = new JButton("Back");
		_orders = Sys.sharedInstance().getOrders();
		
		add(_back);
		add(new JLabel("My Recent Orders"));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		displayOrders();
		configureBackButtonObserver();
	}
	
	private void displayOrders() {
		for(Order o : _orders) {
			add(new OrderPanel(o));
		}
	}
	
	private void configureBackButtonObserver() {
		_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sys.sharedInstance().viewAccountScreen();
			}
		});
	}
}
