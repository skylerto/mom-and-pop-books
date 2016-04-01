package models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import beans.BookBean;

/**
 * Holds the state of a list of Books.
 * 
 * @author Skyler Layne on Feb 15, 2016
 *
 */
@XmlRootElement(name = "books")
public class Books {

  private List<BookBean> books;

  /**
   * Default constructor.
   */
  public Books() {
    this.books = new ArrayList<>();
  }

  /**
   * Constructor from a list.
   * 
   * @param books
   *          - a list of books.
   */
  public Books(List<BookBean> books) {
    this.setBooks(books);
  }

  /**
   * Get the books in the list.
   * 
   * @return - the list of books.
   */
  public List<BookBean> getBooks() {
    return books;
  }

  /**
   * Set the list of the Books.
   * 
   * @param books
   *          - the new list of books.
   */
  @XmlElement(name = "book")
  public void setBooks(List<BookBean> books) {
    this.books = books;
  }

  /**
   * Return a String representation of a list of Books.
   */
  @Override
  public String toString() {
    StringBuilder bookList = new StringBuilder();
    bookList.append("[");
    this.books.forEach(book -> {
      bookList.append(book.toString());
    });
    bookList.append("]");
    return bookList.toString();
  }

  public boolean add(BookBean b1) {
    return this.books.add(b1);
  }

  public int size() {
    return this.books.size();
  }

  public BookBean get(int index) {
    return this.books.get(index);
  }

  public boolean remove(String bid) {
    int i = 0;
    boolean res = false;
    for (BookBean b : this.books) {
      if (b.getBid().toLowerCase().equals(bid)) {
        this.books.remove(books.indexOf(b));
        System.out.println("REMOVED BOOK: " + b.getBid() + " " + b.getTitle());
        res = true;
      }
      i++;
    }
    return res;
  }

}
