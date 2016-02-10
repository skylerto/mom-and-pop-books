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
	 *            - primary key of the address.
	 * @param street
	 *            - The street which the address resides.
	 * @param province
	 *            - The province which the address resides.
	 * @param country
	 *            - The country which the address resides.
	 * @param zip
	 *            - The zipcode/postalcode which the address resides.
	 * @param phone
	 *            - The phone number which the address resides.
	 */
	public AddressBean(int id, String street, String province, String country, String zip, String phone) {
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
	 *            - the new id.
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
	 *            - the new street
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
	 *            - the new province.
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Address: [" + this.id + ", " + this.street + ", " + this.province + ", " + this.country + ", "
				+ this.zip + ", " + this.phone + "]";
	}

}
