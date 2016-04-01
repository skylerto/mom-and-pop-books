package controllers;

import dao.BookDataAccessObject;
import dao.BookReviewDataAccessObject;
import models.Books;
import models.BookReviews;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Book.
 */
@WebServlet(urlPatterns = { "/book/" })
public class Book extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response).
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher rd = request.getRequestDispatcher("/book.jsp");

    BookDataAccessObject bdao = new BookDataAccessObject();
    BookReviewDataAccessObject brdao = new BookReviewDataAccessObject();

    Books books = bdao.findById(request.getParameter("book"));

    BookReviews br = brdao.findByBookId(request.getParameter("book"));

    if (books.size() > 0) {
      request.setAttribute("book", books.getBooks().get(0));
    }

    if (br.size() > 0) {
      request.setAttribute("reviews", br.getReviews());
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
