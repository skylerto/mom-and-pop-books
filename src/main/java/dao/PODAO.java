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

/**
 * 
 * @author Skyler Layne on Feb 8, 2016
 *
 */
public class PODAO extends DAO {

	public PODAO() {
		super();
		this.setTableName("PO");
	}

	public List<POBean> get(ResultSet rs) {
		List<POBean> addresses = new ArrayList<POBean>();

		try {
			this.getCon().setReadOnly(true);

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
			this.getStmt().close();
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
			ResultSet rs = this.getStmt().executeQuery(this.getAllQuery());
			return get(rs);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getErrorCode() + "");
			return null;
		}
	}

	public List<POBean> findById(String id) {
		try {
			createConnection();
			ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where id='" + id + "';");
			return get(rs);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getErrorCode() + "");
			return null;
		}
	}

	public List<POBean> findByTitle(String name) {
		try {
			createConnection();
			ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where title='" + name + "';");
			return get(rs);
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
