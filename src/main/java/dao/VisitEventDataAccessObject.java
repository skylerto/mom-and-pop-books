package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.BookBean;
import beans.PoBean;
import beans.PoItemBean;
import beans.VisitEventBean;
import models.Books;
import models.PoItems;
import models.Visits;

/**
 *
 * VisitEvent DAO.
 *
 * @author Skyler Layne on Feb 17, 2016
 *
 */
public class VisitEventDataAccessObject extends DataAccessObject {

  public VisitEventDataAccessObject() {
    super();
    this.setTableName("visitevent");
  }

  /**
   * Get the PoItemBean from the passed result set.
   *
   * @param rs
   *          - the result of the query.
   * @return - a list of the PoItemBean that are found from the query.
   */
  private Visits get(ResultSet rs) {
    Visits visits = new Visits();

    try {

      while (rs.next()) {

        String day = rs.getString("DAY");
        String bid = rs.getString("bid");
        String eventType = rs.getString("eventtype");
        BookBean book = null;
        book = (new BookDataAccessObject()).findAll().getBooks().stream()
            .filter(b -> b.getBid().equals(bid)).findFirst().get();

        visits.add(new VisitEventBean(day, book, eventType));
      }

      rs.close();
      this.getStmt().close();
      return visits;

    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return new Visits();
    }
  }

  /**
   * Get all the PoItemBean in the objects.
   *
   * @return - A list of all the PoItemBean.
   */
  public Visits findAll() {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery(this.getAllQuery());
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getErrorCode() + ":" + e.getMessage());
      return new Visits();
    }
  }

  /**
   * Get the Visits that happen on a particular day.
   *
   * @param day
   *          - the day to find visits (DD/MM/YYYY).
   * @return - The Visits on that day.
   */
  public Visits findByDay(String day) {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where id='" + day + "';");
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getErrorCode() + ":" + e.getMessage());
      return new Visits();
    }
  }

  /**
   * Insert the visit event into the database.
   *
   * @param visit
   *          - the visit event.
   * @return - if the insert was successful
   */
  public boolean insert(VisitEventBean visit) {
    this.createConnection();
    PreparedStatement pstmt = null;
    String insert = "INSERT INTO " + this.getTableName() + " (DAY, bid, eventtype) VALUES"
        + "(?,?,?);";
    try {
      pstmt = this.getCon().prepareStatement(insert);
      pstmt.setString(1, visit.getDay());
      pstmt.setString(2, visit.getBook().getBid());
      pstmt.setString(3, visit.getEventType());
      pstmt.executeUpdate();
      pstmt.close();
      return true;
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return false;
    }
  }

  /**
   * Update the visit event in the database.
   *
   * @param visit
   *          - the visit event.
   * @return - if the update was successful.
   */
  public boolean update(VisitEventBean visit) {
    this.createConnection();
    PreparedStatement pstmt = null;
    String insert = "UPDATE " + this.getTableName() + " SET bid=?, eventtype=? where DAY="
        + visit.getDay();
    try {
      pstmt = this.getCon().prepareStatement(insert);
      pstmt.setString(1, visit.getBook().getBid());
      pstmt.setString(2, visit.getEventType());
      pstmt.executeUpdate();
      pstmt.close();
      return true;
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return false;
    }
  }

  /**
   * Delete the visit event from the database.
   *
   * @param visit
   *          - the visit event.
   * @return - if the delete was successful.
   */
  public boolean delete(VisitEventBean visit) {
    this.createConnection();
    PreparedStatement pstmt = null;
    String insert = "DELETE FROM " + this.getTableName() + " where DAY=" + visit.getDay();
    try {
      pstmt = this.getCon().prepareStatement(insert);
      pstmt.executeUpdate();
      pstmt.close();
      return true;
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      return false;
    }
  }

}
