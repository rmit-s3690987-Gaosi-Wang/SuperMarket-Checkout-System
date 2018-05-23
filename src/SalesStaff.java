/**
 * User - Employee - SaleStaff class.

 *
 * @author Senadhi
 * @version 1.0
 *
 */
//
import java.util.Date;

public class SalesStaff extends Employee {

   public SalesStaff(String id, String password, String firstName, String lastName) {
      super(id,password,firstName,lastName);
   }

   public static LoyalityCard createCard(SalesStaff sStaff,String cardNum, String securityCode, Date expDate) {
      LoyalityCard card = new LoyalityCard(sStaff,cardNum,securityCode,expDate);
      return card;

   }

	public boolean removeCartItem(Sale sale, String itemID) {
		boolean removed = sale.deleteitem(itemID); 
		return removed; 
	}
	
	
	public boolean topupCredit(LoyalityCard card,double amount) {
			card.addCredit(amount);
			return true;
	}
	
	
   public static boolean sellcard(Customer customer, SalesStaff issuer,String cardNum, String securityCode, Date expDate ){
      customer.addCard(createCard(issuer, cardNum, securityCode, expDate));
      return true;
   }

   public void displayRole() {
     System.out.println("SalesStaff");
   }

}
