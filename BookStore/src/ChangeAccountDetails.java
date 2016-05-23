import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ChangeAccountDetails extends JPanel {
	JLabel _headerLabel;
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
		_headerLabel = new JLabel("Change Account Details");
		_firstNameLabel = new JLabel("First Name");
		_lastNameLabel = new JLabel("Last Name");
		_emailLabel = new JLabel("Email");
		_secretQuestionLabel = new JLabel("Secret Question");
		_secretAnswerLabel = new JLabel("Secret Answer");
		
		_firstName = new JTextField(20);
		_lastName = new JTextField(20);
		_email = new JTextField(20);
		_secretQuestion = new JComboBox<String>();
		_secretQuestion.addItem("What was the name of your first pet?");
		_secretQuestion.addItem("What is your mother's maiden name?");
		_secretQuestion.addItem("What is your favorite song?");
		_secretAnswer = new JTextField(20);
		_back = new JButton("Back");
		_submit = new JButton("Submit");
		
		add(_back);
		add(_headerLabel);
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
				System.out.println("Actually change account stuff");
				Sys.sharedInstance().viewAccountScreen();
			}
		});
	}
}
