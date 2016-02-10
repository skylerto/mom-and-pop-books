package beans;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TestCartBean extends TestCase {

	private CartBean cart;
	private BookBean b1;
	private BookBean b2;

	protected void setUp() throws Exception {
		super.setUp();
		cart = new CartBean();
		b1 = new BookBean("0201633612", "Design Patterns: Elements of Reusable Object-Oriented Software", 55.09,
				"Programming");
		b2 = new BookBean("0978739213", "Release It!: Design and Deploy Production-Rea​dy Software", 40.11,
				"Programming");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCartSize() {

		assertEquals(0, cart.size());

		// Add the Book
		cart.add(b1);

		// Check the size
		assertEquals(1, cart.size());

	}

	public void testAddToCart() {
		// A Book
		assertTrue(cart.add(b1));

		for (int i = 0; i < 50; i++) {
			cart.add(b1);
		}

		assertFalse(cart.add(b1));

	}

	public void testGetCart() {
		// Add Some Books
		assertEquals(new ArrayList<>(), cart.get());

		List<BookBean> books = new ArrayList<>();
		books.add(b1);
		cart.add(b1);
		assertEquals(books, cart.get());


		books.add(b2);
		cart.add(b2);
		assertEquals(books, cart.get());

		assertEquals(2, cart.size());

	}

	public void testGetBookByIdCart() {
		cart.add(b1);
		cart.add(b2);

		assertNull(cart.getBook("This is fake"));
		assertEquals(b1, cart.getBook(b1.getBid()));
	}

}
