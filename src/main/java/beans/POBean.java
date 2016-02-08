package beans;

/**
 * 
 * @author Skyler Layne on Feb 8, 2016
 *
 */
public class POBean {

	/*
	 * id INT UNSIGNED NOT NULL AUTO_INCREMENT, lname VARCHAR(20) NOT NULL,
	 * fname VARCHAR(20) NOT NULL, status ENUM('ORDERED','PROCESSED','DENIED')
	 * NOT NULL, address INT UNSIGNED NOT NULL, PRIMARY KEY(id), INDEX
	 * (address), FOREIGN KEY (address) REFERENCES Address (id) ON DELETE
	 * CASCADE
	 */

	private int id;
	private String lname;
	private String fname;
	private String status;
	private AddressBean address;

	public POBean(int id, String lname, String fname, String status, AddressBean address) {
		this.id = id;
		this.lname = lname;
		this.fname = fname;
		this.status = status;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AddressBean getAddress() {
		return address;
	}

	public void setAddress(AddressBean address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PO: [" + this.id + ", " + this.lname + ", " + this.fname + ", " + this.status + ", " + this.address + "]";
	}

}
