package beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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

}
