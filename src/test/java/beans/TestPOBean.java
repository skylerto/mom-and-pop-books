package beans;

import junit.framework.TestCase;

/**
 * 
 * @author Skyler Layne on Feb 9, 2016.
 * 
 * @version 0.0.1
 *
 */
public class TestPOBean extends TestCase {

  PoBean po;
  AddressBean address;
  AddressBean address2;

  protected void setUp() throws Exception {
    super.setUp();

    int aid = 1;
    String street = "some street";
    String province = "ON";
    String country = "CA";
    String zip = "M3J1P3";
    String phone = "905 960 6578";
    this.address = new AddressBean(aid, street, province, country, zip, phone);

    this.address2 = new AddressBean(aid + 1, street, province, country, zip, phone);

    int id = 1;
    String lname = "last";
    String fname = "first";
    String status = "inactive";
    this.po = new PoBean(id, lname, fname, status, address);
  }

  protected void tearDown() throws Exception {
    super.tearDown();
    po = null;
    address = null;
  }

  public void testPOBean() {

    int aid = 1;
    String street = "some street";
    String province = "ON";
    String country = "CA";
    String zip = "M3J1P3";
    String phone = "905 960 6578";
    AddressBean address = new AddressBean(aid, street, province, country, zip, phone);

    int id = 1;
    String lname = "last";
    String fname = "first";
    String status = "inactive";

    PoBean po = new PoBean(id, lname, fname, status, address);
  }

  public void testGetId() {
    assertEquals(1, this.po.getId());
  }

  public void testSetId() {
    this.po.setId(2);
    assertEquals(2, this.po.getId());
  }

  public void testGetLname() {
    System.out.println(this.po.getLname());
    assertEquals("last", this.po.getLname());
  }

  public void testSetLname() {
    this.po.setLname("otherlast");
    assertEquals("otherlast", this.po.getLname());
  }

  public void testGetFname() {
    assertEquals("first", this.po.getFname());
  }

  public void testSetFname() {
    this.po.setFname("otherfirst");
    assertEquals("otherfirst", this.po.getFname());
  }

  public void testGetStatus() {
    assertEquals("inactive", po.getStatus());
  }

  public void testSetStatus() {
    this.po.setStatus("active");
    assertEquals("active", this.po.getStatus());
  }

  public void testGetAddress() {
    assertEquals(address, this.po.getAddress());
  }

  public void testSetAddress() {
    this.po.setAddress(address2);
    assertEquals(address2, this.po.getAddress());
  }

  public void testToString() {
    String res = "PO: [" + this.po.getId() + ", " + this.po.getLname() + ", " + this.po.getFname()
        + ", " + this.po.getStatus() + ", " + this.po.getAddress() + "]";
    assertEquals(res, this.po.toString());
  }

}
