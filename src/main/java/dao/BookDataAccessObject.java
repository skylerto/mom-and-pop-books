package dao;

import beans.BookBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    this.setTableName("Book");
  }

  /**
   * Get the Book Bean from the passed result set.
   * 
   * @param rs
   *          - the result of the query.
   * @return - a list of the book Beans that are found from the query.
   */
  private List<BookBean> get(ResultSet rs) {
    List<BookBean> books = new ArrayList<>();
    try {
      this.getCon().setReadOnly(true);
      while (rs.next()) {
        String bid = rs.getString("bid");
        String title = rs.getString("title");
        int price = rs.getInt("price");
        String category = rs.getString("category");
        books.add(new BookBean(bid, title, price, category));
      }
      rs.close();
      this.getStmt().close();
      close();
      return books;

    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return new ArrayList<>();
    }
  }

  /**
   * Get all the Book Beans in the objects.
   * 
   * @return - A list of all the book beans.
   */
  public List<BookBean> findAll() {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery(this.getAllQuery());
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      e.getStackTrace();
      return new ArrayList<>();
    }
  }

  /**
   * Get the book beans with the registered id.
   * 
   * @param id
   *          - the id to look for.
   * @return - a list of book beans with that id.
   */
  public List<BookBean> findById(String id) {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where bid='" + id + "';");
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getErrorCode() + "");
      return new ArrayList<>();
    }
  }

  /**
   * Get the book beans with the given title.
   * 
   * @param title
   *          - the title to query.
   * @return - a list of the book beans with that title.
   */
  public List<BookBean> findByTitle(String title) {
    try {
      createConnection();
      ResultSet rs = this.getStmt()
          .executeQuery(this.getAllQuery() + " where title='" + title + "';");
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getErrorCode() + "");
      return new ArrayList<>();
    }
  }

  public boolean insert(BookBean book) {

    return false;
  }

  public boolean update(BookBean book) {
    return false;
  }

  public boolean delete(BookBean book) {
    return false;
  }
}
