package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

  /**
   * Insert an address.
   * 
   * @param address
   *          - the address to insert into the database.
   * @return - if the record was inserted.
   */
  public boolean insert(AddressBean address) {
    this.createConnection();
    PreparedStatement pstmt = null;
    String insert = "INSERT INTO " + this.getTableName()
        + " (id, street, province, country, zip, phone) VALUES" + "(?,?,?,?,?,?)";
    try {
      pstmt = this.getCon().prepareStatement(insert);
      pstmt.setInt(1, address.getId());
      pstmt.setString(2, address.getStreet());
      pstmt.setString(3, address.getProvince());
      pstmt.setString(4, address.getCountry());
      pstmt.setString(5, address.getZip());
      pstmt.setString(6, address.getPhone());
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
   * Update a given address.
   * 
   * @param address
   *          - the address to update.
   * @return - if the record was updated or not.
   */
  public boolean update(AddressBean address) {
    this.createConnection();
    PreparedStatement pstmt = null;
    String update = "UPDATE " + this.getTableName()
        + " SET street=?, province=?, country=?, zip=?, phone=?" + " where id=" + address.getId()
        + ";";
    try {
      pstmt = this.getCon().prepareStatement(update);
      // pstmt.setInt(1, address.getId());
      pstmt.setString(1, address.getStreet());
      pstmt.setString(2, address.getProvince());
      pstmt.setString(3, address.getCountry());
      pstmt.setString(4, address.getZip());
      pstmt.setString(5, address.getPhone());
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
   * Delete a record from the database.
   * 
   * @param address
   *          - the address to be deleted.
   * @return - if the record was deleted or not.
   */
  public boolean delete(AddressBean address) {
    this.createConnection();
    PreparedStatement pstmt = null;
    String delete = "DELETE FROM " + this.getTableName() + " where id=" + address.getId() + ";";
    try {
      pstmt = this.getCon().prepareStatement(delete);
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