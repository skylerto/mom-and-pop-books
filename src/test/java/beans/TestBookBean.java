package beans;

import beans.BookBean;
import junit.framework.TestCase;

/**
 * 
 * @author Skyler Layne on Feb 9, 2016
 * 
 * @version 0.0.1
 *
 */
public class TestBookBean extends TestCase {

  BookBean b;

  public void testBookBean() {
    // Null to start
    assertNull(b);

    // Create with empty arguments
    String bid = "";
    String title = "";
    int price = 0;
    String category = "";
    b = new BookBean(bid, title, price, category, null, null);

    b = null;
    assertNull(b);
  }

  public void testGetBid() {

    String bid = "";
    String title = "";
    int price = 0;
    String category = "";
    b = new BookBean(bid, title, price, category, null, null);

    assertEquals("", b.getBid());
  }

  public void testSetBid() {
    String bid = "";
    String title = "";
    int price = 0;
    String category = "";
    b = new BookBean(bid, title, price, category, null, null);
    b.setBid("BID2");
    assertEquals("BID2", b.getBid());
  }

  public void testGetTitle() {
    String bid = "";
    String title = "";
    int price = 0;
    String category = "";
    b = new BookBean(bid, title, price, category, null, null);

    assertEquals("", b.getTitle());
  }

  public void testSetTitle() {
    String bid = "";
    String title = "";
    int price = 0;
    String category = "";
    b = new BookBean(bid, title, price, category, null, null);
    b.setTitle("A title");
    assertEquals("A title", b.getTitle());
  }

  public void testGetPrice() {
    String bid = "";
    String title = "";
    double price = 0;
    String category = "";
    b = new BookBean(bid, title, price, category, null, null);

    assertEquals(0.0, b.getPrice());
  }

  public void testSetPrice() {
    String bid = "";
    String title = "";
    int price = 0;
    String category = "";
    b = new BookBean(bid, title, price, category, null, null);
    b.setPrice(36.50);
    assertEquals(36.50, b.getPrice());
  }

  public void testGetCategory() {
    String bid = "";
    String title = "";
    int price = 0;
    String category = "";
    b = new BookBean(bid, title, price, category, null, null);

    assertEquals("", b.getCategory());
  }

  public void testSetCategory() {
    String bid = "";
    String title = "";
    int price = 0;
    String category = "";
    b = new BookBean(bid, title, price, category, null, null);
    b.setCategory("A Category");
    assertEquals("A Category", b.getCategory());
  }

  public void testToString() {
    String bid = "";
    String title = "";
    double price = 0.0;
    String category = "";
    b = new BookBean(bid, title, price, category, null, null);

    String res = "Book: [" + "" + ", " + "" + ", $" + 0.0 + ", " + "" + "]";
    assertEquals(res, b.toString());
  }

}
