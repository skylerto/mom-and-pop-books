package models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import beans.PoItemBean;

/**
 * Holds the state of a list of many Purchase Order Items.
 * 
 * @author Skyler Layne on Feb 17, 2016
 *
 */
@XmlRootElement(name = "poitems")
public class PoItems {

  private List<PoItemBean> poitems;

  public List<PoItemBean> getPoitems() {
    return poitems;
  }

  @XmlElement(name = "poitem")
  public void setPoitems(List<PoItemBean> poitems) {
    this.poitems = poitems;
  }

  public PoItems() {
    this.poitems = new ArrayList<>();
  }

  public PoItems(List<PoItemBean> poitems) {
    this.poitems = poitems;
  }

  public PoItemBean get(int index) {
    return this.poitems.get(index);
  }

  public int size() {
    return this.poitems.size();
  }

  public boolean add(PoItemBean poitem) {
    return this.poitems.add(poitem);
  }
}
