package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.BookBean;

/**
 * BookDAO - Data Access Object for Book.
 * 
 * @author Skyler Layne © Jan 9, 2016
 *
 */
public class BookDAO {

	/* SQL DB Connection */
	private String host = "localhost";
	private String user = "bookstore_test";
	private String pass = "4413";

	/* String SQL Queries */
	private static String TABLE_NAME = "Book";
	private static String GET_ALL_QUERY = "select * from " + TABLE_NAME;
	private static String GET_BY_QUERY = "select * from " + TABLE_NAME;

	private static Connection con = null;
	private static Statement stmt = null;

	public BookDAO() {

	}

	// Get a connection from the pool
	private void createConnection()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		con = DriverManager.getConnection("jdbc:mysql://" + host + "/bookstore_test?useSSL=false", user, pass);

		stmt = con.createStatement();
	}

	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getErrorCode() + ": " + e.getMessage());
		}
	}

	public List<BookBean> get(ResultSet rs) {
		List<BookBean> books = new ArrayList<BookBean>();

		try {
			con.setReadOnly(true);

			while (rs.next()) {
				String bid = rs.getString("bid");
				String title = rs.getString("title");
				int price = rs.getInt("price");
				String category = rs.getString("category");
				books.add(new BookBean(bid, title, price, category));
			}

			rs.close();
			stmt.close();
			close();
			return books;

		} catch (SQLException e) {
			System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
			return null;
		}
	}

	public List<BookBean> findAll() {
		try {
			createConnection();
			ResultSet rs = stmt.executeQuery(GET_ALL_QUERY);
			return get(rs);
		} catch (InstantiationException e) {
			System.out.println("InstantiationException: " + e.getMessage() + "");
			return null;
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException: " + e.getMessage() + "");
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e.getMessage() + "");
			return null;
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getErrorCode() + "");
			return null;
		}
	}

	public List<BookBean> findById(String id) {
		try {
			createConnection();
			ResultSet rs = stmt.executeQuery(GET_BY_QUERY + " where bid='" + id + "';");
			return get(rs);
		} catch (InstantiationException e) {
			System.out.println("InstantiationException: " + e.getMessage() + "");
			return null;
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException: " + e.getMessage() + "");
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e.getMessage() + "");
			return null;
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getErrorCode() + "");
			return null;
		}
	}

	public List<BookBean> findByTitle(String name) {
		try {
			createConnection();
			ResultSet rs = stmt.executeQuery(GET_BY_QUERY + " where title='" + name + "';");
			return get(rs);
		} catch (InstantiationException e) {
			System.out.println("InstantiationException: " + e.getMessage() + "");
			return null;
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException: " + e.getMessage() + "");
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e.getMessage() + "");
			return null;
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getErrorCode() + "");
			return null;
		}
	}

	public boolean insert(BookBean book) {
		// TODO Auto-generated method stub
		
		
		
		return false;
	}

	public boolean update(BookBean book) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(BookBean book) {
		// TODO Auto-generated method stub
		return false;
	}
}
