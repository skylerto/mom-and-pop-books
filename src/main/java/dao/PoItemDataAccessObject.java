package dao;

import beans.BookBean;
import beans.PoBean;
import beans.PoItemBean;
import models.Books;
import models.PoItems;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Skyler Layne on Feb 8, 2016.
 *
 */
public class PoItemDataAccessObject extends DataAccessObject {

  public PoItemDataAccessObject() {
    super();
    this.setTableName("poitem");
  }

  /**
   * Get the PoItemBean from the passed result set.
   *
   * @param rs
   *          - the result of the query.
   * @return - a list of the PoItemBean that are found from the query.
   */
  private PoItems get(ResultSet rs) {
    PoItems poItems = new PoItems();

    try {
      this.getCon().setReadOnly(true);

      while (rs.next()) {

        int id = rs.getInt("id");
        String bid = rs.getString("bid");
        int price = rs.getInt("price");
        PoBean po = (new PoDataAccessObject()).findById("" + id).get(0);
        Books list = (new BookDataAccessObject()).findById(bid);
        BookBean book = null;
        book = list.getBooks().stream().filter(b -> b.getBid().equals(bid)).findFirst().get();

        poItems.add(new PoItemBean(id, price, po, book));
      }

      rs.close();
      this.getStmt().close();
      close();
      return poItems;

    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return new PoItems();
    }
  }

  /**
   * Get all the PoItemBean in the objects.
   *
   * @return - A list of all the PoItemBean.
   */
  public PoItems findAll() {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery(this.getAllQuery());
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getErrorCode() + "");
      return new PoItems();
    }
  }

  /**
   * Get the PoItemBean with the registered id.
   *
   * @param id
   *          - the id to look for.
   * @return - a list of PoItemBean with that id.
   */
  public PoItems findById(String id) {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where id='" + id + "';");
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getErrorCode() + "");
      return new PoItems();
    }
  }

  /**
   * Insert poitem into the database.
   * 
   * @param poitem
   *          - item to be inserted.
   * @return - if the insert worked or not.
   */
  public boolean insert(PoItemBean poitem) {
    this.createConnection();
    PreparedStatement pstmt = null;
    String insert = "INSERT INTO " + this.getTableName() + " (id, bid, price) VALUES" + "(?,?,?);";
    try {
      pstmt = this.getCon().prepareStatement(insert);
      pstmt.setInt(1, poitem.getId());
      pstmt.setString(2, poitem.getBook().getBid());
      pstmt.setDouble(3, poitem.getPrice());
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
   * Update poitem into the database.
   * 
   * @param poitem
   *          - item to be iupdated.
   * @return - if the update worked or not.
   */
  public boolean update(PoItemBean poitem) {
    this.createConnection();
    PreparedStatement pstmt = null;
    String insert = "UPDATE " + this.getTableName() + " SET bid=?, price=? where id="
        + poitem.getId();
    try {
      pstmt = this.getCon().prepareStatement(insert);
      pstmt.setString(1, poitem.getBook().getBid());
      pstmt.setDouble(2, poitem.getPrice());
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
   * Delete poitem into the database.
   * 
   * @param poitem
   *          - item to be deleted.
   * @return - if the delete worked or not.
   */
  public boolean delete(PoItemBean poitem) {
    this.createConnection();
    PreparedStatement pstmt = null;
    String insert = "DELETE FROM " + this.getTableName() + " where id=" + poitem.getId();
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
