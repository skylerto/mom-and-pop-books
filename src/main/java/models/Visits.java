package models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import beans.VisitEventBean;

/**
 * Hold State of many visit events.
 * 
 * @author Skyler Layne on Feb 17, 2016
 *
 */
@XmlRootElement(name = "visits")
public class Visits {

  private List<VisitEventBean> visits;

  /**
   * Default Constructor.
   */
  public Visits() {
    this.visits = new ArrayList<>();
  }

  public Visits(List<VisitEventBean> visits) {
    this.setVisits(visits);
  }

  public List<VisitEventBean> getVisits() {
    return visits;
  }

  @XmlElement(name = "visit")
  public void setVisits(List<VisitEventBean> visits) {
    this.visits = visits;
  }

  public int size() {
    return this.visits.size();
  }

  public VisitEventBean get(int index) {
    return this.visits.get(index);
  }

  public boolean add(VisitEventBean visit) {
    return this.visits.add(visit);
  }

  public Visits getAll(String month) {
    List<VisitEventBean> visitList = new ArrayList<>();
    this.visits.stream().filter(visit -> visit.getMonth().equals(month)).forEach(visit -> {
      visitList.add(visit);
    });
    return new Visits(visitList);
  }

}
