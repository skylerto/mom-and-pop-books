package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Data Access Object, this is used to separate out some logic from all subclasses. Should never be
 * instantiated on it's own.
 * 
 * @author Skyler Layne on Feb 8, 2016
 * 
 * @version 0.1.0
 *
 */
public class DataAccessObject {
  /* SQL DB Connection */
  private String host;
  private String user;
  private String pass;
  private String db;

  /* String SQL Queries */
  private String tableName;

  private Connection con;
  private Statement stmt;

  /**
   * Data Access Object Constructor, sets the host, use, password, and a temp table name.
   */
  public DataAccessObject() {
    /* SQL DB Connection */
    this.host = "mysql";
    this.user = "bookstore_user";
    this.pass = "4413";
    this.db = "ecommerce";
    this.tableName = "";

    this.createConnection();

  }

  public String getTableName() {
    return this.tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public String getAllQuery() {
    return "select * from " + this.getTableName();
  }

  public String getHost() {
    return this.host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getUser() {
    return this.user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPass() {
    return this.pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public Connection getCon() {
    return this.con;
  }

  public Statement getStmt() {
    return this.stmt;
  }

  public void setStmt(Statement stmt) {
    this.stmt = stmt;
  }

  // Get a connection from the pool
  protected void createConnection() {
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();

      this.con = DriverManager.getConnection(
          "jdbc:mysql://" + this.getHost() + "/" + this.getDb() + "?useSSL=false", this.getUser(),
          this.getPass());

      this.setStmt(this.getCon().createStatement());

    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException
        | SQLException e) {
      e.printStackTrace();
    }
  }

  private String getDb() {
    return this.db;
  }

  protected void close() {
    try {
      this.getCon().close();
    } catch (SQLException e) {
      System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
      e.getStackTrace();
    }
  }

}
