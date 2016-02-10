package dao;

import beans.AddressBean;
import beans.PoBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Skyler Layne on Feb 8, 2016
 *
 * @version 0.1.0
 */
public class PoDataAccessObject extends DataAccessObject {

  public PoDataAccessObject() {
    super();
    this.setTableName("PO");
  }

  /**
   * Get the Po Bean from the passed result set.
   * 
   * @param rs
   *          - the result of the query.
   * @return - a list of the Po Beans that are found from the query.
   */
  public List<PoBean> get(ResultSet rs) {
    List<PoBean> addresses = new ArrayList<>();

    try {
      this.getCon().setReadOnly(true);

      while (rs.next()) {
        int id = rs.getInt("id");
        String lname = rs.getString("lname");
        String fname = rs.getString("fname");
        String status = rs.getString("status");
        int addressId = rs.getInt("address");

        AddressBean address = (new AddressDataAccessObject()).findById("" + addressId)
            .get(addressId - 1);
        addresses.add(new PoBean(id, lname, fname, status, address));
      }

      rs.close();
      this.getStmt().close();
      close();
      return addresses;

    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      e.getStackTrace();
      return new ArrayList<>();
    }
  }

  /**
   * Get all the po Beans in the objects.
   * 
   * @return - A list of all the po beans.
   */
  public List<PoBean> findAll() {
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
   * Get the po beans with the registered id.
   * 
   * @param id
   *          - the id to look for.
   * @return - a list of po beans with that id.
   */
  public List<PoBean> findById(String id) {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where id='" + id + "';");
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      e.getStackTrace();
      return new ArrayList<>();
    }
  }

  public boolean insert(PoBean address) {
    return false;
  }

  public boolean update(PoBean address) {
    return false;
  }

  public boolean delete(PoBean address) {
    return false;
  }
}
