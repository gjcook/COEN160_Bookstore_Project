import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ForgotPasswordView extends JPanel {
	JTextField _username;
	JLabel _secretQuestion;
	JTextField _secretAnswer;
	JButton _validateAnswer;
	JTextField _newPassword;
	JTextField _repeatPassword;
	JButton _changePassword;
	JLabel _errorLabel;
	JPanel _newPasswordPanel;
	JPanel _secretQuestionPanel;
	JButton _back;
	
	private String tempAccountName;
	
	public ForgotPasswordView() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel _usernamePanel = new JPanel();
		_secretQuestionPanel = new JPanel();
		_newPasswordPanel = new JPanel();
		
		_errorLabel = new JLabel("");
		_username = new JTextField(20);
		_secretQuestion = new JLabel("");
		_secretAnswer = new JTextField(20);
		_validateAnswer = new JButton("Submit");
		_newPassword = new JTextField(20);
		_repeatPassword = new JTextField(20);
		_changePassword = new JButton("Change Password");
		
		JLabel usernameLabel = new JLabel("Username"),
				secretQuestionLabel = new JLabel("Secret Question"),
				secretAnswerLabel = new JLabel("Secret Answer"),
				newPasswordHeader = new JLabel("Enter a new Password"),
				newPasswordLabel = new JLabel("New Password"),
				repeatPasswordLabel = new JLabel("Repeat Password");
		
		_usernamePanel.add(usernameLabel);
		_usernamePanel.add(_username);
		
		_secretQuestionPanel.add(secretQuestionLabel);
		_secretQuestionPanel.add(_secretQuestion);
		_secretQuestionPanel.add(secretAnswerLabel);
		_secretQuestionPanel.add(_secretAnswer);
		_secretQuestionPanel.add(_validateAnswer);
		
		_newPasswordPanel.add(newPasswordHeader);
		_newPasswordPanel.add(newPasswordLabel);
		_newPasswordPanel.add(_newPassword);
		_newPasswordPanel.add(repeatPasswordLabel);
		_newPasswordPanel.add(_repeatPassword);
		_newPasswordPanel.add(_changePassword);
		
		add(_errorLabel);
		add(_usernamePanel);
		add(_secretQuestionPanel);
		add(_newPasswordPanel);
		_newPasswordPanel.setVisible(false);
		
		configureFindSecretQuestionObserver();
		configureValidateQuestionObserver();
		configureChangePasswordObserver();
	}
	
	public ForgotPasswordView(String username) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		_newPasswordPanel = new JPanel();
		
		_errorLabel = new JLabel("");
		_newPassword = new JTextField(20);
		_repeatPassword = new JTextField(20);
		_changePassword = new JButton("Change Password");
		
		JLabel newPasswordHeader = new JLabel("Enter a new Password"),
				newPasswordLabel = new JLabel("New Password"),
				repeatPasswordLabel = new JLabel("Repeat Password");

		tempAccountName = username;
		
		_back = new JButton("Back");
		_newPasswordPanel.add(newPasswordHeader);
		_newPasswordPanel.add(newPasswordLabel);
		_newPasswordPanel.add(_newPassword);
		_newPasswordPanel.add(repeatPasswordLabel);
		_newPasswordPanel.add(_repeatPassword);
		_newPasswordPanel.add(_changePassword);
		
		add(_back);
		add(_errorLabel);
		add(_newPasswordPanel);
		
		configureChangePasswordObserver();
		configureBackButtonObserver();
	}
	
	private void configureFindSecretQuestionObserver() {
		_username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_secretQuestion.setText(Sys.sharedInstance().getSecretQuestion(_username.getText()));
				if(_secretQuestion.getText().equals(" ")) {
					_errorLabel.setText("Username not found");
				} else {
					_errorLabel.setText("");
				}
			}
		});
	}
	
	private void configureValidateQuestionObserver() {
		_validateAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Sys.sharedInstance().checkSecretQuestion(_username.getText(),_secretAnswer.getText())) {
					_errorLabel.setText("Secret Answer Confirmed!");
					_secretQuestionPanel.setVisible(false);
					_newPasswordPanel.setVisible(true);
				} else {
					_errorLabel.setText("Incorrect answer to secret question!");
				}
			}
		});
	}
	
	private void configureBackButtonObserver() {
		_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sys.sharedInstance().viewAccountScreen();
			}
		});
	}
	
	private void configureChangePasswordObserver() {
		_changePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Sys.sharedInstance().isLoggedIn()) {
					if(_newPassword.getText().equals(_repeatPassword.getText())) {
						Sys.sharedInstance().changePassword(tempAccountName,_repeatPassword.getText());
						Sys.sharedInstance().viewAccountScreen();
					} else {
						_errorLabel.setText("Error: these passwords do not match! Please try again.");
						_newPassword.setText("");
						_repeatPassword.setText("");
					}
				} else {
					if(_newPassword.getText().equals(_repeatPassword.getText())) {
						Sys.sharedInstance().changePassword(_username.getText(),_repeatPassword.getText());
						_errorLabel.setText("Password change accepted! Please log in to your account.");
						_newPassword.setText("");
						_repeatPassword.setText("");
					} else {
						_errorLabel.setText("Error: these passwords do not match! Please try again.");
						_newPassword.setText("");
						_repeatPassword.setText("");
					}
				}
			}
		});
	}
}
