
public class Book {
	private String _title;
	private String _author;
	private String _description;
	private int _pages;
	private String _publicationDate;
	private String _publisher;
	private String _pathToImage;
	private double _price;
	
	public Book(
			String title,
			String author,
			String description,
			int pages,
			String publicationDate,
			String publisher, 
			String pathToImage,
			double price) {
		_title = title;
		_author = author;
		_description = description;
		_pages = pages;
		_publicationDate = publicationDate;
		_publisher = publisher;
		_pathToImage = pathToImage;
		_price = price;
	}
	
	public String getTitle() { return _title; }
	
	public String getAuthor() { return _author; }
	
	public String getDescription() { return _description; }
	
	public int getPages() { return _pages; }
	
	public String getPublicationDate() { return _publicationDate; }
	
	public String getPublisher() { return _publisher; }
	
	public String getImagePath() { return _pathToImage; }
	
	public double getPrice() { return _price; }
	
	public String toString() {
		return  "title:\t\t\t" + _title + "\n" +
				"author:\t\t\t" + _author + "\n" +
				"description:\t\t" + _description +"\n" +
				"pages:\t\t\t" + _pages + "\n" +
				"publication date:\t" + _publicationDate + "\n" +
				"publisher:\t\t" + _publisher + "\n" +
				"pathToImage:\t\t" + _pathToImage + "\n" +
				"price:\t\t\t" + _price;
	}
}
