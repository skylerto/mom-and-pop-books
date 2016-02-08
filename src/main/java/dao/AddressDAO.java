package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.AddressBean;

/**
 * AddressDAO - Data Access Object for Addresses
 * 
 * @author Skyler Layne on Jan 9, 2016
 *
 */
public class AddressDAO {

	/* SQL DB Connection */
	private String host = "localhost";
	private String user = "bookstore_test";
	private String pass = "4413";

	/* String SQL Queries */
	private static String TABLE_NAME = "Address";
	private static String GET_ALL_QUERY = "select * from " + TABLE_NAME;
	private static String GET_BY_QUERY = "select * from " + TABLE_NAME;

	private static Connection con = null;
	private static Statement stmt = null;

	public AddressDAO() {

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

	public List<AddressBean> get(ResultSet rs) {
		List<AddressBean> addresses = new ArrayList<AddressBean>();

		try {
			con.setReadOnly(true);

			while (rs.next()) {
				int id = rs.getInt("id");
				String street = rs.getString("street");
				String province = rs.getString("province");
				String country = rs.getString("country");
				String zip = rs.getString("zip");
				String phone = rs.getString("phone");

				addresses.add(new AddressBean(id, street, province, country, zip, phone));
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

	public List<AddressBean> findAll() {
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

	public List<AddressBean> findById(String id) {
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

	public List<AddressBean> findByTitle(String name) {
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

	public boolean insert(AddressBean address) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(AddressBean address) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(AddressBean address) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String args[]) {
		AddressDAO books = new AddressDAO();
		System.out.println(books.findAll().toString());
	}
}