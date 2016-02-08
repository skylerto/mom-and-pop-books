package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.BookDAO;

public class BookDAOTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAll() {
		BookDAO books = new BookDAO();
		assertEquals(books.findByTitle("Little Prince").toString(), "[Book: [b001, Little Prince, $20, Fiction]]");
	}

	@Test
	public void testFindByTitle() {
		BookDAO books = new BookDAO();
		assertEquals(books.findByTitle("Little Prince").toString(), "[Book: [b001, Little Prince, $20, Fiction]]");
	}

}
