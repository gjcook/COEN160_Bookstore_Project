import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ChangeAccountDetails extends JPanel {
	JLabel _headerLabel;
	JLabel _errorLabel;
	JLabel _firstNameLabel;
	JTextField _firstName;
	JLabel _lastNameLabel;
	JTextField _lastName;
	JLabel _emailLabel;
	JTextField _email;
	JLabel _secretQuestionLabel;
	JComboBox<String> _secretQuestion;
	JLabel _secretAnswerLabel;
	JTextField _secretAnswer;

	JButton _back;
	JButton _submit;
	
	public ChangeAccountDetails() {
		Account _acc = Sys.sharedInstance().getUser();
		_headerLabel = new JLabel("Change Account Details");
		_errorLabel = new JLabel("");
		_firstNameLabel = new JLabel("First Name");
		_lastNameLabel = new JLabel("Last Name");
		_emailLabel = new JLabel("Email");
		_secretQuestionLabel = new JLabel("Secret Question");
		_secretAnswerLabel = new JLabel("Secret Answer");
		
		_firstName = new JTextField(_acc.getFirstName());
		_lastName = new JTextField(_acc.getLastName());
		_email = new JTextField(_acc.getEmail());
		_secretQuestion = new JComboBox<String>();
		_secretQuestion.addItem("What was the name of your first pet?");
		_secretQuestion.addItem("What is your mother's maiden name?");
		_secretQuestion.addItem("What is your favorite song?");
		if(_acc.getSecretQuestion().equals("What was the name of your first pet?")) {
			_secretQuestion.setSelectedIndex(0);
		} else if(_acc.getSecretQuestion().equals("What is your mother's maiden name?")) {
			_secretQuestion.setSelectedIndex(1);
		} else {
			_secretQuestion.setSelectedIndex(2);
		}
		
		_secretAnswer = new JTextField(_acc.getSecretAnswer());
		_back = new JButton("Back");
		_submit = new JButton("Submit");
		
		add(_back);
		add(_headerLabel);
		add(_errorLabel);
		add(_firstNameLabel);
		add(_firstName);
		add(_lastNameLabel);
		add(_lastName);
		add(_emailLabel);
		add(_email);
		add(_secretQuestionLabel);
		add(_secretQuestion);
		add(_secretAnswerLabel);
		add(_secretAnswer);
		add(_submit);
		
		setPreferredSize(new Dimension(400,600));
		
		configureBackButtonObserver();
		configureSubmitObserver();
	}
	
	private void configureBackButtonObserver() {
		_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sys.sharedInstance().viewAccountScreen();
			}
		});
	}
	
	private void configureSubmitObserver() {
		_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(_firstName.getText().length() < 3 || _firstName.getText().length() > 20) {
					_errorLabel.setText("First Name must be between 3 and 20 characters");
				} else if(_lastName.getText().length() < 3 || _lastName.getText().length() > 20) {
					_errorLabel.setText("Last Name must be between 3 and 20 characters");
				} else if(_email.getText().length() < 3 || _email.getText().length() > 20) {
					_errorLabel.setText("Email must be between 3 and 20 characters");
				} else if(_secretAnswer.getText().length() < 3 || _secretAnswer.getText().length() > 20) {
					_errorLabel.setText("Secret Answer must be between 3 and 20 characters");
				} else {
					Sys.sharedInstance().changeAccountDetails(_firstName.getText(), _lastName.getText(), _email.getText(), (String)_secretQuestion.getSelectedItem(), _secretAnswer.getText());
					Sys.sharedInstance().viewAccountScreen();
				}
			}
		});
	}
}
