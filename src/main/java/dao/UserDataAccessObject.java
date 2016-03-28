package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BookBean;
import beans.UserBean;
import beans.AddressBean;
import beans.CartBean;
import models.Books;
import models.Users;

/**
 * UserDAO - Data Access Object for a User.
 * 
 * @author Skyler Layne on Mar 16, 2016
 *
 */
public class UserDataAccessObject extends DataAccessObject {

  public UserDataAccessObject() {
    super();
    this.setTableName("user");
  }

  private Users get(ResultSet rs) {
    List<UserBean> users = new ArrayList<>();
    try {
      this.getCon().setReadOnly(true);
      while (rs.next()) {
        String id = rs.getString("userId");
        String uname = rs.getString("userName");

        // TODO: Get an addressId, create an address bean from it.
        int addressId = rs.getInt("addressId");
        AddressBean address;

        // TODO: Get a cartId, create an cart bean from it.
        int cartId = rs.getInt("cartId");
        CartBean cart;

        // TODO:  Create a user object from this information.
      }
      rs.close();
      this.getStmt().close();
      close();
      return new Users(users);

    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return new Users();
    }
  }

  public Users findAll() {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery(this.getAllQuery());
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      e.getStackTrace();
      return new Users();
    }
  }

  public Users get(String id, String hash) {
    try {
      createConnection();
      ResultSet rs = this.getStmt()
          .executeQuery(this.getAllQuery() + " where userid='" + id + "' AND password '" + hash + ";");
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getErrorCode() + "");
      return new Users();
    }
  }

  public Users findByUsername(String username) {
    try {
      createConnection();
      ResultSet rs = this.getStmt()
          .executeQuery(this.getAllQuery() + " where username='" + username + "';");
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getErrorCode() + "");
      return new Users();
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
