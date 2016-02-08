package beans;

/**
 * 
 * @author Skyler Layne on Jan 8, 2016
 * @version 0.0.2
 *
 */
public class BookBean {

	private String bid;
	private String title;
	private double price;
	private String category;

	public BookBean(String bid, String title, double price, String category) {
		this.bid = bid;
		this.title = title;
		this.price = price;
		this.category = category;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book: [" + this.bid + ", " + this.title + ", $" + this.price + ", " + this.category + "]";
	}
}
