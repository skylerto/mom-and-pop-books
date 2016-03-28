package controllers;

import beans.BookBean;
import dao.BookDataAccessObject;
import models.Books;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Soap.
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
    for (BookBean bb : books.getBooks()) {
      System.out.println(bb.getTitle());
    }
    rd.forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response).
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Not supported, but don't get too mad at them
    doGet(request, response);
  }

}
