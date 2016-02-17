package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressDataAccessObject;
import dao.BookDataAccessObject;
import dao.PoDataAccessObject;
import dao.PoItemDataAccessObject;
import dao.VisitEventDataAccessObject;
import models.ObjectMarshaller;

/**
 * Servlet implementation class Soap.
 */
@WebServlet(urlPatterns = { "/soap", "/soap/*" })
public class Soap extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet().
   */
  public Soap() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response).
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String path = request.getPathInfo();
    if (path == null) {
      path = "";
    }

    PrintWriter writer = response.getWriter();
    ObjectMarshaller marshaller = new ObjectMarshaller();
    response.setContentType("text/xml");

    if (path.contains("pos")) {
      marshaller.marshal((new PoDataAccessObject()).findAll(), writer);
    } else if (path.contains("books")) {
      marshaller.marshal((new BookDataAccessObject()).findAll(), writer);
    } else if (path.contains("poitems")) {
      marshaller.marshal((new PoItemDataAccessObject()).findAll(), writer);
    } else if (path.contains("addresses")) {
      marshaller.marshal((new AddressDataAccessObject()).findAll(), writer);
    } else if (path.contains("visits")) {
      marshaller.marshal((new VisitEventDataAccessObject()).findAll().getAll("12"), writer);
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response).
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
