import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;

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
	    _contentPanel.setPreferredSize(new Dimension(800, 800));
	    
	    _windowPanel.setLayout(new BorderLayout());
	    _windowPanel.add(_menuBar, BorderLayout.NORTH);
	    _windowPanel.add(_contentPanel, BorderLayout.CENTER);
	    
	    setContentPane(_windowPanel);

	    // Display the window.
	    setSize(700, 1000);
	    setVisible(true);
	}
	
	public void setScrollView(JPanel arg) {
		_contentPanel.setViewportView(arg);
		arg.setPreferredSize(new Dimension(700, 1000));
		arg.setAutoscrolls(true);
	}
}
