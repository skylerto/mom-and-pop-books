package controllers;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
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
@WebServlet(urlPatterns = { "/Reports" })
public class Reports extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response).
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
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
    request.getRequestDispatcher("/reports.jsp").forward(request, response);
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
