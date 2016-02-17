package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.AddressBean;
import models.Addresses;

/**
 * AddressDAO - Data Access Object for Addresses
 * 
 * @author Skyler Layne on Jan 9, 2016
 * @version 0.1.0
 *
 */
public class AddressDataAccessObject extends DataAccessObject {

  /**
   * The constructor of the Data Access Object, sets the table name and the Data Access Object
   * constructor.
   */
  public AddressDataAccessObject() {
    super();
    this.setTableName("address");
  }

  /**
   * Get the Address Bean from the passed result set.
   * 
   * @param rs
   *          - the result of the query.
   * @return - a list of the Address Beans that are found from the query.
   */
  private Addresses get(ResultSet rs) {
    Addresses addresses = new Addresses();

    try {
      this.getCon().setReadOnly(true);

      while (rs.next()) {
        int id = rs.getInt("id");
        String street = rs.getString("street");
        String province = rs.getString("province");
        String country = rs.getString("country");
        String zip = rs.getString("zip");
        String phone = rs.getString("phone");

        addresses.add(new AddressBean(id, street, province, country, zip, phone));
      }

      rs.close();
      this.getStmt().close();
      close();
      return addresses;

    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return addresses;
    }
  }

  /**
   * Get all the Address Beans in the objects.
   * 
   * @return - A list of all the address beans.
   */
  public Addresses findAll() {
    try {
      this.createConnection();
      ResultSet rs = this.getStmt().executeQuery(this.getAllQuery());
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return new Addresses();
    }
  }

  /**
   * Get the address beans with the registered id.
   * 
   * @param id
   *          - the id to look for.
   * @return - a list of address beans with that id.
   */
  public Addresses findById(String id) {

    this.createConnection();
    ResultSet rs;
    try {
      rs = this.getStmt().executeQuery(this.getAllQuery() + " where id='" + id + "';");
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return new Addresses();
    }

  }

  public boolean insert(AddressBean address) {
    // TODO Auto-generated method stub
    return false;
  }

  public boolean update(AddressBean address) {
    // TODO Auto-generated method stub
    return false;
  }

  public boolean delete(AddressBean address) {
    // TODO Auto-generated method stub
    return false;
  }

}