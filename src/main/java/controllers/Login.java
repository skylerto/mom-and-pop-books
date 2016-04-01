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

import dao.UserDataAccessObject;
import models.Users;

/**
 * Servlet implementation class Login.
 */
@WebServlet(urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response).
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MessageDigest md;
		String hash = request.getParameter("userPassword");

		Writer out = response.getWriter();
		out.flush();

		try {
			md = MessageDigest.getInstance("MD5");
			hash = DatatypeConverter.printHexBinary(md.digest(hash.getBytes()));

			UserDataAccessObject udao = new UserDataAccessObject();
			Users result = udao.get(request.getParameter("userName"), hash);

			HttpSession currentSession = request.getSession();

			/* Set User in Context */
			if (!result.isEmpty()) {
				currentSession.setAttribute("user", request.getParameter("userName"));
				currentSession.setAttribute("admin", result.get(0).isAdmin());
			} else {
				currentSession.removeAttribute("user");
				currentSession.removeAttribute("admin");
			}

			out.write("{ \"result\" : \"" + (result.isEmpty() ? "fail" : "success") + "\"");
			if (result.isEmpty()) {
				out.write(", \"message\" : \"<span><strong>Login Failed!</strong> Username or password incorrect.</span>\"");
			}
			out.write(" }");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			out.write("{ \"result\" : \"fail\", \"message\" : \"<span>Database Failure.</span>\" }");
		}
	}
}
