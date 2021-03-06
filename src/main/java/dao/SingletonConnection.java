package dao;

import java.sql.Connection;
import java.sql.DriverManager;

class SingletonConnection {
  private static Connection con = null;

  // Not allowed
  private SingletonConnection() {}

  public static Connection getConnection() {
    try {
      if (SingletonConnection.con == null || SingletonConnection.con.isClosed()) {
        String host = "mysql";
        String user = "bookstore_user";
        String pass = "4413";
        String db = "ecommerce";
        String url = "jdbc:mysql://" + host + "/" + db + "?useSSL=false";

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        SingletonConnection.con = DriverManager.getConnection(url, user, pass);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return SingletonConnection.con;
  }
}
