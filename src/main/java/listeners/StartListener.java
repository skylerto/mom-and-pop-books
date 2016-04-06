package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import models.Cart;

/**
 * Application Lifecycle Listener implementation class MaxPrinciple
 *
 */
@WebListener
public class StartListener implements HttpSessionListener {

	/**
	 * Default constructor.
	 */
	public StartListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
    if(arg0.getSession().getAttribute("cart") == null){
		  arg0.getSession().setAttribute("cart", new Cart());
    }
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
