package beans;

/**
 * Beans of Books and Reviews.
 * 
 * @author Skyler Layne on Mar 30, 2016
 *
 */
public class BookReviewBean {

  private int id;
  private UserBean user;
  private BookBean book;

  /**
   * Create a new Book Review Been.
   * 
   * @param id
   *          - the id of the bean.
   * @param user
   *          - the User associated with the review, might be NULL.
   * @param book
   *          - The book which the review is associated with.
   */
  public BookReviewBean(int id, UserBean user, BookBean book) {
    this.id = id;
    this.user = user;
    this.book = book;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public UserBean getUser() {
    return user;
  }

  public void setUser(UserBean user) {
    this.user = user;
  }

  public BookBean getBook() {
    return book;
  }

  public void setBook(BookBean book) {
    this.book = book;
  }

}
