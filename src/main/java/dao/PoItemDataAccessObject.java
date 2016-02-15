package dao;

import beans.BookBean;
import beans.Books;
import beans.PoBean;
import beans.PoItemBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Skyler Layne on Feb 8, 2016.
 *
 */
public class PoItemDataAccessObject extends DataAccessObject {

  public PoItemDataAccessObject() {
    super();
    this.setTableName("POItem");
  }

  /**
   * Get the PoItemBean from the passed result set.
   * 
   * @param rs
   *          - the result of the query.
   * @return - a list of the PoItemBean that are found from the query.
   */
  private List<PoItemBean> get(ResultSet rs) {
    List<PoItemBean> poItems = new ArrayList<>();

    try {
      this.getCon().setReadOnly(true);

      while (rs.next()) {

        int id = rs.getInt("id");
        String bid = rs.getString("bid");
        int price = rs.getInt("price");
        PoBean po = (new PoDataAccessObject()).findById("" + id).get(id - 1);
        Books list = (new BookDataAccessObject()).findById(bid);
        BookBean book = null;
        book = list.getBooks().stream().filter(b -> b.getBid().equals(bid)).findFirst().get();

        poItems.add(new PoItemBean(id, bid, price, po, book));
      }

      rs.close();
      this.getStmt().close();
      close();
      return poItems;

    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return new ArrayList<>();
    }
  }

  /**
   * Get all the PoItemBean in the objects.
   * 
   * @return - A list of all the PoItemBean.
   */
  public List<PoItemBean> findAll() {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery(this.getAllQuery());
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getErrorCode() + "");
      return new ArrayList<>();
    }
  }

  /**
   * Get the PoItemBean with the registered id.
   * 
   * @param id
   *          - the id to look for.
   * @return - a list of PoItemBean with that id.
   */
  public List<PoItemBean> findById(String id) {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where id='" + id + "';");
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getErrorCode() + "");
      return new ArrayList<>();
    }
  }

  public boolean insert(PoItemBean poitem) {
    return false;
  }

  public boolean update(PoItemBean poitem) {
    return false;
  }

  public boolean delete(PoItemBean poitem) {
    return false;
  }
}
