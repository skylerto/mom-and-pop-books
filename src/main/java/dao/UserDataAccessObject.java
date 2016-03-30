package dao;

import beans.AddressBean;
import beans.BookBean;
import beans.UserBean;
import models.Pos;
import models.Users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

  /**
   * findAll users in the User table. Unsafe for production.
   * 
   * @return - a Users model object.
   */
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

  /**
   * Check the user in the database against its password hash.
   * 
   * @param id
   *          - the User's id.
   * @param hash
   *          - the password hash.
   * @return - a Users model of containing an authenticated user.
   */
  public Users get(String id, String hash) {
    try {
      createConnection();
      ResultSet rs = this.getStmt()
          .executeQuery(this.getAllQuery() + " where id='" + id + "' AND password '" + hash + ";");
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getErrorCode() + "");
      return new Users();
    }
  }

  /**
   * Find Users by Username.
   * 
   * @param username
   *          - the user's username.
   * @return - a Users object.
   */
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

  /**
   * Find a User by a given id.
   * 
   * @param id
   *          - the user's id.
   * @return - a Users model with that id.
   */
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

  /**
   * Insert a BookBean into the database.
   * 
   * @param book
   *          - the book to be inserted.
   * @return - if the insertion happened.
   */
  public boolean insert(BookBean book) {

    return false;
  }

  /**
   * Update the passed BookBean in the database.
   * 
   * @param book
   *          - The BookBean to update.
   * @return - If the book has been, updated or not.
   */
  public boolean update(BookBean book) {
    return false;
  }

  /**
   * Delete the passed book from the database.
   * 
   * @param book
   *          - The book to be deleted.
   * @return - If the book has been deleted or not.
   */
  public boolean delete(BookBean book) {
    return false;
  }

}
