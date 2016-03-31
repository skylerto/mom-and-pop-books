package models;

import beans.UserBean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Holds the state of Users, provides the authentication.
 *
 * @author Skyler Layne on Mar 16, 2016
 *
 */
@XmlRootElement(name = "users")
public class Users {

  private List<UserBean> users;

  public List<UserBean> getUsers() {
    return users;
  }

  @XmlElement(name = "user")
  public void setUsers(List<UserBean> users) {
    this.users = users;
  }

  /**
   * Default constructor.
   */
  public Users() {
    this.users = new ArrayList<UserBean>();
  }

  /**
   * Create a Users model from a list of users.
   *
   * @param users
   *          - a list of users.
   */
  public Users(List<UserBean> users) {
    this.users = users;
  }

  /**
   * Get the user at index i.
   *
   * @param i
   *          - index value.
   * @return - the UserBean at that location.
   */
  public UserBean get(int index) {
    return users.get(index);
  }

  public int size() {
    return this.users.size();
  }

  /**
   * Get the user at index i.
   *
   * @param i
   *          - index value.
   * @return - the UserBean at that location.
   */
  public boolean isEmpty() {
    return users.isEmpty();
  }

}
