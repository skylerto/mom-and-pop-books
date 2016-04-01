package dao;

import beans.AddressBean;
import beans.UserBean;
import models.Pos;
import models.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
      Connection con = this.getCon();
      Statement stmnt = this.getStmt();
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
	this.createConnection();
    try {
      Connection con = this.getCon();
      PreparedStatement stmnt = con.prepareStatement(this.getAllQuery());
      ResultSet rs = stmnt.executeQuery();
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
	this.createConnection();

	try {
    Connection con = this.getCon();
		PreparedStatement stmnt = con.prepareStatement(this.getAllQuery() + " where username=? AND password=?;");
      stmnt.setString(1, id);
      stmnt.setString(2, hash);
      ResultSet rs = stmnt.executeQuery();
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getErrorCode() + ":" + e.getMessage());
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
	this.createConnection();

    try {
      Connection con = this.getCon();
      	PreparedStatement stmnt = con.prepareStatement(this.getAllQuery() + " where username=?;");
      stmnt.setString(1, username);
      ResultSet rs = stmnt.executeQuery();
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getErrorCode() + ":" + e.getMessage());
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
	this.createConnection();

    try {
      Connection con = this.getCon();
      PreparedStatement stmnt = con.prepareStatement("select * from user where id=?;");
      stmnt.setString(1, id);
      ResultSet rs = stmnt.executeQuery();
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: ");
      return new Users();
    }
  }

  /**
   * Insert a UserBean into the database.
   *
   * @param user
   *          - the user to be inserted.
   * @return - if the insertion happened.
   */
  public boolean insert(UserBean user) {
    this.createConnection();
    String stmntAddr = "INSERT INTO " + this.getTableName() + " (username, password, admin, addressid) VALUES (?,?,?,?);";
    String stmntNoAddr = "INSERT INTO " + this.getTableName() + " (username, password, admin) VALUES (?,?,?);";

    try {
	     Connection con = this.getCon();
	      PreparedStatement pstmt = con.prepareStatement(user.getAddress() == null ? stmntNoAddr : stmntAddr);

      pstmt.setString(1, user.getUserName());
      pstmt.setString(2, user.getPassword());
      pstmt.setBoolean(3, user.getAdmin());
      if (user.getAddress() != null) {
        pstmt.setInt(4, user.getAddress().getId());
      }
      pstmt.executeUpdate();

      return true;
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return false;
    }
  }

  /**
   * Update the passed UserBean in the database.
   *
   * @param user
   *          - The UserBean to update.
   * @return - If the user has been, updated or not.
   */
  public boolean update(UserBean user) {
	this.createConnection();

    try (Connection con = this.getCon();
		PreparedStatement pstmt = con.prepareStatement("UPDATE ? SET username=?, password=?, admin=?, addressid=? where id=")) {
      pstmt.setString(1, this.getTableName());
      pstmt.setString(2, user.getUserName());
      pstmt.setString(3, user.getPassword());
      pstmt.setBoolean(4, user.getAdmin());
      pstmt.setInt(5, user.getAddress().getId());
      pstmt.setInt(6, user.getUserId());

      pstmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return false;
    }
  }

  /**
   * Delete the passed user from the database.
   *
   * @param user
   *          - The user to be deleted.
   * @return - If the user has been deleted or not.
   */
  public boolean delete(UserBean user) {
	this.createConnection();

    try (Connection con = this.getCon();
    	PreparedStatement pstmt = con.prepareStatement("DELETE FROM ? where id = ? ;")) {
      pstmt.setString(1, this.getTableName());
      pstmt.setInt(2, user.getUserId());
      pstmt.executeUpdate();
      return true;
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return false;
    }
  }

}
