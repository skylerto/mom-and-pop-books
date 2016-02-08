package beans;

/**
 * 
 * @author Skyler Layne on Feb 8, 2016
 *
 */
public class POItemBean {

	private int id;
	private String bid;
	private double price;
	private int POID;
	private POBean PO;
	
	public POBean getPO() {
		return PO;
	}

	public void setPO(POBean pO) {
		PO = pO;
	}

	public BookBean getBook() {
		return book;
	}

	public void setBook(BookBean book) {
		this.book = book;
	}

	private String BookID;
	private BookBean book;

	public POItemBean(int id, String bid, double price, int pOID, String bookID, POBean PO, BookBean book) {
		this.id = id;
		this.bid = bid;
		this.price = price;
		this.POID = pOID;
		this.BookID = bookID;
		this.PO = PO;
		this.book = book;
	}

	@Override
	public String toString() {
		return "POItem: [" + this.id + ", " + this.bid + ", " + this.price + ", " + this.POID + ", " + this.BookID
				+ ", " + this.PO + ", " + this.book + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPOID() {
		return POID;
	}

	public void setPOID(int pOID) {
		POID = pOID;
	}

	public String getBookID() {
		return BookID;
	}

	public void setBookID(String bookID) {
		BookID = bookID;
	}

}
