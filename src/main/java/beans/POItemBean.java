package beans;

public class POItemBean {

	private int id;
	private String bid;
	private int price;
	private int POID;
	private POBean PO;
	private String BookID;
	private BookBean book;

	public POItemBean(int id, String bid, int price, int pOID, String bookID, POBean PO, BookBean book) {
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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
