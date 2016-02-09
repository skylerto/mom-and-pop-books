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
	private POBean po;
	private BookBean book;

	public POItemBean(int id, String bid, double price, POBean po, BookBean book) {
		this.id = id;
		this.bid = bid;
		this.price = price;
		this.po = po;
		this.book = book;
	}

	@Override
	public String toString() {
		return "POItem: [" + this.id + ", " + this.bid + ", " + this.price + ", " + this.po + ", " + this.book + "]";
	}

	public POBean getPO() {
		return po;
	}

	public void setPO(POBean pO) {
		po = pO;
	}

	public BookBean getBook() {
		return book;
	}

	public void setBook(BookBean book) {
		this.book = book;
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
}
