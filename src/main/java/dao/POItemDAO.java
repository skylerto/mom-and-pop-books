package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.BookBean;
import beans.POBean;
import beans.POItemBean;

public class POItemDAO {

	/* SQL DB Connection */
	private String host = "localhost";
	private String user = "bookstore_test";
	private String pass = "4413";

	/* String SQL Queries */
	private static String TABLE_NAME = "POItem";
	private static String GET_ALL_QUERY = "select * from " + TABLE_NAME;
	private static String GET_BY_QUERY = "select * from " + TABLE_NAME;

	private static Connection con = null;
	private static Statement stmt = null;

	public POItemDAO() {

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

	public List<POItemBean> get(ResultSet rs) {
		List<POItemBean> PoItems = new ArrayList<POItemBean>();

		try {
			con.setReadOnly(true);

			while (rs.next()) {

				int id = rs.getInt("id");

				String bid = rs.getString("bid");
				int price = rs.getInt("price");
				int POID = rs.getInt("id");
				POBean po = (new PODAO()).findById("" + POID).get(POID - 1);
				String bookID = rs.getString("bid");
				List<BookBean> list = (new BookDAO()).findById(bid);
				BookBean book = null;
				for (BookBean b : list) {
					if (b.getBid().equals(bid)) {
						book = b;
					}
				}

				PoItems.add(new POItemBean(id, bid, price, POID, bookID, po, book));
			}

			rs.close();
			stmt.close();
			close();
			return PoItems;

		} catch (SQLException e) {
			System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
			return null;
		}
	}

	public List<POItemBean> findAll() {
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

	public List<POItemBean> findById(String id) {
		try {
			createConnection();
			ResultSet rs = stmt.executeQuery(GET_BY_QUERY + " where id='" + id + "';");
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

	public List<POItemBean> findByTitle(String name) {
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

	public boolean insert(POItemBean poitem) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(POItemBean poitem) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(POItemBean poitem) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String args[]) {
		POItemDAO books = new POItemDAO();
		System.out.println(books.findById("1").toString());
	}

}
