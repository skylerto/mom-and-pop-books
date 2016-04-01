package controllers;

import java.io.IOException;
import java.io.Writer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import org.apache.commons.lang.StringEscapeUtils;

import dao.UserDataAccessObject;
import models.Users;
import beans.BookReviewBean;
import beans.UserBean;
import dao.BookReviewDataAccessObject;

/**
 * Servlet implementation class Review.
 */
@WebServlet(urlPatterns = { "/book/Review" })
public class Review extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response).
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Get the review parameter
    String review = request.getParameter("review");
    String bid = request.getParameter("bid");

    // Sanitize the review of any HTML
    review = StringEscapeUtils.escapeHtml(review);

    // Figure out if we're logged in or not for the userID
    UserBean userId = null;
    HttpSession currentSession = request.getSession();
    String userName = (String)currentSession.getAttribute("user");
    System.out.println(userName);
    if (currentSession.getAttribute("user") != null) {
      UserDataAccessObject udao = new UserDataAccessObject();
      Users users = udao.findByUsername(userName);
      userId = users.get(0);
    }

    BookReviewBean brb = new BookReviewBean(0, userId, bid, review);
    BookReviewDataAccessObject brdao = new BookReviewDataAccessObject();

    brdao.insert(brb);

    // Just indicate success no matter what
    Writer out = response.getWriter();
    out.write("{\"result\": \"success\"}");
  }
}
