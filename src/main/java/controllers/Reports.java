package controllers;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BookBean;
import beans.VisitEventBean;
import dao.VisitEventDataAccessObject;

/**
 * Servlet implementation class Index.
 */
@WebServlet(urlPatterns = { "/Reports", "/Reports/*" })
public class Reports extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response).
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	String path = request.getPathInfo();
	System.out.println(path);
	if (path != null && path.equals("/Analytics")) {
		System.out.println("Analytics");
		analytics(request, response);
	} else if (path != null && path.equals("/Monthly")) {
		System.out.println("Monthly");
		monthly(request, response);
	} else if (path != null && path.equals("/User")) {
		System.out.println("User");
		user(request, response);
	}
  }

  public void analytics(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    VisitEventDataAccessObject vdao = new VisitEventDataAccessObject();

	    Map<BookBean, Integer> mapping = new TreeMap<BookBean, Integer>();
	    for (VisitEventBean visit : vdao.findAll().getVisits()) {
	    	BookBean currBook = visit.getBook();
	    	if (mapping.containsKey(currBook)) {
	    		mapping.put(currBook, mapping.get(currBook) + 1);
	    	} else {
	    		mapping.put(currBook, 1);
	    	}
	    }

	    /* Get top 5 */
	    Map<BookBean, Integer> returnList = new LinkedHashMap<BookBean, Integer>();
	    int curr = 0;
	    for (Entry<BookBean, Integer> entry : entriesSortedByValues(mapping)) {
	        if (curr >= 5) break;
	        System.out.println(entry.getKey() +":"+entry.getValue());
	        returnList.put(entry.getKey(), entry.getValue());
	        curr++;
	     }

	    request.setAttribute("visits", returnList);
	    request.getRequestDispatcher("/analytics.jsp").forward(request, response);
  }

  public void monthly(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  public void user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
      SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
          new Comparator<Map.Entry<K,V>>() {
              @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                  int res = e2.getValue().compareTo(e1.getValue());
                  return res != 0 ? res : 1; // Special fix to preserve items with equal values
              }
          }
      );
      sortedEntries.addAll(map.entrySet());
      return sortedEntries;
  }
}
