import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class CondensedBookPanel extends JPanel {
	private Book _book;
	
	private JLabel _title;
	private JLabel _author;
	private JTextField _descriptionCondensed;
	private JLabel _pages;
	private ImageIcon _image;
	private JLabel _price;
	
	private JButton _view;
	private JButton _add;
	
	public CondensedBookPanel(Book newBook) {
		super();
		_book = newBook;
		
		setLayout(new FlowLayout(FlowLayout.LEADING));
		_title = new JLabel(_book.getTitle());
		_author = new JLabel(_book.getAuthor());
		
		_descriptionCondensed = new JTextField(_book.getDescription().substring(0, (_book.getDescription().length() < 40) ? _book.getDescription().length(): 40));
		_pages = new JLabel(String.valueOf(_book.getPages()) + " pages");
		_price = new JLabel("$" + String.valueOf(_book.getPrice()));
		
		_view = new JButton("View Book");
		_add = new JButton("Add to Cart");
		
		_image = new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "//src//" +"image.jpg"/*_book.getImagePath()*/)
				.getImage()
				.getScaledInstance(60, 90, java.awt.Image.SCALE_SMOOTH));
		
		JPanel _middlePanel = new JPanel(), _eastPanel = new JPanel();
		_middlePanel.setLayout(new FlowLayout());
		_middlePanel.add(_title);
		_middlePanel.add(_author);
		_middlePanel.add(_descriptionCondensed);
		_middlePanel.add(_pages);
		
		_eastPanel.setLayout(new BoxLayout(_eastPanel, BoxLayout.Y_AXIS));
		_eastPanel.add(_price);
		_eastPanel.add(_view);
		_eastPanel.add(_add);
		JLabel label = new JLabel(_image);
		//label.setPreferredSize(new Dimension(100,150));
		add(label, BorderLayout.WEST);
		add(_middlePanel,BorderLayout.CENTER);
		add(Box.createHorizontalGlue());
		add(_eastPanel,BorderLayout.EAST);
		
	}
}
