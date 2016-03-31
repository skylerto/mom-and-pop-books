package beans;

import javax.xml.bind.annotation.XmlElement;

import dao.BookReviewDataAccessObject;

/**
 * Beans of Books and Reviews.
 * 
 * @author Skyler Layne on Mar 30, 2016
 *
 */
public class BookReviewBean {

  private int id;
  private UserBean user;
  private String bid;
  private String review;

  /**
   * Create a new Book Review Been.
   * 
   * @param id
   *          - the id of the bean.
   * @param user
   *          - the User associated with the review, might be NULL.
   * @param bid
   *          - The book which the review is associated with.
   * @param review
   *          - The review detail text
   */
  public BookReviewBean(int id, UserBean user, String bid, String review) {
    this.id = id;
    this.user = user;
    this.bid = bid;
    this.review = review;
  }

  public int getId() {
    return id;
  }

  @XmlElement
  public void setId(int id) {
    this.id = id;
  }

  public UserBean getUser() {
    return user;
  }

  @XmlElement
  public void setUser(UserBean user) {
    this.user = user;
  }

  public String getBid() {
    return this.bid;
  }

  @XmlElement
  public void setBid(String bid) {
    this.bid = bid;
  }

  public String getReview() {
    return this.review;
  }

  @XmlElement
  public void setReview(String review) {
    this.review = review;
  }

  /**
   * Insert or Update this record.
   * 
   * @return - of the save worked.
   */
  public boolean save() {
    BookReviewDataAccessObject dao = new BookReviewDataAccessObject();
    boolean res = false;
    if (dao.findByBookId(this.getBid()).size() > 0) {
      res = dao.update(this);
    } else {
      res = dao.insert(this);
    }
    return res;
  }

  /**
   * Delete this record.
   * 
   * @return - if the delete worked or not.
   */
  public boolean delete() {
    return (new BookReviewDataAccessObject()).delete(this);
  }
}
