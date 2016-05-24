import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;

public class MainFrame extends JFrame {
	//Menu Bar and Search Bar
	private JMenuBar _menuBar;
	
	private JPanel _navPanel;
	private JTextField _searchField;
	private JButton _searchButton;
	
	private JButton _viewCatalog;
	private JButton _cart;
	private JButton _account;
	private JButton _logInOut;
	
	private JPanel _windowPanel;
	private JScrollPane _contentPanel;
	
	public MainFrame(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		_windowPanel = new JPanel();
		
		_viewCatalog = new JButton("View Catalog");
		_cart = new JButton("Cart");
		_account = new JButton("Account");
		_logInOut = new JButton("Log In");
		_searchButton = new JButton("Search");
		_searchField = new JTextField(40);
		
	    // Create and set up the content pane.
	    _menuBar = new JMenuBar();
	    _menuBar.add(_viewCatalog);
	    _menuBar.add(_cart);
	    _menuBar.add(_account);
	    _menuBar.add(_logInOut);
	    _menuBar.add(_searchField);
	    _menuBar.add(_searchButton);
	    
	    _contentPanel = new JScrollPane();
	    //_contentPanel.setPreferredSize(new Dimension(400, 700));
	    
	    _windowPanel.setLayout(new BorderLayout());
	    _windowPanel.add(_menuBar, BorderLayout.NORTH);
	    _windowPanel.add(_contentPanel, BorderLayout.CENTER);

	    setContentPane(_windowPanel);

	    // Display the window.
	    setSize(750, 700);
	    setVisible(true);
	    
	    configureSearchListeners();
	    configureViewCatalogListener();
	    configureCartListener();
	    configureAccountListener();
	    configureLogInOutListener();
	}
	
	public void setScrollView(JPanel arg) {
		_contentPanel.setViewportView(arg);
		arg.setPreferredSize(new Dimension(400, 400));
		arg.setAutoscrolls(true);
	}
	
	public void setLoggedIn() {
		_account.setVisible(true);
		_logInOut.setText("Log Out");
	}
	
	public void configureSearchListeners() {
		//_searchField
		//_searchButton
		_searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sys.sharedInstance().search(_searchField.getText());
				_searchField.setText("");
			}
		});
	}
	
	public void configureViewCatalogListener() {
		//_viewCatalog
		_viewCatalog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sys.sharedInstance().search("");
			}
		});
	}
	
	public void configureCartListener() {
		//_cart
		_cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sys.sharedInstance().viewCart();
			}
		});
	}
	
	public void configureAccountListener() {
		//_account
		_account.setVisible(false); // Hiding account screen at beginning when user is logged out
		_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sys.sharedInstance().viewAccountScreen();
			}
		});
	}
	
	public void configureLogInOutListener() {
		//_logInOut
		_logInOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(_logInOut.getText() == "Log In") {
					Sys.sharedInstance().viewLogInScreen();
				} else {
					Sys.sharedInstance().logOut();
					_account.setVisible(false);
					_logInOut.setText("Log In");
				}
			}
		});
	}
}
