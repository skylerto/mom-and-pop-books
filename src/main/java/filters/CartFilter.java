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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Cart;

/**
 * Servlet Filter implementation class Cart.
 * 
 * @author Skyler Layne on Mar 31, 2016
 *
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/" })
public class CartFilter implements Filter {

  /**
   * Default constructor.
   */
  public CartFilter() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @see Filter#destroy()
   */
  public void destroy() {
    // TODO Auto-generated method stub
  }

  /**
   * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain).
   */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    // TODO Auto-generated method stub
    // place your code here
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;

    HttpSession currentSession = req.getSession();
    Cart cart = (Cart) currentSession.getAttribute("cart");
    if (cart == null) {
      cart = new Cart();
    }
    currentSession.setAttribute("cart", cart);
    // pass the request along the filter chain
    chain.doFilter(req, res);

  }

  /**
   * @see Filter#init(FilterConfig)
   */
  public void init(FilterConfig fConfig) throws ServletException {
    // TODO Auto-generated method stub
  }

}
