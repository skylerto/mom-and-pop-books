package beans;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

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
  private String userId;

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
   * The user's Cart.
   */
  private CartBean cart;

  /**
   * The users purchase orders.
   */
  private List<PoBean> pos;

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
   * @param cart
   *          - the user's cart.
   * @param pos
   *          - A list of purchase orders.
   */
  public UserBean(String userId, String userName, String password, AddressBean address,
      boolean admin, CartBean cart, List<PoBean> pos) {
    this.userId = userId;
    this.userName = userName;
    this.password = password;
    this.address = address;
    this.admin = admin;
    this.cart = cart;
    this.pos = pos;
  }
  public UserBean(String userId, String userName, AddressBean address,
      boolean admin, CartBean cart, List<PoBean> pos) {
    this.userId = userId;
    this.userName = userName;
    this.address = address;
    this.admin = admin;
    this.cart = cart;
    this.pos = pos;
  }
  public UserBean() {
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public AddressBean getAddress() {
    return address;
  }

  public void setAddress(AddressBean address) {
    this.address = address;
  }

  public boolean isAdmin() {
    return admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

  public CartBean getCart() {
    return cart;
  }

  public void setCart(CartBean cart) {
    this.cart = cart;
  }

  public List<PoBean> getPos() {
    return pos;
  }

  public void setPos(List<PoBean> pos) {
    this.pos = pos;
  }

}
