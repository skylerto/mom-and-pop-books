package beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import models.Pos;

/**
 * UserBean is a class to represent a user of the system: - A user needs login information. - A
 * normal user needs to be distinguished from an admin user. - A user might want to save their
 * address for future purchases. - A user might want to save their Cart. - A user might want
 * remember want their purchase orders.
 *
 * Credit card info should NOT be stored for each user.
 *
 * @author Skyler Layne on Mar 16, 2016
 * @version 0.0.1
 *
 */
@XmlRootElement(name = "user")
public class UserBean {
  /**
   * User's Id.
   */
  private int id;

  /**
   * User's name.
   */
  private String userName;

  /**
   * User's Password.
   */
  private String password;

  /**
   * User's stored address.
   */
  private AddressBean address;

  /**
   * Flag to determine if the user is an admin or not.
   */
  private boolean admin;

  /**
   * The users purchase orders.
   */
  private Pos pos;

  /**
   * Create a User from the passed value.
   * 
   * @param userId
   *          - the User's Id.
   * @param userName
   *          - the user's name.
   * @param password
   *          - the user's password.
   * @param address
   *          - the user's address.
   * @param admin
   *          - flag to check if the user is an admin or not.
   * @param pos
   *          - A list of purchase orders.
   */
  public UserBean(int id, String userName, String password, AddressBean address, boolean admin,
      Pos pos) {
    this.id = id;
    this.userName = userName;
    this.password = password;
    this.address = address;
    this.admin = admin;
    this.pos = pos;
  }

  /**
   * Create a UserBean without a password.
   * 
   * @param userId
   * @param userName
   * @param address
   * @param admin
   * @param pos
   */
  public UserBean(int id, String userName, AddressBean address, boolean admin, Pos pos) {
    this.id = id;
    this.userName = userName;
    this.address = address;
    this.admin = admin;
    this.pos = pos;
  }

  /**
   * Default UserBean constructor.
   */
  public UserBean() {
  }

  public int getUserId() {
    return id;
  }

  @XmlElement
  public void setUserId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  @XmlElement
  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  @XmlElement
  public void setPassword(String password) {
    this.password = password;
  }

  public AddressBean getAddress() {
    return address;
  }

  @XmlElement
  public void setAddress(AddressBean address) {
    this.address = address;
  }

  public boolean isAdmin() {
    return admin;
  }

  @XmlElement
  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

  public Pos getPos() {
    return pos;
  }

  @XmlElement
  public void setPos(Pos pos) {
    this.pos = pos;
  }

}
