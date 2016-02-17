package models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import beans.PoBean;

/**
 * Holds the State of many Purchase Orders.
 * 
 * @author Skyler Layne on Feb 17, 2016
 *
 */
@XmlRootElement(name = "pos")
public class Pos {
  private List<PoBean> pos;

  /**
   * Default constructor.
   */
  public Pos() {
    this.pos = new ArrayList<>();
  }

  public Pos(List<PoBean> pos) {
    this.pos = pos;
  }

  public List<PoBean> getPos() {
    return pos;
  }

  @XmlElement(name = "po")
  public void setPos(List<PoBean> pos) {
    this.pos = pos;
  }

  public boolean add(PoBean po) {
    return this.pos.add(po);
  }

  public int size() {
    return this.pos.size();
  }

  public PoBean get(int index) {
    return this.pos.get(index);
  }
}
