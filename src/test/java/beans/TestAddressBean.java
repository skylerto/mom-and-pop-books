package beans;

import junit.framework.TestCase;

public class TestAddressBean extends TestCase {

	AddressBean address;

	// AddressBean fields
	int aid = 1;
	String street = "some street";
	String province = "ON";
	String country = "CA";
	String zip = "M3J1P3";
	String phone = "905 960 6578";

	protected void setUp() throws Exception {
		super.setUp();
		address = new AddressBean(aid, street, province, country, zip, phone);
	}

	protected void tearDown() throws Exception {
		address = null;
	}

	public void testAddressBean() {
		address = new AddressBean(aid, street, province, country, zip, phone);
	}

	public void testGetId() {
		assertEquals(aid, address.getId());
	}

	public void testSetId() {
		address.setId(2);
		assertEquals(2, address.getId());
	}

	public void testGetStreet() {
		assertEquals(street, address.getStreet());
	}

	public void testSetStreet() {
		address.setStreet("other lane");
		assertEquals("other lane", address.getStreet());
	}

	public void testGetProvince() {
		assertEquals(province, address.getProvince());
	}

	public void testSetProvince() {
		address.setProvince("AB");
		assertEquals("AB", address.getProvince());
	}

	public void testGetCountry() {
		assertEquals(country, address.getCountry());
	}

	public void testSetCountry() {
		address.setCountry("USA");
		assertEquals("USA", address.getCountry());
	}

	public void testGetZip() {
		assertEquals(zip, address.getZip());
	}

	public void testSetZip() {
		address.setZip("M4J1K2");
		assertEquals("M4J1K2", address.getZip());
	}

	public void testGetPhone() {
		assertEquals(phone, address.getPhone());
	}

	public void testSetPhone() {
		address.setPhone("9054768976");
		assertEquals("9054768976", address.getPhone());
	}

	public void testToString() {
		String res = "Address: [" + address.getId() + ", " + address.getStreet() + ", " + address.getProvince() + ", "
				+ address.getCountry() + ", " + address.getZip() + ", " + address.getPhone() + "]";
		assertEquals(res, address.toString());
	}

}
