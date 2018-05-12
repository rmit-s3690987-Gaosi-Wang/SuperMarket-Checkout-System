
// Author Senadhi

public class Customer extends User {
	

	private LoyalityCard loyalitycard = null;

	
	public Customer(String id,String firstName, String lastName, String password) {
		super(id,firstName,lastName,password);	
	}

	
	public void addCard(LoyalityCard loyalitycard) {
		this.loyalitycard = loyalitycard;	
	}
	
	public LoyalityCard getLoyalityCard() {
		return this.loyalitycard;
		
	}
	
	public String displayRole() {
		//System.out.println("Customer");	
		return "Customer";
	}
	
	
	

}
