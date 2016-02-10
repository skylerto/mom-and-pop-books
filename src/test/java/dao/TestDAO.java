package dao;

import java.sql.SQLException;

import junit.framework.TestCase;

/**
 * 
 * @author Skyler Layne on Feb 8, 2016
 *
 * @version 0.1.0
 */
public class TestDAO extends TestCase {

  DataAccessObject dao;

  protected void setUp() throws Exception {
    super.setUp();
    dao = new DataAccessObject();
  }

  protected void tearDown() throws Exception {
    super.tearDown();
    dao = null;
  }

  public void testGetHost() {
    assertEquals("localhost", dao.getHost());
  }

  public void testSetHost() {
    dao.setHost("localhostnot");
    assertEquals("localhostnot", dao.getHost());
  }

  public void testGetUser() {
    assertEquals("bookstore_user", dao.getUser());
  }

  public void testSetUser() {
    dao.setUser("bookstore_test2");
    assertEquals("bookstore_test2", dao.getUser());

  }

  public void testGetPass() {
    assertEquals("4413", dao.getPass());
  }

  public void testSetPass() {
    dao.setPass("44133");
    assertEquals("44133", dao.getPass());
  }

  public void testGetCon() {
    assertNotNull(dao.getCon());
  }

  public void testCreateConnection() {
    dao.createConnection();
    assertNotNull(dao.getCon());
    dao.close();

  }

  public void testGetStmt() {
    assertNotNull(dao.getStmt());
  }

  public void testSetStmt() {
    assertNotNull(dao.getStmt());
  }

  public void testGetTableName() {
    assertEquals("", dao.getTableName());
  }

  public void testSetTableName() {
    dao.setTableName("Address");
    assertEquals("Address", dao.getTableName());
  }

  public void testGetAllQuery() {
    assertEquals("select * from ", dao.getAllQuery());
  }

  public void testClose() {
    // create an exception
    dao.close();
    try {
      assertTrue(dao.getCon().isClosed());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
