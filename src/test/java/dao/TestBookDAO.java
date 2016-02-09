package dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import beans.BookBean;

@RunWith(MockitoJUnitRunner.class)
public class TestBookDAO {

	@Mock
	BookDAO mockedBookDAO;

	BookBean b1;
	BookBean b2;
	List<BookBean> mine;
	
	@Before
	public void setUp() throws Exception {

		mockedBookDAO = Mockito.mock(BookDAO.class);
		b1 = new BookBean("0201633612", "Design Patterns: Elements of Reusable Object-Oriented Software", 55.09,
				"Programming");
		b2 = new BookBean("0978739213", "Release It!: Design and Deploy Production-Rea​dy Software", 40.11,
				"Programming");

		mine = new ArrayList<BookBean>();
		mine.add(b1);
		mine.add(b2);

		Mockito.when(mockedBookDAO.findAll()).thenReturn(Arrays.asList(b1, b2));

		// FindById Mocking
		Mockito.when(mockedBookDAO.findById("B000SEIBB8")).thenReturn(Arrays.asList(b1));
		Mockito.when(mockedBookDAO.findById("")).thenReturn(Arrays.asList());

		// FindBy Title Mocking
		Mockito.when(mockedBookDAO.findByTitle("Release It!: Design and Deploy Production-Rea​dy Software"))
				.thenReturn(Arrays.asList(b2));
		Mockito.when(mockedBookDAO.findByTitle("")).thenReturn(Arrays.asList());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindByTitle() {
		String title = "Release It!: Design and Deploy Production-Rea​dy Software";
		List<BookBean> book = mockedBookDAO.findByTitle(title);
		assertEquals(1, book.size());
		assertEquals(b2, book.get(0));

		title = "";
		book = mockedBookDAO.findByTitle(title);
		assertEquals(0, book.size());
		assertEquals(new ArrayList<BookBean>(0), book);
	}
	
	@Test
	public void testFindById() {
		String isbn = "B000SEIBB8";
		List<BookBean> book = mockedBookDAO.findById(isbn);
		assertEquals(1, book.size());
		assertEquals(b1, book.get(0));

		isbn = "";
		book = mockedBookDAO.findById(isbn);
		assertEquals(0, book.size());
		assertEquals(new ArrayList<BookBean>(0), book);

	}
	
	@Test
	public void testFindAll() {
		List<BookBean> allBooks = mockedBookDAO.findAll();
		assertEquals(2, allBooks.size());
		assertEquals(mine, allBooks);
		assertEquals(b1, allBooks.get(0));
		assertEquals(b2, allBooks.get(1));

	}
	
	public void testInsert() {
		// TODO test insert new book
	}

	public void testUpdate() {
		// TODO test update a book
	}

	public void testDelete() {
		// TODO test deleting a book
	}

}
