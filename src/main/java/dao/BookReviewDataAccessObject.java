package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.BookBean;
import beans.BookReviewBean;
import beans.UserBean;
import beans.VisitEventBean;
import models.BookReviews;
import models.Visits;

/**
 * BookReviewDataAccessObject interfaces with the database to create Beans from books_review
 * queries.
 * 
 * @author Skyler Layne on Feb 17, 2016
 *
 */
public class BookReviewDataAccessObject extends DataAccessObject {

  public BookReviewDataAccessObject() {
    super();
    this.setTableName("book_review");
  }

  /**
   * Get the PoItemBean from the passed result set.
   * 
   * @param rs
   *          - the result of the query.
   * @return - a list of the PoItemBean that are found from the query.
   */
  private BookReviews get(ResultSet rs) {
    BookReviews reviews = new BookReviews();

    try {
      this.getCon().setReadOnly(true);

      while (rs.next()) {

        int id = rs.getInt("id");
        int userid = rs.getInt("userid");
        String bid = rs.getString("bid");
        String review = rs.getString("review");

        UserBean user = (new UserDataAccessObject()).findByUserid("" + userid).get(0);
        BookBean book = null;
        book = (new BookDataAccessObject()).findAll().getBooks().stream()
            .filter(b -> b.getBid().equals(bid)).findFirst().get();

        reviews.add(new BookReviewBean(id, user, book, review));
      }

      rs.close();
      this.getStmt().close();
      close();
      return reviews;

    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return new BookReviews();
    }
  }

  /**
   * Get all the PoItemBean in the objects.
   * 
   * @return - A list of all the PoItemBean.
   */
  public BookReviews findAll() {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery(this.getAllQuery());
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getErrorCode() + "");
      return new BookReviews();
    }
  }

  public boolean insert(BookReviewBean bean) {
    return false;
  }

  public boolean update(BookReviewBean bean) {
    return false;
  }

  public boolean delete(BookReviewBean bean) {
    return false;
  }

  /**
   * Find the list of reviews for a specific book.
   * 
   * @param bid
   *          - the desired book id.
   * @return - a model instance of the reviews.
   */
  public BookReviews findByBookId(String bid) {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where bid='" + bid + "';");
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getErrorCode() + "");
      return new BookReviews();
    }
  }

}
