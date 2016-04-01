package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BookBean;
import dao.BookDataAccessObject;
import models.Books;
import models.Cart;

/**
 * Servlet implementation class CartController
 */
@WebServlet(urlPatterns = { "/cart" })
public class CartController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public CartController() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");

    Cart cart = (Cart) request.getSession().getAttribute("cart");

    if (request.getServletPath() == null) {

    } else if (request.getServletPath().toLowerCase().contains("add")) {
      String bid = (String) request.getAttribute("bid");
      BookDataAccessObject dao = new BookDataAccessObject();
      Books books = dao.findById(bid);
      if (books.size() > 0) {
        BookBean book = books.get(0);
        cart.add(book);
      }

    } else if (request.getServletPath().toLowerCase().contains("remove")) {
      String bid = (String) request.getAttribute("bid");
      cart.get().remove(bid);
    } else {

    }

    request.setAttribute("cart", cart);

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
