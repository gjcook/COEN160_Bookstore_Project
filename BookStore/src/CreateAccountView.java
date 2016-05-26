import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateAccountView extends JPanel {
	JTextField _username;
	JTextField _password;
	JTextField _repeatPassword;
	JTextField _firstName;
	JTextField _lastName;
	JTextField _email;
	JComboBox<String> _secretQuestionSelector;
	JTextField _secretAnswer;
	
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
		_repeatPassword = new JTextField(20);
		_email = new JTextField(20);
		_firstName = new JTextField(20);
		_lastName = new JTextField(20);
		_secretQuestionSelector = new JComboBox<String>();
		_secretQuestionSelector.addItem("What was the name of your first pet?");
		_secretQuestionSelector.addItem("What is your mother's maiden name?");
		_secretQuestionSelector.addItem("What is your favorite song?");
		_secretAnswer = new JTextField(20);
		_createAccount = new JButton("Create New Account");
		
		JLabel usernameLabel = new JLabel("Enter the Username You Would Like"),
				emailLabel = new JLabel("Enter your Email"),
				firstNameLabel = new JLabel("Enter Your First Name"),
				lastNameLabel = new JLabel("Enter Your Last Name"),
				passwordLabel = new JLabel("Enter your New Password"),
				repeatPasswordLabel = new JLabel("Repeat Password"),
				secretQuestionLabel = new JLabel("Choose a Secret Question"),
				secretAnswerLabel = new JLabel("Write Your Answer");
		JPanel temp;
		_usernamePanel.setLayout(new BoxLayout(_usernamePanel, BoxLayout.Y_AXIS));
		temp = new JPanel();
		temp.add(usernameLabel);
		temp.add(_username);
		_usernamePanel.add(temp);
		temp = new JPanel();
		temp.add(emailLabel);
		temp.add(_email);
		_usernamePanel.add(temp);
		temp = new JPanel();
		temp.add(firstNameLabel);
		temp.add(_firstName);
		_usernamePanel.add(temp);
		temp = new JPanel();
		temp.add(lastNameLabel);
		temp.add(_lastName);
		_usernamePanel.add(temp);
		
		_passwordPanel.setLayout(new BoxLayout(_passwordPanel, BoxLayout.Y_AXIS));
		temp = new JPanel();
		temp.add(passwordLabel);
		temp.add(_password);
		_passwordPanel.add(temp);
		temp = new JPanel();
		temp.add(repeatPasswordLabel);
		temp.add(_repeatPassword);
		_passwordPanel.add(temp);
		temp = new JPanel();
		temp.add(secretQuestionLabel);
		temp.add(_secretQuestionSelector);
		_passwordPanel.add(temp);
		temp = new JPanel();
		temp.add(secretAnswerLabel);
		temp.add(_secretAnswer);
		_passwordPanel.add(temp);
		
		_buttonPanel.add(_createAccount);
		
		add(_errorLabel);
		add(_usernamePanel);
		add(_passwordPanel);
		add(_buttonPanel);
		
		configureUsernameCheckerObserver();
		configurePasswordCheckerObserver();
		configureCreateAccountObserver();
	}
	
	private void configureUsernameCheckerObserver() {
		_username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Sys.sharedInstance().checkIfUsernameExists(_username.getText())) {
					_errorLabel.setText("That Username already exists! Please choose a different one!");
				} else {
					_errorLabel.setText("");
				}
			}
		});
	}
	
	private void configurePasswordCheckerObserver() {
		_repeatPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(_password.getText().equals(_repeatPassword.getText())) {
					_errorLabel.setText("");
				} else {
					_errorLabel.setText("Error: your passwords do not match! Please rewrite them!");
				}
			}
		});
		
		_password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(_password.getText().equals(_repeatPassword.getText())) {
					_errorLabel.setText("");
				} else {
					_errorLabel.setText("Error: your passwords do not match! Please rewrite them!");
				}
			}
		});
	}
	
	private void configureCreateAccountObserver() {
		_createAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(_username.getText().equals("") ||
						_password.getText().equals("") ||
						_repeatPassword.getText().equals("") ||
						_email.getText().equals("") ||
						_firstName.getText().equals("") ||
						_lastName.getText().equals("") ||
						_secretAnswer.getText().equals("")) {
					_errorLabel.setText("Certain required fields have been left blank. Please fill out the entire form!");
				} else {
					_errorLabel.setText("");
					if(!Sys.sharedInstance().checkIfUsernameExists(_username.getText()) &&
							_password.getText().equals(_repeatPassword.getText()) &&
							/*_secretQuestionSelector. &&*/
							!_secretAnswer.equals("")) {
						Sys.sharedInstance().createAccount(
								_username.getText(),
								_password.getText(),
								_firstName.getText(),
								_lastName.getText(),
								_email.getText(),
								(String)_secretQuestionSelector.getSelectedItem(), _secretAnswer.getText());
					} else {
						//stay on screen and do not log in
					}
				}
			}
		});
	}
}
