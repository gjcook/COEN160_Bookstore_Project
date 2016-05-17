import java.util.List;
import java.util.ArrayList;

public class Account {
	//What else do we need in account?
	private List<Order> _recentOrders;
	private String _username;
	private String _password;
	private String _firstName;
	private String _lastName;
	private String _email;
	private String _secretQuestion;
	private String _secretAnswer;
	
	public Account() {
		_recentOrders = new ArrayList<Order>();
		saveCurrentSessionData();
	}
	
	public Account(
			String username,
			String password,
			String firstName,
			String lastName,
			String email,
			String secretQuestion,
			String secretAnswer,
			List<Order> recentOrders) {
		_username = username;
		_password = password;
		_firstName = firstName;
		_lastName = lastName;
		_email = email;
		_secretQuestion = secretQuestion;
		_secretAnswer = secretAnswer;
		_recentOrders = recentOrders;
	}
	
	public boolean auth(String passwordToCheck) {
		return _password.equals(passwordToCheck);
	}
	
	public void saveCurrentSessionData() {
		
	}
}
