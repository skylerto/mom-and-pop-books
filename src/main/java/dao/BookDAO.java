package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BookBean;

/**
 * BookDAO - Data Access Object for Book.
 * 
 * @author Skyler Layne on Jan 9, 2016
 * 
 * @version 0.1.0
 *
 */
public class BookDAO extends DAO {

	public BookDAO() {
		super();
		this.setTableName("Book");
	}

	private List<BookBean> get(ResultSet rs) {
		List<BookBean> books = new ArrayList<>();
		try {
			this.getCon().setReadOnly(true);
			while (rs.next()) {
				String bid = rs.getString("bid");
				String title = rs.getString("title");
				int price = rs.getInt("price");
				String category = rs.getString("category");
				books.add(new BookBean(bid, title, price, category));
			}
			rs.close();
			this.getStmt().close();
			close();
			return books;

		} catch (SQLException e) {
			System.out.println("SQL Exception" + e.getErrorCode() + e.getMessage());
			return new ArrayList<>();
		}
	}

	public List<BookBean> findAll() {
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

	public List<BookBean> findById(String id) {
		try {
			createConnection();
			ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where bid='" + id + "';");
			return get(rs);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getErrorCode() + "");
			return new ArrayList<>();
		}
	}

	public List<BookBean> findByTitle(String name) {
		try {
			createConnection();
			ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where title='" + name + "';");
			return get(rs);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getErrorCode() + "");
			return new ArrayList<>();
		}
	}

	public boolean insert(BookBean book) {

		return false;
	}

	public boolean update(BookBean book) {
		return false;
	}

	public boolean delete(BookBean book) {
		return false;
	}
}
