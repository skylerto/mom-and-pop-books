package models;

import beans.UserBean;

import java.util.List;

/**
 * Holds the state of Users, provides the authentication.
 * 
 * @author Skyler Layne on Mar 16, 2016
 *
 */
public class Users {

  private List<UserBean> users;

  /**
   * Default constructor.
   */
  public Users() {

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

}
