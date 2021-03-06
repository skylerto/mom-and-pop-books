package beans;

import junit.framework.TestCase;

/**
 *
 * @author Skyler Layne on Feb 9, 2016.
 *
 * @version 0.0.2.
 *
 */
public class TestPOItemBean extends TestCase {

  PoItemBean poitem;
  BookBean book;
  BookBean book2;
  PoBean po;
  PoBean po2;
  AddressBean address;

  String title = "";
  double price = 20.0;
  String category = "action";

  // BookBean fields
  int id = 1;
  String bid = "BOOK1";
  int pOID = 1;
  String bookID = "BOOK1";

  // AddressBean fields
  int aid = 1;
  String street = "some street";
  String province = "ON";
  String country = "CA";
  String zip = "M3J1P3";
  String phone = "905 960 6578";

  // POBean fields
  String lname = "last";
  String fname = "first";
  String status = "inactive";

  protected void setUp() throws Exception {
    super.setUp();

    book = new BookBean(bid, title, price, category, null, null);
    book2 = new BookBean("BOOK21", title, price, category, null, null);
    address = new AddressBean(aid, street, province, country, zip, phone);
    po = new PoBean(id, lname, fname, null, status, address);
    po2 = new PoBean(2, lname, fname, null, status, address);

    poitem = new PoItemBean(id, price, po, book);
  }

  protected void tearDown() throws Exception {
    super.tearDown();
    poitem = null;
    book = null;
    po = null;
    address = null;
  }

  public void testPOItemBean() {

    this.book = new BookBean(bid, title, price, category, null, null);
    this.address = new AddressBean(aid, street, province, country, zip, phone);
    this.po = new PoBean(id, lname, fname, null, status, address);
    this.poitem = new PoItemBean(id, price, po, book);
  }

  public void testToString() {
    String res = "POItem: [" + poitem.getId() + ", " + poitem.getPrice() + ", " + poitem.getPo()
        + ", " + poitem.getBook() + "]";
    assertEquals(res, poitem.toString());
  }

  public void testGetId() {
    assertEquals(1, poitem.getId());
  }

  public void testSetId() {
    poitem.setId(2);
    assertEquals(2, poitem.getId());
  }

  public void testGetPO() {
    assertEquals(po, poitem.getPo());
  }

  public void testSetPO() {
    poitem.setPo(po2);
    assertEquals(po2, poitem.getPo());
  }

  public void testGetBook() {
    assertEquals(book, poitem.getBook());
  }

  public void testSetBook() {
    poitem.setBook(book2);
    assertEquals(book2, poitem.getBook());
  }

  public void testGetPrice() {
    assertEquals(price, poitem.getPrice());
  }

  public void testSetPrice() {
    poitem.setPrice(100.00);
    assertEquals(100.00, poitem.getPrice());
  }

}
