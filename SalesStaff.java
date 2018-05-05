import java.util.Date;

public class SalesStaff extends Employee {

	public SalesStaff(String id,String firstName, String lastName, String password) {
		super(id,firstName,lastName,password);	
	}
	
	
	public boolean removeCartItem(Sale sale,SaleLineItem item) {
		sale.removeItem(item); // this method must be implemented in Sale Class
		return true; // for testing, remove later on
	}
	
	
	public boolean cancelCart(Sale sale) {
	   Store.removeSale(sale);// this method must be implemented by Store Static Class
	   return true ; // for testing ,remove later on
	}
	
	
	public boolean topupCredit(LoyalityCard card,double amount) {
			card.addCredit(amount);
			return true;
	}
	
	
	public boolean sellcard(Customer customer,long cardNum, int securityCode, String expDate ){	
		LoyalityCard card = new LoyalityCard(this,cardNum,securityCode,expDate);
		customer.addCard(card);
		return true;
		//change expDate type to Date later on
	}
	

	
	

}