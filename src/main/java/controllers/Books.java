package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDataAccessObject;

/**
 * 
 * @author Skyler Layne on Jan 8, 2016
 * @version 0.0.1
 *
 */
@WebServlet("/app/books")
public class Books extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public Books() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // Get the response as a PrintWriter

    PrintWriter writer = response.getWriter();
    String id = request.getParameter("id");
    if (id != null) {
      writer.append((new BookDataAccessObject()).findById(id).toString());

    } else {
      writer.append((new BookDataAccessObject()).findAll().toString());
    }

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
