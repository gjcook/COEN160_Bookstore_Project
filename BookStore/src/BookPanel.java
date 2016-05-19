import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class BookPanel extends JPanel {
	private Book _book;
	private String _query;
	
	private JLabel _title;
	private JLabel _author;
	private JTextField _descriptionCondensed;
	private JLabel _pages;
	private ImageIcon _image;
	private JLabel _price;
	
	private JButton _back;
	private JButton _view;
	private JButton _add;
	
	public BookPanel(Book newBook, String query, boolean showBackButton) {
		super();
		_query = query;
		_book = newBook;

		setLayout(new BorderLayout());
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
		
		JPanel _middlePanel = new JPanel(), _eastPanel = new JPanel(), _titlePanel = new JPanel();
		_titlePanel.setLayout(new BoxLayout(_titlePanel, BoxLayout.Y_AXIS));
		_titlePanel.add(_title);
		_titlePanel.add(_author);
		_middlePanel.setLayout(new BorderLayout());
		_middlePanel.add(_titlePanel, BorderLayout.NORTH);
		_middlePanel.add(_descriptionCondensed, BorderLayout.CENTER);
		_middlePanel.add(_pages, BorderLayout.EAST);
		
		_eastPanel.setLayout(new BoxLayout(_eastPanel, BoxLayout.Y_AXIS));
		_eastPanel.add(_price);
		_eastPanel.add(_view);
		_eastPanel.add(_add);
		JLabel label = new JLabel(_image);

		add(_middlePanel,BorderLayout.CENTER);
		add(label, BorderLayout.WEST);

		//add(Box.createHorizontalGlue());
		add(_eastPanel,BorderLayout.EAST);
		
		_back = new JButton("back");
		
		add(_back, BorderLayout.NORTH);
		this.setPreferredSize(new Dimension(700, 100));
		this.setMaximumSize(new Dimension(700, 100));
		this.setMinimumSize(new Dimension(700, 100));
		
		configureAddToCartListener();
		configureBackButtonListener();
		if(!showBackButton) {
			_back.setVisible(false);
		}
	}
	
	private void configureAddToCartListener() {
		_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sys.sharedInstance().addToCart(_book);
			}
		});
	}
	
	private void configureBackButtonListener() {
		_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sys.sharedInstance().search(_query);
			}
		});
	}
}
