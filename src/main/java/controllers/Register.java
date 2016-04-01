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
import javax.xml.bind.DatatypeConverter;

import beans.UserBean;
import dao.UserDataAccessObject;

/**
 * Servlet implementation class Login.
 */
@WebServlet(urlPatterns = { "/Register" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response).
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		MessageDigest md;
		String name = request.getParameter("userName");
		String hash = request.getParameter("userPassword");
		Boolean admin = request.getParameter("isAdmin") == "on" ? true : false;

		Writer out = response.getWriter();
		out.flush();

		try {
			md = MessageDigest.getInstance("MD5");
			hash = DatatypeConverter.printHexBinary(md.digest(hash.getBytes()));

			UserDataAccessObject users = new UserDataAccessObject();
			UserBean user = new UserBean();
			user.setUserName(name);
			user.setPassword(hash);
			user.setAdmin(admin);
			user.setAddress(null);

			System.out.println("Testing," + name + "," + hash + "," + admin.toString() + ",");
			Boolean success = users.insert(user);

			out.write("{ \"result\" : \"" + (!success ? "fail" : "success") + "\"");
			if (!success) {
				out.write(", \"message\" : \"<span>Database Failure.<span>\"");
			}
			out.write(" }");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			out.write("{ \"result\" : \"fail\", \"message\" : \"<span>Database Failure.<span>\" }");
		}
	}
}
