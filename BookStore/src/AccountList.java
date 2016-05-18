import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.System;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

public class AccountList {
	private List<Account> _accountList;
	
	public AccountList(String filePath) { 
		_accountList = new ArrayList<Account>(); 
		
		if(filePath != "") {
		    Scanner sc;
		    String tempStr, tempStrArray[];
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
		for(Account acc : _accountList) {
			if(username.equals(acc.getID())) {
				return acc;
			}
		}
		
		return null;
	}
	
	public List<Account> getAllAccounts() {
		return _accountList;
	}
	
	public void saveData(String filePath){
		File _old = new File(System.getProperty("user.dir") + "//src//" + filePath);
		File _bak = new File(System.getProperty("user.dir") + "//src//" + filePath + ".bak");
		
		_old.renameTo(_bak);
		_old = null;
		
		Path _new = Paths.get(System.getProperty("user.dir") + "//src//" + filePath);
		
		try {
			Files.write(_new, _accountList, Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String toString() {
		String ret = "";
		
		for(Account d : _accountList) {
			ret += (d.toString() + "\n\n");
		}
		
		return ret;
	}
}
