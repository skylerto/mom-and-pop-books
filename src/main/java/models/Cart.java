package models;

import java.util.Optional;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import beans.BookBean;

/**
 * Bean data structure of what a cart should look like.
 * 
 * @author Skyler Layne on Feb 9, 2016
 * 
 * @version 0.0.1
 *
 */
@XmlRootElement(name = "cart")
public class Cart {

  private Books books;

  /**
   * Default constructor, creates a new empty cart.
   */
  public Cart() {
    this.books = new Books();
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

  public Books get() {
    return this.books;
  }

  /**
   * Set the carts list of books.
   * 
   * @param books
   *          - The carts new list of books
   */
  @XmlAttribute
  public void setBooks(Books books) {
    this.books = books;
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
    Optional<BookBean> o = this.books.getBooks().stream().filter(book -> book.getBid() == (bid))
        .findFirst();
    if (o.isPresent()) {
      return o.get();
    } else {
      return null;
    }
  }

  public double getSum() {
    double val = 0;
    for (BookBean b : this.books.getBooks()) {
      val += b.getPrice();
    }
    return val;
  }
}
