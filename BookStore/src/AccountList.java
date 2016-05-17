import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.System;

public class AccountList {
	private List<Account> _accountList;
	
	public AccountList(String filePath) { 
		_accountList = new ArrayList<Account>(); 
		
		if(filePath != "") {
		    Scanner sc;
		    String tempStr, tempStrArray[], orderTempStr, orderTempStrArray[];
		    try {
				sc = new Scanner(new FileReader(System.getProperty("user.dir") + "//src//" + filePath));
			    while (sc.hasNextLine()){
			        tempStr = sc.nextLine();
			        tempStrArray = tempStr.split("\t");
			        
			        List<Order> tempOrderList = new ArrayList<Order>();
			        for(int i = 7; i < tempStrArray.length; i++) {
			        	tempOrderList.add(new Order(tempStrArray[i]));
			        }
			        
			        addAccountToList(
			        		new Account(
			        				tempStrArray[0],
			        				tempStrArray[1],
			        				tempStrArray[2],
			        				tempStrArray[3],
			        				tempStrArray[4],
			        				tempStrArray[5],
			        				tempStrArray[6],
			        				tempOrderList
			        		)
			        );
			    }
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("File not found: " + filePath);
				e.printStackTrace();
			}

		}
	}
	
	public void addAccountToList(Account newAccount) {
		_accountList.add(newAccount);
	}
	
	public void removeAccountFromList(Account accountToRemove) {
		_accountList.remove(accountToRemove);
	}
	
	public Account lookupUsername(String username) {
		return null;
	}
	
	public List<Account> getAllAccounts() {
		return _accountList;
	}
	
	public String toString() {
		String ret = "";
		
		for(Account d : _accountList) {
			ret += (d.toString() + "\n\n");
		}
		
		return ret;
	}
	
	public static void main(String args[]) {
		AccountList list = new AccountList("accList.txt");
		
		System.out.println("printing inv:");
		System.out.println(list.toString());
		
	}
}
