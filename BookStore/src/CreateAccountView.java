import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateAccountView extends JPanel {
	JTextField _username;
	JTextField _password;
	JButton _login;
	JButton _forgotPassword;
	JButton _createAccount;
	JLabel _errorLabel;
	
	public CreateAccountView() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel _usernamePanel = new JPanel(),
				_passwordPanel = new JPanel(),
				_buttonPanel = new JPanel();
		
		_errorLabel = new JLabel("");
		_username = new JTextField(20);
		_password = new JTextField(20);
		_login = new JButton("Log In");
		_forgotPassword = new JButton("Forgot Password?");
		_createAccount = new JButton("Create New Account");
		
		JLabel usernameLabel = new JLabel("Username"),
				passwordLabel = new JLabel("Password");
		
		_usernamePanel.add(usernameLabel);
		_usernamePanel.add(_username);
		
		_passwordPanel.add(passwordLabel);
		_passwordPanel.add(_password);
		
		_buttonPanel.add(_login);
		_buttonPanel.add(_forgotPassword);
		_buttonPanel.add(_createAccount);
		
		add(_errorLabel);
		add(_usernamePanel);
		add(_passwordPanel);
		add(_buttonPanel);
		
		configureLoginObserver();
		configureForgotPasswordObserver();
		configureCreateAccountObserver();
	}
	
	private void configureLoginObserver() {
		_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Sys.sharedInstance().logIn(_username.getText(), _password.getText())){
					_username.setText("");
					_password.setText("");
					_errorLabel.setText("Invalid username/password combination. Try again!");
				}
			}
		});
	}
	
	private void configureForgotPasswordObserver() {
		_forgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	private void configureCreateAccountObserver() {
		_createAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
