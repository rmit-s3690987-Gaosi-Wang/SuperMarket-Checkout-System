import java.util.ArrayList;

public class Supplier {
	
	private String supplierID;
	private String Fname;
	private String Iname;
	private String Address;
	private int phone;
	
	
	
	public Supplier(String supplierID, String fname, String iname, String address, int phone) {
		
		this.supplierID = supplierID;
		Fname = fname;
		Iname = iname;
		Address = address;
		this.phone = phone;
	}
	
	
	public String getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getIname() {
		return Iname;
	}
	public void setIname(String iname) {
		Iname = iname;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
	

}
