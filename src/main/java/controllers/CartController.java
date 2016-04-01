package controllers;

import java.io.IOException;
import java.io.Writer;

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
@WebServlet(urlPatterns = { "/cart", "/cart/remove", "/cart/add" })
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

    request.setAttribute("cart", cart);

    rd.forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");

    Cart cart = (Cart) request.getSession().getAttribute("cart");

    String method = (String) request.getParameter("method").trim();
    String bid = (String) request.getParameter("bid").trim();
    if (method.equals("add")) {
      BookDataAccessObject dao = new BookDataAccessObject();
      Books books = dao.findById(bid);
      if (books.size() > 0) {
        BookBean book = books.get(0);
        cart.add(book);
      }
    } else {
      System.out.println("BOOD BID:" + bid.trim());
      cart.remove(bid);
    }
    request.setAttribute("cart", cart);
    Writer out = response.getWriter();
    out.flush();

    out.write("{ \"result\" : \"" + (cart.getBook(bid) != null ? "fail" : "success") + "\"");
    if (cart.getBook(bid) == null) {
      out.write(
          ", \"message\" : \"<span><strong>Remove from cart Failed!</strong> Please try again.</span>\"");
    }
    out.write(" }");
  }

}
