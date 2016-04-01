package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;
import dao.UserDataAccessObject;
import models.Users;

/**
 * Servlet implementation class CheckoutController
 */
@WebServlet(urlPatterns = { "/checkout" })
public class CheckoutController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public CheckoutController() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher rd = request.getRequestDispatcher("/checkout.jsp");
    HttpSession session = request.getSession();
    // Load the user's information and store it in the session.
    UserDataAccessObject dao = new UserDataAccessObject();
    if (session.getAttribute("user") != null) {
      Users users = dao.findByUsername((String) session.getAttribute("user"));
      if (users.size() > 0) {
        UserBean user = users.get(0);
        session.setAttribute("address", user.getAddress());
      }

    }

    rd.forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
