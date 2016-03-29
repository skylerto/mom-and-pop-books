package models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import beans.UserBean;

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

  public UserBean get(int i) {
    // TODO Auto-generated method stub
    return users.get(i);
  }

}
