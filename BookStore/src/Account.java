import java.util.List;
import java.util.ArrayList;

public class Account implements CharSequence {
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
		Sys.sharedInstance().addNewAccount(this);
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
	
	public String getID() {
		return _username;
	}
	
	public String toString() {
		String ret = "";
		ret += _username;
		ret += "\t" + _password;
		ret += "\t" + _firstName;
		ret += "\t" + _lastName;
		ret += "\t" + _email;
		ret += "\t" + _secretQuestion;
		ret += "\t" + _secretAnswer;
		
		if(_recentOrders != null) {
			for(Order o : _recentOrders) {
				ret += "\t" + o;
			}
		}
		
		return ret;
	}
	
	public String toReadableString() {
		String ret = "";
		ret += "username:\t\t" + _username + "\n";
		ret += "password:\t\t" + _password + "\n";
		ret += "firstName:\t\t" + _firstName + "\n";
		ret += "lastName:\t\t" + _lastName + "\n";
		ret += "email:\t\t\t" + _email + "\n";
		ret += "secretQuestion:\t\t" + _secretQuestion + "\n";
		ret += "secretAnswer:\t\t" + _secretAnswer + "\n";
		
		if(_recentOrders != null) {
			for(Order o : _recentOrders) {
				ret += "Order\n" + o;
			}
		}
		
		return ret;
	}

	@Override
	public char charAt(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}
}
