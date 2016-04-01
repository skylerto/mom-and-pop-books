package filters;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import beans.VisitEventBean;
import dao.BookDataAccessObject;
import models.Books;

/**
 * Servlet Filter implementation class Masking
 */
@WebFilter(
		dispatcherTypes = { DispatcherType.REQUEST },
		urlPatterns = { "/book/*" })
public class VisitFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public VisitFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		VisitEventBean visit = new VisitEventBean();
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
		HttpServletRequest req = (HttpServletRequest) request;
		BookDataAccessObject bdao = new BookDataAccessObject();

		Books book = bdao.findById(req.getParameter("book"));

		visit.setDay(dateFormat.format(new Date().getTime()));
		visit.setBook(book.get(0));
		visit.setEventType("VIEW");
		visit.save();
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
