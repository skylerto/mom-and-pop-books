package beans;

import java.util.ArrayList;
import java.util.List;

/**
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
   * Default constructor, creates a new empty cart.
   */
  public CartBean() {
    this.books = new ArrayList<>();
  }

  /**
   * Add a book to the cart, set a max cart limit of 50.
   * 
   * @return - if the addition worked.
   */
  public boolean add(BookBean book) {
    if (this.books.size() >= 50) {
      return false;
    } else {
      return this.books.add(book);
    }
  }

  /**
   * Get the items in the cart as a list.
   * 
   * @return - The books in the cart.
   */
  public List<BookBean> get() {
    return this.books;
  }

  /**
   * Get the current size of the cart.
   * 
   * @return - The current cart.
   */
  public int size() {
    return this.books.size();
  }

  /**
   * Get the book with the specified bid.
   * 
   * @param bid
   *          - the bid of the book you would like.
   * @return - The book with the specified bid.
   * 
   */
  public BookBean getBook(String bid) {
    for (BookBean b : books) {
      if (b.getBid().equals(bid)) {
        return b;
      }
    }
    return null;
  }

}
