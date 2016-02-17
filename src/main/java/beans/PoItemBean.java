package beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Skyler Layne on Feb 8, 2016
 *
 * @version 0.0.2
 */
@XmlRootElement(name = "POItem")
public class PoItemBean {

  @XmlElement(required = true)
  private int id;

  @XmlElement(required = true)
  private String bid;

  @XmlElement(required = true)
  private double price;

  @XmlElement(required = true)
  private PoBean po;

  @XmlElement(required = true)
  private BookBean book;

  /**
   * A purchase order item bean.
   * 
   * @param id
   *          - the id of the purchase order item.
   * @param bid
   *          - the id of the book registered to the purchase order item.
   * @param price
   *          - the price of the book registered to the purchase order item.
   * @param po
   *          - the purchase order registered to the purchase order item.
   * @param book
   *          - the book registered to the purchase order item.
   */
  public PoItemBean(int id, String bid, double price, PoBean po, BookBean book) {
    this.id = id;
    this.bid = bid;
    this.price = price;
    this.po = po;
    this.book = book;
  }

  /**
   * Get the purchase order which the item is registered to.
   * 
   * @return - the purchase order.
   */
  public PoBean getPo() {
    return po;
  }

  /**
   * Set the purchase order which the item is registered to.
   * 
   * @param po
   *          - the new purchase order.
   */
  public void setPo(PoBean po) {
    this.po = po;
  }

  /**
   * Get the book registered on the purchase order item.
   * 
   * @return - the book.
   */
  public BookBean getBook() {
    return book;
  }

  /**
   * Set the book registered on the purchase order item.
   * 
   * @param book
   *          - the new book.
   */
  public void setBook(BookBean book) {
    this.book = book;
  }

  /**
   * Get the primary key of the purchase order item.
   * 
   * @return - the id.
   */
  public int getId() {
    return id;
  }

  /**
   * Change the primary key of the purchase order item.
   * 
   * @param id
   *          - the new id.
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Get the book id registered on the purchase order item.
   * 
   * @return - the book id.
   */
  public String getBid() {
    return bid;
  }

  /**
   * Set the book id registered on the purchase order item
   * 
   * @param bid
   *          - the new book id.
   */
  public void setBid(String bid) {
    this.bid = bid;
  }

  /**
   * Get the price of the purchase order item.
   * 
   * @return - the price.
   */
  public double getPrice() {
    return price;
  }

  /**
   * Set the price of the purchase order item.
   * 
   * @param price
   *          - the new price.
   */
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * String representation of the purchase order item.
   */
  @Override
  public String toString() {
    return "POItem: [" + this.id + ", " + this.bid + ", " + this.price + ", " + this.po + ", "
        + this.book + "]";
  }
}
