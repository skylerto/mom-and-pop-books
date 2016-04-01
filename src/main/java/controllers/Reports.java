package controllers;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.ServletContext;
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
	if (path != null && path.equals("/Analytics")) {
		analytics(request, response);
	} else if (path != null && path.equals("/Monthly")) {
		monthly(request, response);
	} else if (path != null && path.equals("/User")) {
		user(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ServletContext context = request.getServletContext();
		//
		// SIS model = (SIS) context.getAttribute("model");
		//  try {
		// 	if (request.getParameter("submit").equals("Generate XML")) {
		//  		final String filename = "export/" + request.getSession().getId() + ".xml";
		//  		String realPath = context.getRealPath(filename);
		//
		//
		// 		Map<String, StudentBean> data = studentAccess.retrieveStudent(namePrefix, minGPA);
		// 		ArrayList<StudentBean> list = new ArrayList<StudentBean>(data.values());
		// 		String relativePath = "export/";
		// 		String path = filename.substring(0, filename.indexOf(relativePath) + relativePath.length());
		//
		// 		ListWrapper lw = new ListWrapper(namePrefix, Integer.parseInt(minGPA), list);
		//
		// 		JAXBContext jc = JAXBContext.newInstance(lw.getClass());
		// 		Marshaller marshaller = jc.createMarshaller();
		// 		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		// 		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		//
		// 		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		// 		Schema schema = sf.newSchema(new File(path + "/SIS.xsd"));
		// 		marshaller.setSchema(schema);
		//
		// 		StringWriter sw = new StringWriter();
		// 		sw.write("<?xml-stylesheet type=\"text/xsl\" href=\"SIS.xsl\"?>\n");
		// 		marshaller.marshal(lw, new StreamResult(sw));
		//
		// 		System.out.println(sw.toString()); // for debugging
		// 		FileWriter fw = new FileWriter(filename);
		// 		fw.write(sw.toString());
		// 		fw.close();
    //
		// 		model.export(namePrefix, credit_taken, realPath);
		// 		request.setAttribute("filename", filename);
    //
		// 		request.getRequestDispatcher("/Done.jspx").forward(request, response);
		// 	} else if (request.getParameter("submit").equals("Restricted")) {
		// 		Map<String, StudentBean> students = model.retrieveRestricted(namePrefix, credit_taken);
		// 		request.setAttribute("students", students);
    //
		// 		request.getRequestDispatcher("/Restricted.jspx").forward(request, response);
		// 	} else {
		// 		Map<String, StudentBean> students = model.retriveStudent(namePrefix, credit_taken);
		// 		request.setAttribute("students", students);
    //
		// 		request.getRequestDispatcher("/Form.jspx").forward(request, response);
		// 	}
		//  } catch (Exception e) {
		//  	e.printStackTrace();
		//  }
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
		request.getRequestDispatcher("/monthly.jsp").forward(request, response);
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
