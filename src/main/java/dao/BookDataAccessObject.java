package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BookBean;
import models.BookReviews;
import models.Books;

/**
 * BookDAO - Data Access Object for Book.
 * 
 * @author Skyler Layne on Jan 9, 2016
 * 
 * @version 0.1.0
 *
 */
public class BookDataAccessObject extends DataAccessObject {

  public BookDataAccessObject() {
    super();
    this.setTableName("book");
  }

  /**
   * Get the Book Bean from the passed result set.
   * 
   * @param rs
   *          - the result of the query.
   * @return - a list of the book Beans that are found from the query.
   */
  private Books get(ResultSet rs) {
    List<BookBean> books = new ArrayList<>();
    try {
      this.getCon().setReadOnly(true);
      while (rs.next()) {
        String bid = rs.getString("bid");
        String title = rs.getString("title");
        int price = rs.getInt("price");
        String category = rs.getString("category");
        BookReviews reviews = (new BookReviewDataAccessObject()).findByBookId(bid);
        books.add(new BookBean(bid, title, price, category, reviews));
      }
      rs.close();
      this.getStmt().close();
      close();
      return new Books(books);

    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return new Books();
    }
  }

  /**
   * Get all the Book Beans in the objects.
   * 
   * @return - A list of all the book beans.
   */
  public Books findAll() {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery(this.getAllQuery());
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      e.getStackTrace();
      return new Books();
    }
  }

  /**
   * Get the book beans with the registered id.
   * 
   * @param id
   *          - the id to look for.
   * @return - a list of book beans with that id.
   */
  public Books findById(String id) {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where bid='" + id + "';");
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getErrorCode() + "");
      return new Books();
    }
  }

  /**
   * Get the book beans with the given title.
   * 
   * @param title
   *          - the title to query.
   * @return - a list of the book beans with that title.
   */
  public Books findByTitle(String title) {
    try {
      createConnection();
      ResultSet rs = this.getStmt()
          .executeQuery(this.getAllQuery() + " where title='" + title + "';");
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getErrorCode() + "");
      return new Books();
    }
  }

  /**
   * Insert a book into the database.
   * 
   * @param book
   *          - the book to be inserted.
   * @return - if the book was inserted or not.
   */
  public boolean insert(BookBean book) {
    this.createConnection();
    PreparedStatement pstmt = null;
    String insert = "INSERT INTO " + this.getTableName() + " (bid, title, price, category) VALUES"
        + "(?,?,?,?);";
    try {
      pstmt = this.getCon().prepareStatement(insert);
      pstmt.setString(1, book.getBid());
      pstmt.setString(2, book.getTitle());
      pstmt.setDouble(3, book.getPrice());
      pstmt.setString(4, book.getCategory());
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
   * Update a book in the database.
   * 
   * @param book
   *          - the book to be updated.
   * @return - if the update was successful or not.
   */
  public boolean update(BookBean book) {
    this.createConnection();
    PreparedStatement pstmt = null;
    String insert = "UPDATE " + this.getTableName() + " title=?, price=?, category=? where bid="
        + book.getBid();
    try {
      pstmt = this.getCon().prepareStatement(insert);
      pstmt.setString(1, book.getTitle());
      pstmt.setDouble(2, book.getPrice());
      pstmt.setString(3, book.getCategory());
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
   * Delete a book from the database.
   * 
   * @param book
   *          - the book to be deleted.
   * @return - if the book deletion was successful.
   */
  public boolean delete(BookBean book) {
    this.createConnection();
    PreparedStatement pstmt = null;
    String insert = "DELETE " + this.getTableName() + " where bid=" + book.getBid();
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
}
