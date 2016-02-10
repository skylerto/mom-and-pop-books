package beans;

/**
 * AddressBean - Address class.
 * 
 * @author Skyler Layne on Jan 9, 2016
 * @version 0.0.1
 */
public class AddressBean {

  /**
   * primary key of the address.
   */
  private int id;
  /**
   * The street which the address resides.
   */
  private String street;
  /**
   * The province which the address resides.
   */
  private String province;
  /**
   * The country which the address resides.
   */
  private String country;
  /**
   * The zipcode/postalcode which the address resides.
   */
  private String zip;
  /**
   * The phone number which the address resides.
   */
  private String phone;

  /**
   * AddressBean Constructor.
   * 
   * @param id
   *          - primary key of the address.
   * @param street
   *          - The street which the address resides.
   * @param province
   *          - The province which the address resides.
   * @param country
   *          - The country which the address resides.
   * @param zip
   *          - The zipcode/postalcode which the address resides.
   * @param phone
   *          - The phone number which the address resides.
   */
  public AddressBean(int id, String street, String province, String country, String zip,
      String phone) {
    this.id = id;
    this.street = street;
    this.province = province;
    this.country = country;
    this.zip = zip;
    this.phone = phone;
  }

  /**
   * The id of the address.
   * 
   * @return - The id of the address.
   */
  public int getId() {
    return id;
  }

  /**
   * Change the id of the address.
   * 
   * @param id
   *          - the new id.
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Get the street of the address.
   * 
   * @return - the street
   */
  public String getStreet() {
    return street;
  }

  /**
   * Change the address street.
   * 
   * @param street
   *          - the new street
   */
  public void setStreet(String street) {
    this.street = street;
  }

  /**
   * Get the province of the address.
   * 
   * @return - the province.
   */
  public String getProvince() {
    return province;
  }

  /**
   * Change the province of the address.
   * 
   * @param province
   *          - the new province.
   */
  public void setProvince(String province) {
    this.province = province;
  }

  /**
   * Get the country which the address is in.
   * 
   * @return - the country.
   */
  public String getCountry() {
    return country;
  }

  /**
   * Change the country which the address is in.
   * 
   * @param country
   *          - the new country.
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * Get the zipcode or postalcode of the address.
   * 
   * @return - the zip/postal code.
   */
  public String getZip() {
    return zip;
  }

  /**
   * Set the zip code of the address.
   * 
   * @param zip
   *          - the new zip code.
   */
  public void setZip(String zip) {
    this.zip = zip;
  }

  /**
   * Get the address phone number.
   * 
   * @return - the phone number.
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Set the address phone number.
   * 
   * @param phone
   *          - the new number.
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Return a string representation of the address.
   */
  @Override
  public String toString() {
    return "Address: [" + this.id + ", " + this.street + ", " + this.province + ", " + this.country
        + ", " + this.zip + ", " + this.phone + "]";
  }

}
