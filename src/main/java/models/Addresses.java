package models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import beans.AddressBean;

/**
 * Holds the state of a list of Addresses.
 * 
 * @author Skyler Layne on Feb 17, 2016
 *
 */
@XmlRootElement(name = "addresses")
public class Addresses {

  private List<AddressBean> addresses;

  public List<AddressBean> getAddresses() {
    return addresses;
  }

  @XmlElement(name = "address")
  public void setAddresses(List<AddressBean> addresses) {
    this.addresses = addresses;
  }

  public Addresses() {
    addresses = new ArrayList<>();
  }

  public Addresses(List<AddressBean> addresses) {
    this.setAddresses(addresses);
  }

  public boolean add(AddressBean address) {
    return this.addresses.add(address);
  }

  public int size() {
    return this.addresses.size();
  }

  public AddressBean get(int i) {
    return this.addresses.get(i);
  }
}
