
public class Customer extends User {
	
	private int custID, age;
	private String firstName,lastName, gender, address, password;
	//private LoyalityCard loyalitycard;

	
	public Customer(int custID, String firstName, String lastName, int age, String gender, String address, String password) {
		
		super(firstName,lastName,age,gender,address,password);
		this.custID = custID;	
	}

	//public void addCard(LoyalityCard loyalitycard) {
		
		//this.loyalitycard = loyalitycard;
		
		
		
	//}
	
	

}
