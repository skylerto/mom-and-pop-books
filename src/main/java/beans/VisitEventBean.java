package beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import dao.VisitEventDataAccessObject;

/**
 * Bean object representation of VisitEvent.
 * 
 * @author Skyler Layne on Feb 17, 2016
 *
 */
@XmlRootElement(name = "visitevent")
public class VisitEventBean {

  private String day;
  private BookBean book;
  private String eventType;

  /**
   * Default Constructor.
   */
  public VisitEventBean() {

  }

  /**
   * Create a Visit Event.
   * 
   * @param day
   *          - the day the visit even occurs on.
   * @param book
   *          - the book which the event occurs on.
   * @param eventType
   *          - the event type.
   */
  public VisitEventBean(String day, BookBean book, String eventType) {
    this.setDay(day);
    this.setBook(book);
    this.setEventType(eventType);
  }

  public String getDay() {
    return day;
  }

  @XmlElement
  public void setDay(String day) {
    this.day = day;
  }

  public BookBean getBook() {
    return book;
  }

  @XmlElement
  public void setBook(BookBean book) {
    this.book = book;
  }

  public String getEventType() {
    return eventType;
  }

  @XmlElement
  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  public String getMonth() {
    return this.getDay().substring(0, 2);
  }

  /**
   * Insert of Update this record.
   * 
   * @return - if the save worked.
   */
  public boolean save() {
    VisitEventDataAccessObject dao = new VisitEventDataAccessObject();
    boolean res = false;

    if (dao.findByDay(day).size() > 0) {
      res = dao.update(this);
    } else {
      res = dao.insert(this);
    }

    return res;
  }

  /**
   * Delete this record.
   * 
   * @return - if the delete worked.
   */
  public boolean delete() {
    return (new VisitEventDataAccessObject()).delete(this);
  }
}
