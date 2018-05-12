public class Customer extends User {

   
   private String customerID;
   private String loyaltyCardNumber;

  
   public Customer(String firstName, String lastName, String customerID, String loyaltyCardNumber) {
	super(firstName, lastName);
	this.customerID = customerID;
	this.loyaltyCardNumber = loyaltyCardNumber;
}



public String getCustomerID() {
	return customerID;
}



public void setCustomerID(String customerID) {
	this.customerID = customerID;
}



@Override
   public void menu() {

   }
}
