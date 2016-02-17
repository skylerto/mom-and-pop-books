package dao;

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
      this.getCon().setReadOnly(true);

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
      close();
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
      System.out.println("SQLException: " + e.getErrorCode() + "");
      return new Visits();
    }
  }

  /**
   * Get the Visits that happen on a particular day.
   * 
   * @param id
   *          - the day to find visits (DD/MM/YYYY)
   * @return - The Visits on that day.
   */
  public Visits findByDay(String day) {
    try {
      createConnection();
      ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where id='" + day + "';");
      return get(rs);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.getErrorCode() + "");
      return new Visits();
    }
  }

  public boolean insert(VisitEventBean poitem) {
    return false;
  }

  public boolean update(VisitEventBean poitem) {
    return false;
  }

  public boolean delete(VisitEventBean poitem) {
    return false;
  }

}
