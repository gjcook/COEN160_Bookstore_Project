import java.util.List;
import java.lang.System;
import java.util.ArrayList;
import javax.swing.JFrame;


public class Sys {
	private Account _activeUser;
	private AccountList _userList;
	private Inventory _inventory;
	private Cart _cart;
	private boolean _isLoggedIn;
	private MainFrame _mainFrame;
	//private Jpanel for screen. This will be the outermost JPanel
	
	
	//Setting System to a singleton value, accessed by running System.sharedInstance();
	private static Sys _singleton = new Sys();
	
	public static Sys sharedInstance() { return _singleton; }
	
	private Sys() {
		_activeUser = null;
		_cart = new Cart();
		_isLoggedIn = false;
		_inventory = new Inventory(getInvFilePath());
		_userList = new AccountList(getAccFilePath());
		_mainFrame = new MainFrame("Online Bookstore");
	}
	
	private String getInvFilePath() { return "bookList.txt"; }
	
	private String getAccFilePath() { return "accList.txt"; }
	
	public boolean logIn(String accountName, String password) {
		if(_isLoggedIn == false) {
			Account tempUser = _userList.lookupUsername(accountName);
			if(tempUser != null && tempUser.auth(password)) {
				_activeUser = tempUser;
				return true;
			}
		}
		return false;
	}
	
	public void addNewAccount(Account acc) {
		_userList.addAccountToList(acc);
		_userList.saveData(getAccFilePath());
	}
	
	public boolean logOut() {
		if(_isLoggedIn == true) {
			_userList.saveData(getAccFilePath());	//Might need to pass more stuff to this
			_isLoggedIn = false;
		}
		return false;
	}

	public List<Book> getBooks() {
		return _inventory.getAllBooks();
	}
	
	public static void main(String args[]) {
		
		Sys.sharedInstance().logIn("gcook","dad");
		Sys.sharedInstance().logOut();
		
		Sys.sharedInstance().logOut();
		
		Sys.sharedInstance()._mainFrame.setScrollView(new ViewPanel(""));
		
	}
}
