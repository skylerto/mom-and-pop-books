package models;

import java.io.File;
import java.io.PrintWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

/**
 * Object marshaller, return XML representation of a list of Books.
 * 
 * @author Skyler Layne on Feb 15, 2016
 *
 */
public class ObjectMarshaller {

  private Object object;

  /**
   * Default constructor.
   */
  public ObjectMarshaller() {

  }

  public ObjectMarshaller(Object object) {
    this.object = object;
  }

  /**
   * Marshal a list of Books to a specific filename.
   * 
   * @param object
   *          - Correctly annotated object which would like to be marshalled.
   * @param filename
   *          - The filename to store the XML.
   */
  public void marshal(Object object, String filename) {
    File file = new File("./" + filename);

    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(object, file);

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
   * @param object
   *          - Correctly annotated object which would like to be marshalled.
   * @param writer
   *          - The Writer to write too.
   */
  public void marshal(Object object, PrintWriter writer) {

    try {
      JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(object, writer);

    } catch (PropertyException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (JAXBException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
