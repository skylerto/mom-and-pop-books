package beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Skyler Layne on Feb 8, 2016
 *
 * @version 0.0.1
 */
@XmlRootElement(name = "po")
public class PoBean {

  private int id;
  private String lname;
  private String fname;
  private String status;
  private UserBean user;

  public UserBean getUser() {
    return user;
  }

  public void setUser(UserBean user) {
    this.user = user;
  }

  private AddressBean address;

  /**
   * Constructor of a purchase order bean.
   *
   * @param id
   *          - the if purchase order.
   * @param lname
   *          - the last name registered for the purchase order.
   * @param fname
   *          - the first name registered for the purchase order.
   * @param status
   *          - the status of the purchase order.
   * @param address
   *          - the address of the user registered for the purchase order.
   */
  public PoBean(int id, String lname, String fname, UserBean user, String status,
      AddressBean address) {
    this.id = id;
    this.lname = lname;
    this.fname = fname;
    this.status = status;
    this.user = user;
    this.address = address;
  }

  public PoBean(int id, String lname, String fname, String status, AddressBean address) {
    this.id = id;
    this.lname = lname;
    this.fname = fname;
    this.status = status;
    this.address = address;
  }

  /**
   * Default constructor.
   */
  public PoBean() {

  }

  /**
   * Get the id of the purchase order.
   *
   * @return - the id of the purchase order.
   */
  public int getId() {
    return id;
  }

  /**
   * Set the id of the purchase order.
   *
   * @param id
   *          - the new id.
   */
  @XmlElement(required = true)
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Get the last name registered with the purchase order.
   *
   * @return - the last name of the person on the purchase order.
   */
  public String getLname() {
    return lname;
  }

  /**
   * Change the last name of the user registered on the purchase order.
   *
   * @param lname
   *          - the new last name.
   */
  @XmlElement(required = true, name = "last_name")
  public void setLname(String lname) {
    this.lname = lname;
  }

  /**
   * The first name of the user registered on the purchase order.
   *
   * @return - the first name.
   */
  public String getFname() {
    return fname;
  }

  /**
   * Change the person registered on the purchase order's first name.
   *
   * @param fname
   *          - the new first name.
   */
  @XmlElement(required = true, name = "first_name")
  public void setFname(String fname) {
    this.fname = fname;
  }

  /**
   * Get the status of the purchase order.
   *
   * @return - the status of the purchase order.
   */
  public String getStatus() {
    return status;
  }

  /**
   * Change the status of the purchase order.
   *
   * @param status
   *          - the new status.
   */

  @XmlElement(required = true)
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * Get the address registered on the purchase order.
   *
   * @return - the address.
   */
  public AddressBean getAddress() {
    return address;
  }

  /**
   * Change the address on the purchase order.
   *
   * @param address
   *          - the new address.
   */

  @XmlElement(required = true)
  public void setAddress(AddressBean address) {
    this.address = address;
  }

  /**
   * String representation of the purchase order.
   */
  @Override
  public String toString() {
    return "PO: [" + this.id + ", " + this.lname + ", " + this.fname + ", " + this.status + ", "
        + this.address + "]";
  }

}
