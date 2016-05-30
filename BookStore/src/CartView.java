import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.List;

public class CartView extends JPanel {
	Cart _cart;
	JLabel _header;
	JButton _checkout;
	JPanel _view;
	JPanel _footer;
	
	public CartView(Cart cart) {
		super();
		_cart = cart;

		setLayout(new BorderLayout());
		_header = new JLabel("Your Cart Contents");
		
		_view = new JPanel();
		_view.setLayout(new FlowLayout());
		_view.add(_header);
		
		add(_view, BorderLayout.CENTER);
		displayCart();
		
		_footer = new JPanel();
		JPanel footerLeft = new JPanel(), footerRight = new JPanel();
		_footer.setLayout(new BoxLayout(_footer, BoxLayout.X_AXIS));
		footerLeft.setLayout(new BoxLayout(footerLeft, BoxLayout.Y_AXIS));
		footerRight.setLayout(new BoxLayout(footerRight, BoxLayout.Y_AXIS));
		footerLeft.add(new JLabel("Subtotal:  "+Sys.sharedInstance().getFormat().format(_cart.getSubTotal())));
		footerLeft.add(new JLabel("Tax:          "+Sys.sharedInstance().getFormat().format(_cart.getTax())));
		footerLeft.add(new JLabel("Total:       "+Sys.sharedInstance().getFormat().format(_cart.getTotal())));
		_checkout = new JButton("Checkout");
		footerRight.add(_checkout);
		_footer.add(footerLeft);
		_footer.add(footerRight);
		_view.add(_footer);
		
		configureCheckoutListener();
	}
	
	private void reloadCartView() {
		Sys.sharedInstance().viewCart();
	}
	
	private void displayCart() {
		List<Book> books = _cart.getCartContents();
		for(Book b : books) {
			_view.add(createSubPanel(b));
		}
		setPreferredSize(new Dimension(400,125*books.size()));
	}
	
	private JPanel createSubPanel(Book book) {
		JPanel ret = new JPanel();
		ret.setLayout(new BorderLayout());
		JLabel title = new JLabel(book.getTitle());
		JLabel author = new JLabel(book.getAuthor());
		
		JLabel price = new JLabel("$" + String.valueOf(Sys.sharedInstance().getFormat().format(book.getPrice())));
		
		JButton view = new JButton("View Book");
		JButton remove = new JButton("Remove from Cart");
		
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sys.sharedInstance().viewBook(book, "", false);
			}
		});
		
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sys.sharedInstance().removeBookFromCart(book);
				reloadCartView();
			}
		});
		
		ImageIcon _image = new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "//src//" + book.getImagePath())
				.getImage()
				.getScaledInstance(60, 90, java.awt.Image.SCALE_SMOOTH));
		
		JPanel _middlePanel = new JPanel(), _eastPanel = new JPanel(), _titlePanel = new JPanel();
		_titlePanel.setLayout(new BoxLayout(_titlePanel, BoxLayout.Y_AXIS));
		_titlePanel.add(title);
		_titlePanel.add(author);
		_middlePanel.setLayout(new BorderLayout());
		_middlePanel.add(_titlePanel, BorderLayout.CENTER);
		
		_eastPanel.setLayout(new BoxLayout(_eastPanel, BoxLayout.Y_AXIS));
		_eastPanel.add(price);
		_eastPanel.add(view);
		_eastPanel.add(remove);
		JLabel label = new JLabel(_image);

		ret.add(_middlePanel,BorderLayout.CENTER);
		ret.add(label, BorderLayout.WEST);
		
		//add(Box.createHorizontalGlue());
		ret.add(_eastPanel,BorderLayout.EAST);

		ret.setPreferredSize(new Dimension(700, 100));
		ret.setMaximumSize(new Dimension(700, 100));
		ret.setMinimumSize(new Dimension(700, 100));
		
		
		return ret;
	}
	
	private void configureCheckoutListener() {
		_checkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Sys.sharedInstance().isLoggedIn() && _cart.getCartContents().size() > 0) {
					Sys.sharedInstance().checkout(_cart);
				} else if(!Sys.sharedInstance().isLoggedIn()) {
					_header.setText("Please Log In Before Checking Out!");
				} else {
					_header.setText("Add a book to the cart before checking out!");
				}
			}
		});
	}
}
