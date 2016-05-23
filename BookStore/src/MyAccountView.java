import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;

public class MyAccountView extends JPanel {
	JButton _recentOrders;
	JButton _changePassword;
	JButton _changeAccountDetails;
	Account _acc;
	
	public MyAccountView() {
		_acc = Sys.sharedInstance().getUser();
		JLabel myAccount = new JLabel("My Account");
		JLabel name = new JLabel("Welcome, " + _acc.getName());
		
		_recentOrders = new JButton("View Recent Orders");
		_changePassword = new JButton("Change Password");
		_changeAccountDetails = new JButton("Change Account Details");
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(myAccount);
		add(name);
		add(_recentOrders);
		add(_changePassword);
		add(_changeAccountDetails);
		
		configureRecentOrderObserver();
		configureChangePasswordObserver();
		configureChangeAccountDetails();
	}
	
	private void configureRecentOrderObserver() {
		_recentOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sys.sharedInstance().viewRecentOrders();
			}
		});
	}
	
	private void configureChangePasswordObserver() {
		_changePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sys.sharedInstance().changePassword();
			}
		});
	}
	
	private void configureChangeAccountDetails() {
		_changeAccountDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Sys.sharedInstance().viewAccountScreen();
			}
		});
	}
}
