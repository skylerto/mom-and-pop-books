package beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import models.BookReviews;

/**
 * 
 * @author Skyler Layne on Jan 8, 2016
 * @version 0.0.2
 *
 */
@XmlRootElement(name = "book")
public class BookBean {

  private String bid;
  private String title;
  private double price;
  private String category;

  /**
   * Constructor of a book bean.
   * 
   * @param bid
   *          - the primary key of the book.
   * @param title
   *          - the title of the book.
   * @param price
   *          - the price of the book.
   * @param category
   *          - the category which the book is in.
   */
  public BookBean(String bid, String title, double price, String category) {
    this.bid = bid;
    this.title = title;
    this.price = price;
    this.category = category;
  }

  public BookBean() {

  }

  /**
   * Get the book id.
   * 
   * @return - the id.
   */
  public String getBid() {
    return bid;
  }

  /**
   * Set the book id
   * 
   * @param bid
   *          - the new id.
   */
  @XmlElement
  public void setBid(String bid) {
    this.bid = bid;
  }

  /**
   * Get the title of the book.
   * 
   * @return - the books title.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Change the title of the book.
   * 
   * @param title
   *          - the new title.
   */
  @XmlElement
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Get the price of the book.
   * 
   * @return - the books price.
   */
  public double getPrice() {
    return price;
  }

  /**
   * Change the books price.
   * 
   * @param price
   *          - the new price.
   */
  @XmlElement
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * Get the books category.
   * 
   * @return - the category.
   */
  public String getCategory() {
    return category;
  }

  /**
   * Change the books category.
   * 
   * @param category
   *          - the new category.
   */
  @XmlElement
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * A String representation of the book.
   */
  @Override
  public String toString() {
    return "Book: [" + this.bid + ", " + this.title + ", $" + this.price + ", " + this.category
        + "]";
  }
}
