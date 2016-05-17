import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.System;

public class Inventory {
	private List<Book> _bookList;
	
	public Inventory(String filePath) { 
		_bookList = new ArrayList<Book>(); 
		
		if(filePath != "") {
		    Scanner sc;
		    String tempStr, tempStrArray[];
		    try {
				sc = new Scanner(new FileReader(System.getProperty("user.dir") + "//src//" + filePath));
			    while (sc.hasNextLine()){
			        tempStr = sc.nextLine();
			        tempStrArray = tempStr.split("\t");
			        addBookToInventory(
			        		new Book(tempStrArray[0],
			        				tempStrArray[1],
			        				tempStrArray[2],
			        				Integer.parseInt(tempStrArray[3]),
			        				tempStrArray[4],
			        				tempStrArray[5],
			        				tempStrArray[6],
			        				Double.parseDouble(tempStrArray[7])
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
	
	public void addBookToInventory(Book newBook) {
		_bookList.add(newBook);
	}
	
	public void removeBookFromInventory(Book bookToRemove) {
		_bookList.remove(bookToRemove);
	}
	
	public List<Book> searchInventory(String queryTerm) {
		return null;
	}
	
	public List<Book> getAllBooks() {
		return _bookList;
	}
	
	public String toString() {
		String ret = "";
		
		for(Book d : _bookList) {
			ret += (d.toString() + "\n\n");
		}
		
		return ret;
	}
}
