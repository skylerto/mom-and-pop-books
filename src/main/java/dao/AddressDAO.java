package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.AddressBean;

/**
 * AddressDAO - Data Access Object for Addresses
 * 
 * @author Skyler Layne on Jan 9, 2016
 * @version 0.1.0
 *
 */
public class AddressDAO extends DAO {

	public AddressDAO() {
		super();
		this.setTableName("Address");
	}

	public List<AddressBean> get(ResultSet rs) {
		List<AddressBean> addresses = new ArrayList<AddressBean>();

		try {
			this.getCon().setReadOnly(true);

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
			this.getStmt().close();
			close();
			return addresses;

		} catch (SQLException e) {
			System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
			return null;
		}
	}

	public List<AddressBean> findAll() {
		try {
			this.createConnection();
			ResultSet rs = this.getStmt().executeQuery(this.getAllQuery());
			return get(rs);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getErrorCode() + "");
			return null;
		}
	}

	public List<AddressBean> findById(String id) {

		this.createConnection();
		ResultSet rs;
		try {
			rs = this.getStmt().executeQuery(this.getAllQuery() + " where id='" + id + "';");
			return get(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public List<AddressBean> findByTitle(String name) {
		try {
			createConnection();
			ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where title='" + name + "';");
			return get(rs);
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