package dao;

import java.sql.PreparedStatement;
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

  /**
   * Add a book review.
   * 
   * @param bean
   *          - the review to add.
   * @return - if the review was added or not.
   */
  public boolean insert(BookReviewBean bean) {
    this.createConnection();
    PreparedStatement pstmt = null;
    String insert = "INSERT INTO " + this.getTableName() + " (id, userid, bid, review) VALUES"
        + "(?,?,?,?)";
    try {
      pstmt = this.getCon().prepareStatement(insert);
      pstmt.setInt(1, bean.getId());
      pstmt.setInt(2, bean.getUser().getUserId());
      pstmt.setString(3, bean.getBook().getBid());
      pstmt.setString(4, bean.getReview());
      pstmt.executeUpdate();
      pstmt.close();
      close();
      return true;
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return false;
    }
  }

  /**
   * Update a review in the database.
   * 
   * @param bean
   *          - the review to be updated.
   * @return - if the review was updated or not.
   */
  public boolean update(BookReviewBean bean) {
    this.createConnection();
    PreparedStatement pstmt = null;
    String insert = "UPDATE " + this.getTableName() + " userid=?, bid=?, review=? where id="
        + bean.getId();
    try {
      pstmt = this.getCon().prepareStatement(insert);
      pstmt.setInt(1, bean.getUser().getUserId());
      pstmt.setString(2, bean.getBook().getBid());
      pstmt.setString(3, bean.getReview());
      pstmt.executeUpdate();
      pstmt.close();
      close();
      return true;
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return false;
    }
  }

  public boolean delete(BookReviewBean bean) {
    this.createConnection();
    PreparedStatement pstmt = null;
    String insert = "DELETE " + this.getTableName() + " where id=" + bean.getId();
    try {
      pstmt = this.getCon().prepareStatement(insert);
      pstmt.executeUpdate();
      pstmt.close();
      close();
      return true;
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return false;
    }
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
