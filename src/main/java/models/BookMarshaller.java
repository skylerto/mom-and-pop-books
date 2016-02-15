package models;

import beans.Books;

import java.io.File;
import java.io.PrintWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

/**
 * Book marshaller, return XML representation of a list of Books.
 * 
 * @author Skyler Layne on Feb 15, 2016
 *
 */
public class BookMarshaller {

  public BookMarshaller() {

  }

  /**
   * Marshal a list of Books to a specific filename.
   * 
   * @param books
   *          - The Books which would like to be marshalled.
   * @param filename
   *          - The filename to store the XML.
   */
  public void marshal(Books books, String filename) {
    File file = new File("./" + filename);

    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(books, file);

    } catch (PropertyException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (JAXBException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  /**
   * Marshal XML out to a PrintWriter.
   * 
   * @param books
   *          - The Books to marshal.
   * @param writer
   *          - The Writer to write too.
   */
  public void marshal(Books books, PrintWriter writer) {

    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(books, writer);

    } catch (PropertyException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (JAXBException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
