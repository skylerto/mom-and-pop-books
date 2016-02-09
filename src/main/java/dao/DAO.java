package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	/* SQL DB Connection */
	private String host;
	private String user;
	private String pass;

	/* String SQL Queries */
	private String tableName;

	private Connection con;
	private Statement stmt;

	public DAO() {
		/* SQL DB Connection */
		this.host = "localhost";
		this.user = "bookstore_user";
		this.pass = "4413";
		this.tableName = "";

		this.createConnection();

	}

	public String getTableName() {
		return tableName;
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

			this.con = DriverManager.getConnection("jdbc:mysql://" + this.getHost() + "/bookstore_test?useSSL=false",
					this.getUser(), this.getPass());

			this.setStmt(this.getCon().createStatement());

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
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
