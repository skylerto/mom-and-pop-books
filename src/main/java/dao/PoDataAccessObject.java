package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.AddressBean;
import beans.PoBean;
import models.Pos;

/**
 * 
 * @author Skyler Layne on Feb 8, 2016
 *
 * @version 0.1.0
 */
public class PoDataAccessObject extends DataAccessObject {

  public PoDataAccessObject() {
    super();
    this.setTableName("po");
  }

  /**
   * Get the Po Bean from the passed result set.
   * 
   * @param rs
   *          - the result of the query.
   * @return - a list of the Po Beans that are found from the query.
   */
  public Pos get(ResultSet rs) {
    Pos pos = new Pos();

    try {
      this.getCon().setReadOnly(true);

      while (rs.next()) {
        int id = rs.getInt("id");
        String lname = rs.getString("lname");
        String fname = rs.getString("fname");
        String status = rs.getString("status");
        int addressId = rs.getInt("address");

        AddressBean address = (new AddressDataAccessObject()).findById("" + addressId).get(0);
        pos.add(new PoBean(id, lname, fname, status, address));
      }

      rs.close();
      this.getStmt().close();
      close();
      return pos;

    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      e.getStackTrace();
      return pos;
    }
  }

  /**
   * Get all the po Beans in the objects.
   * 
   * @return - A list of all the po beans.
   */
  public Pos findAll() {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery(this.getAllQuery());
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      e.getStackTrace();
      return new Pos();
    }
  }

  /**
   * Get the po beans with the registered id.
   * 
   * @param id
   *          - the id to look for.
   * @return - a list of po beans with that id.
   */
  public Pos findById(String id) {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where id='" + id + "';");
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      e.getStackTrace();
      return new Pos();
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
