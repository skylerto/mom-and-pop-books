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
import models.Pos;
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

  private synchronized Users get(ResultSet rs) {
    List<UserBean> users = new ArrayList<>();
    try {
      this.getCon().setReadOnly(true);
      while (rs.next()) {
        int id = rs.getInt("id");
        String uname = rs.getString("username");
        String password = rs.getString("password");
        boolean admin = rs.getBoolean("admin");
        int addressId = rs.getInt("addressid");

        AddressBean address = (new AddressDataAccessObject()).findById("" + addressId).get(0);
        Pos pos = (new PoDataAccessObject()).findByUserId("" + id);
        UserBean user = new UserBean(id, uname, password, address, admin, pos);
        users.add(user);
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
      ResultSet rs = this.getStmt().executeQuery("select * from user;");
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
      ResultSet rs = this.getStmt().executeQuery(
          this.getAllQuery() + " where userid='" + id + "' AND password '" + hash + ";");
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

  public Users findByUserid(String id) {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery("select * from user where id=" + id + ";");
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: ");
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
