package beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Bean data structure of what a cart should look like.
 * 
 * @author Skyler Layne on Feb 9, 2016
 * 
 * @version 0.0.1
 *
 */
public class CartBean {

	private List<BookBean> books;

	/**
	 * Default constructor, creates a new empty cart
	 */
	public CartBean() {
		this.books = new ArrayList<>();
	}

	/**
	 * Add a book to the cart.
	 * 
	 * @return - if the addition worked
	 */
	public boolean addToCart(BookBean book) {
		return this.books.add(book);
	}

}
