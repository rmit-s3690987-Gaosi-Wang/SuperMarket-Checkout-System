import java.util.ArrayList;


public class Supplier {
	private int supplierID;
	private String fname,lname, address,phone;
	private ArrayList<String> productList = new ArrayList<String>();
	

	public Supplier(int supplierID, String fname, String lname, String address, String phone) {
		this.supplierID = supplierID;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.phone = phone;
	
	}
	
	public void addproduct(String pname) {
		productList.add(pname);		
	}
	
	public String getProducts() {		
		return productList.toString();		
	}
	

}
