package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.AddressBean;
import beans.POBean;

/**
 * 
 * @author Skyler Layne on Feb 8, 2016
 *
 * @version 0.1.0
 */
public class PODAO extends DAO {

	public PODAO() {
		super();
		this.setTableName("PO");
	}

	public List<POBean> get(ResultSet rs) {
		List<POBean> addresses = new ArrayList<>();

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
			e.getStackTrace();
			return new ArrayList<>();
		}
	}

	public List<POBean> findAll() {
		try {
			createConnection();
			ResultSet rs = this.getStmt().executeQuery(this.getAllQuery());
			return get(rs);
		} catch (SQLException e) {
			System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
			e.getStackTrace();
			return new ArrayList<>();
		}
	}

	public List<POBean> findById(String id) {
		try {
			createConnection();
			ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where id='" + id + "';");
			return get(rs);
		} catch (SQLException e) {
			System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
			e.getStackTrace();
			return new ArrayList<>();
		}
	}

	public List<POBean> findByTitle(String name) {
		try {
			createConnection();
			ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where title='" + name + "';");
			return get(rs);
		} catch (SQLException e) {
			System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
			e.getStackTrace();
			return new ArrayList<>();
		}
	}

	public boolean insert(POBean address) {
		return false;
	}

	public boolean update(POBean address) {
		return false;
	}

	public boolean delete(POBean address) {
		return false;
	}
}
