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

      // do purchase order controller logic
      marshaller.marshal((new PoDataAccessObject()).findAll(), writer);
    } else if (path.contains("books")) {

      // do books controller logic
      String bid = request.getParameter("bid");
      if(bid != null){
        marshaller.marshal((new BookDataAccessObject()).findById(bid), writer);
      } else {
        marshaller.marshal((new BookDataAccessObject()).findAll(), writer);
      }
    } else if (path.contains("poitems")) {

      // do poitems controller logic
      String id = request.getParameter("id");
      if(id != null){
        marshaller.marshal((new PoItemDataAccessObject()).findById(id), writer);
      } else {
        marshaller.marshal((new PoItemDataAccessObject()).findAll(), writer);
      }
    } else if (path.contains("addresses")) {

      // do Address controller logic
      String id = request.getParameter("id");
      if(id != null){
        marshaller.marshal((new PoItemDataAccessObject()).findById(id), writer);
      } else {
        marshaller.marshal((new AddressDataAccessObject()).findAll(), writer);
      }

    } else if (path.contains("visits")) {

      // do Visits controller logic
      String month = request.getParameter("month");
      if(month != null){
        marshaller.marshal((new VisitEventDataAccessObject()).findAll().getAll("12"), writer);
      } else {
        marshaller.marshal((new VisitEventDataAccessObject()).findAll(), writer);
      }

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
