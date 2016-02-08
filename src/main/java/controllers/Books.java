package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;

/**
 * 
 * @author Skyler Layne on Jan 8, 2016
 * @version 0.0.1
 *
 */
@WebServlet("/app/books")
public class Books extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Book books = new Book();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Books() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get the response as a PrintWriter

		// response.setContentType("text/xml;charset=UTF-8");

		PrintWriter writer = response.getWriter();
		String id = request.getParameter("id");
		if (id != null) {
			writer.append((new BookDAO()).findById(id).toString());

		} else {
			writer.append((new BookDAO()).findAll().toString());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
