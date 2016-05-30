import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.List;
import java.awt.FlowLayout;
import java.util.ArrayList;

public class ViewPanel extends JPanel {
	JLabel _header;
	public ViewPanel(String query) {
		super();
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		_header = new JLabel("");
		add(_header);
		displayResults(search(query), query);
	}
	
	/**
	 *  This is so bad. Try to fix this up later. The actual search portion (for(Book b : bookList) {...} needs work)
	 */
	private List<Book> search(String query) {
		List<Book> bookList = Sys.sharedInstance().getBooks();
		if(query.equals("")) {
			_header.setText("Book Catalog");
			return bookList;
		}
		
		List<Book> ret = new ArrayList<Book>();
		
		for(Book b : bookList) {
			if(b.getTitle().contains(query)) ret.add(b);
			else if(b.getAuthor().contains(query)) ret.add(b);
			else if(b.getDescription().contains(query)) ret.add(b);
			else if(b.getPublisher().contains(query)) ret.add(b);
		}
		
		_header.setText("Search for: " + query);
		
		return ret;
	}
	
	private void displayResults(List<Book> results, String query) {
		for(Book b : results) {
			add(new CondensedBookPanel(b, query));
		}
		setPreferredSize(new Dimension(400,125*results.size()));
	}
}
