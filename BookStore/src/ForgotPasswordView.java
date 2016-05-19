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
		_changePassword = new JButton("Forgot Password?");
		
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
	
	private void configureFindSecretQuestionObserver() {
		_username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_secretAnswer.setText(Sys.sharedInstance().getSecretQuestion(_username.getText()));
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
					
				}
			}
		});
	}
	
	private void configureChangePasswordObserver() {
		_changePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(_newPassword.getText().equals(_repeatPassword.getText())) {
					
				} else {
					
				}
			}
		});
	}
}
