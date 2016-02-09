package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BookBean;
import beans.POBean;
import beans.POItemBean;

/**
 * 
 * @author Skyler Layne on Feb 8, 2016
 *
 */
public class POItemDAO extends DAO {

	public POItemDAO() {
		super();
		this.setTableName("POItem");
	}

	private List<POItemBean> get(ResultSet rs) {
		List<POItemBean> PoItems = new ArrayList<>();

		try {
			this.getCon().setReadOnly(true);

			while (rs.next()) {

				int id = rs.getInt("id");
				String bid = rs.getString("bid");
				int price = rs.getInt("price");
				POBean po = (new PODAO()).findById("" + id).get(id - 1);
				List<BookBean> list = (new BookDAO()).findById(bid);
				BookBean book = null;
				for (BookBean b : list) {
					if (b.getBid().equals(bid)) {
						book = b;
					}
				}

				PoItems.add(new POItemBean(id, bid, price, po, book));
			}

			rs.close();
			this.getStmt().close();
			close();
			return PoItems;

		} catch (SQLException e) {
			System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
			return new ArrayList<>();
		}
	}

	public List<POItemBean> findAll() {
		try {
			createConnection();
			ResultSet rs = this.getStmt().executeQuery(this.getAllQuery());
			return get(rs);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getErrorCode() + "");
			return new ArrayList<>();
		}
	}

	public List<POItemBean> findById(String id) {
		try {
			createConnection();
			ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where id='" + id + "';");
			return get(rs);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getErrorCode() + "");
			return new ArrayList<>();
		}
	}

	public List<POItemBean> findByTitle(String name) {
		try {
			createConnection();
			ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where title='" + name + "';");
			return get(rs);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getErrorCode() + "");
			return new ArrayList<>();
		}
	}

	public boolean insert(POItemBean poitem) {
		return false;
	}

	public boolean update(POItemBean poitem) {
		return false;
	}

	public boolean delete(POItemBean poitem) {
		return false;
	}

}
