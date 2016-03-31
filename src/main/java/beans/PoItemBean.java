package beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import dao.PoItemDataAccessObject;

/**
 *
 * @author Skyler Layne on Feb 8, 2016
 *
 * @version 0.0.2
 */
@XmlRootElement(name = "poitem")
public class PoItemBean {

  private int id;
  private double price;
  private PoBean po;
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
  public PoItemBean(int id, double price, PoBean po, BookBean book) {
    this.id = id;
    this.price = price;
    this.po = po;
    this.book = book;
  }

  /**
   * Default Constructor
   */
  public PoItemBean() {

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
  @XmlElement(required = true)
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
  @XmlElement(required = true)
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
  @XmlElement(required = true)
  public void setId(int id) {
    this.id = id;
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
  @XmlElement(required = true)
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * String representation of the purchase order item.
   */
  @Override
  public String toString() {
    return "POItem: [" + this.id + ", " + this.price + ", " + this.po + ", " + this.book + "]";
  }

  /**
   * Insert or Update this record.
   * 
   * @return - if the save worked.
   */
  public boolean save() {
    PoItemDataAccessObject dao = new PoItemDataAccessObject();
    boolean res = false;
    if (dao.findById("" + id).size() > 0) {
      res = dao.update(this);
    } else {
      res = dao.insert(this);
    }
    return res;
  }

  /**
   * Delete this record.
   * 
   * @return - if the delete worked.
   */
  public boolean delete() {
    return (new PoItemDataAccessObject()).delete(this);
  }
}
