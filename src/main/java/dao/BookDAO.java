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
 * @author Skyler Layne on Jan 9, 2016
 *
 */
public class BookDAO extends DAO {

	public BookDAO() {
		super();
		this.setTableName("Book");
	}

	public List<BookBean> get(ResultSet rs) {
		List<BookBean> books = new ArrayList<BookBean>();

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
			return null;
		}
	}

	public List<BookBean> findAll() {
		try {
			createConnection();
			ResultSet rs = this.getStmt().executeQuery(this.getAllQuery());
			return get(rs);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getErrorCode() + "");
			return null;
		}
	}

	public List<BookBean> findById(String id) {
		try {
			createConnection();
			ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where bid='" + id + "';");
			return get(rs);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getErrorCode() + "");
			return null;
		}
	}

	public List<BookBean> findByTitle(String name) {
		try {
			createConnection();
			ResultSet rs = this.getStmt().executeQuery(this.getAllQuery() + " where title='" + name + "';");
			return get(rs);
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
