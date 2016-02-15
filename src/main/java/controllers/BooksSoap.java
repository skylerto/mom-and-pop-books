package controllers;

import beans.Books;
import dao.BookDataAccessObject;
import models.ObjectMarshaller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Skyler Layne on Jan 8, 2016
 * @version 0.0.1
 *
 */
@WebServlet("/soap/books")
public class BooksSoap extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet().
   */
  public BooksSoap() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response).
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // Get the response as a PrintWriter

    PrintWriter writer = response.getWriter();
    Books books = (new BookDataAccessObject()).findAll();
    ObjectMarshaller marsh = new ObjectMarshaller();

    response.setContentType("text/xml");
    marsh.marshal(books, writer);

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response).
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
