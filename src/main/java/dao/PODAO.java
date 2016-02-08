package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.AddressBean;
import beans.POBean;

public class PODAO {
	/* SQL DB Connection */
	private String host = "localhost";
	private String user = "bookstore_test";
	private String pass = "4413";

	/* String SQL Queries */
	private static String TABLE_NAME = "PO";
	private static String GET_ALL_QUERY = "select * from " + TABLE_NAME;
	private static String GET_BY_QUERY = "select * from " + TABLE_NAME;

	private static Connection con = null;
	private static Statement stmt = null;

	public PODAO() {

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

	public List<POBean> get(ResultSet rs) {
		List<POBean> addresses = new ArrayList<POBean>();

		try {
			con.setReadOnly(true);

			while (rs.next()) {
				int id = rs.getInt("id");
				String lname = rs.getString("lname");
				String fname = rs.getString("fname");
				String status = rs.getString("status");
				int addressId = rs.getInt("address");

				AddressBean address = (new AddressDAO()).findById("" + addressId).get(addressId - 1);
				addresses.add(new POBean(id, lname, fname, status, address));
			}

			rs.close();
			stmt.close();
			close();
			return addresses;

		} catch (SQLException e) {
			System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
			return null;
		}
	}

	public List<POBean> findAll() {
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

	public List<POBean> findById(String id) {
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

	public List<POBean> findByTitle(String name) {
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

	public boolean insert(POBean address) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(POBean address) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(POBean address) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String args[]) {
		PODAO books = new PODAO();
		System.out.println(books.findAll().toString());
	}
}
