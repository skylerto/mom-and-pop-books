package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BookBean;
import dao.BookDataAccessObject;
import models.Books;
import models.Cart;

/**
 * Servlet implementation class Index.
 */
@WebServlet(urlPatterns = { "/", "/index" })
public class Index extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response).
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

    BookDataAccessObject bdao = new BookDataAccessObject();

    Books books = bdao.findAll();
    request.setAttribute("books", books.getBooks());

    rd.forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response).
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession currentSession = request.getSession();
    Cart cart = (Cart) currentSession.getAttribute("cart");
    String id = request.getParameter("bookid");
    BookDataAccessObject dao = new BookDataAccessObject();
    Books books = dao.findById(id);
    if (books.size() > 0) {
      BookBean book = books.get(0);
      cart.add(book);
    }
    if (cart != null) {
      currentSession.setAttribute("cart", cart);
    } else {
      currentSession.setAttribute("cart", new Cart());
    }
    doGet(request, response);
  }

}
