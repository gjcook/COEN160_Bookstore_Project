import java.util.List;
import java.util.ArrayList;

public class System {
	private Account _activeUser;
	private AccountList _userList;
	private Inventory _inventory;
	private Cart _cart;
	private boolean _isLoggedIn;
	//private Jpanel for screen. This will be the outermost JPanel
	
	
	//Setting System to a singleton value, accessed by running System.sharedInstance();
	private static System _singleton = new System();
	
	public static System sharedInstance() { return _singleton; }
	
	private System() {
		_activeUser = null;
		_cart = new Cart();
		_isLoggedIn = false;
		_inventory = new Inventory(getInvFilePath());
		_userList = new AccountList(getAccFilePath());
	}
	
	private String getInvFilePath() { return "bookList.txt"; }
	
	private String getAccFilePath() { return "accList.txt"; }
	
	public boolean logIn(String accountName, String password) {
		if(_isLoggedIn == false) {
			Account tempUser = _userList.lookupUsername(accountName);
			tempUser.auth(password);
		}
		return false;
	}
	
	public boolean logOut() {
		if(_isLoggedIn == true) {
			_activeUser.saveCurrentSessionData();	//Might need to pass more stuff to this
			_isLoggedIn = false;
		}
		return false;
	}

	
}
