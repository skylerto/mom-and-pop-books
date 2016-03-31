package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.AddressBean;
import beans.PoBean;
import beans.UserBean;
import models.Pos;
import models.Users;

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
  public synchronized Pos get(ResultSet rs) {
    Pos pos = new Pos();

    try {
      this.getCon().setReadOnly(true);

      while (rs.next()) {
        int id = rs.getInt("id");
        String lname = rs.getString("lname");
        String fname = rs.getString("fname");
        String status = rs.getString("status");
        int addressId = rs.getInt("address");
        int userid = rs.getInt("userid");
        UserBean user = (new UserDataAccessObject()).findByUserid("" + userid).get(0);
        AddressBean address = (new AddressDataAccessObject()).findById("" + addressId).get(0);
        pos.add(new PoBean(id, lname, fname, user, status, address));
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
      ResultSet rs = this.getStmt()
          .executeQuery(this.getAllQuery() + " where userid='" + id + "';");
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      e.getStackTrace();
      return new Pos();
    }
  }

  public Pos findByUserId(String id) {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery("select * from po where userid=" + id + ";");

      Pos pos = new Pos();

      this.getCon().setReadOnly(true);

      while (rs.next()) {
        int aid = rs.getInt("id");
        String lname = rs.getString("lname");
        String fname = rs.getString("fname");
        String status = rs.getString("status");
        int addressId = rs.getInt("address");
        int userid = rs.getInt("userid");
        AddressBean address = (new AddressDataAccessObject()).findById("" + addressId).get(0);
        pos.add(new PoBean(aid, lname, fname, status, address));
      }

      rs.close();
      this.getStmt().close();
      close();
      return pos;

    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      e.getStackTrace();
      return new Pos();
    }
  }

  /**
   * Insert a po into the database.
   * 
   * @param po
   *          - the po to be inserted.
   * @return - if the po was inserted or not.
   */
  public boolean insert(PoBean po) {
    this.createConnection();
    PreparedStatement pstmt = null;
    String insert = "INSERT INTO " + this.getTableName()
        + " (id, lname, fname, userid, status, address) VALUES" + "(?,?,?,?,?,?)";
    try {
      pstmt = this.getCon().prepareStatement(insert);
      pstmt.setInt(1, po.getId());
      pstmt.setString(2, po.getLname());
      pstmt.setString(3, po.getFname());
      pstmt.setInt(4, po.getUser().getUserId());
      pstmt.setString(5, po.getStatus());
      pstmt.setInt(6, po.getAddress().getId());
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
   * Update a po into the database.
   * 
   * @param po
   *          - the po to be updated.
   * @return - if the po was updated or not.
   */
  public boolean update(PoBean po) {
    this.createConnection();
    PreparedStatement pstmt = null;
    String insert = "UPDATE " + this.getTableName()
        + " SET lname=?, fname=?, userid=?, status=?, address=? where id=" + po.getId();
    try {
      pstmt = this.getCon().prepareStatement(insert);
      pstmt.setString(1, po.getLname());
      pstmt.setString(2, po.getFname());
      pstmt.setInt(3, po.getUser().getUserId());
      pstmt.setString(4, po.getStatus());
      pstmt.setInt(5, po.getAddress().getId());
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
   * Delete a po into the database.
   * 
   * @param po
   *          - the po to be deleted.
   * @return - if the po was deleted or not.
   */
  public boolean delete(PoBean po) {
    this.createConnection();
    PreparedStatement pstmt = null;
    String insert = "DELETE " + this.getTableName() + " where id=" + po.getId();
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
