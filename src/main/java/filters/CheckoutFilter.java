package filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class CheckoutFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/checkout" })
public class CheckoutFilter implements Filter {

  /**
   * Default constructor.
   */
  public CheckoutFilter() {
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
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    HttpSession session = req.getSession();
    String user = (String) session.getAttribute("user");

    if (user != null) {
      chain.doFilter(req, res);
    } else {
      session.setAttribute("error", "Please register/sign in before checking out.");
      res.sendRedirect(request.getServletContext().getContextPath() + "/cart");
    }

  }

  /**
   * @see Filter#init(FilterConfig)
   */
  public void init(FilterConfig fConfig) throws ServletException {
    // TODO Auto-generated method stub
  }

}
