/**
 * Product class.
 *
 * @author Pavan
 * @version 1.0
 *
 */

public class Supplier {
    private String supplierID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    public String getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Supplier (String supplierID, String firstName, String lastName, String address) {
        this.supplierID = supplierID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
	
	
}
