import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;


public class OrderPanel extends JPanel {
	private Order _order;
	
	public OrderPanel(Order o) {
		_order = o;
		
		setLayout(new BorderLayout());
		
		JPanel east = new JPanel(),
				center = new JPanel(),
				west = new JPanel();
		
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		add(east, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
		
		System.out.println("Order contents size: "+ _order.getOrderContents().size());
		for(Book b : _order.getOrderContents()) {
			center.add(new JLabel(b.getTitle() + " - " + b.getAuthor() + " - " + Sys.sharedInstance().getFormat().format(b.getPrice())));
		}
		
		east.add(new JLabel("Subtotal:  "+Sys.sharedInstance().getFormat().format(_order.getSubTotal())));
		east.add(new JLabel("Tax:          "+Sys.sharedInstance().getFormat().format(_order.getTax())));
		east.add(new JLabel("Total:       "+Sys.sharedInstance().getFormat().format(_order.getTotal())));
		
		west.add(new JLabel("Shipped to:"));
		west.add(new JLabel(_order.getAddressLine1()));
		west.add(new JLabel(_order.getAddressLine2()));
		west.add(new JLabel(_order.getaddressLine3()));
	}
}
