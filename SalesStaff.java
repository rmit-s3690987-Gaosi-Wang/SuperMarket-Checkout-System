//auther Senadhi

import java.util.Date;

public class SalesStaff extends Employee {

<<<<<<< HEAD
   public SalesStaff(String id,String firstName, String lastName, String password) {
      super(id,firstName,lastName,password);
   }


   //   public boolean removeCartItem(Sale sale, SaleLine item) {
   //      sale.deleteitem(item); // this method must be implemented in Sale Class
   //      return true; // for testing, remove later on
   //   }
   //
   //
   //   public boolean cancelCart(Sale sale) {
   //      Store.removeSale(sale);// this method must be implemented by Store Static Class
   //      return true ; // for testing ,remove later on
   //   }


   public boolean topupCredit(LoyalityCard card,double amount) {
      card.addCredit(amount);
      return true;
   }


//   public boolean sellcard(Customer customer,long cardNum, int securityCode, String expDate ){
//      //LoyalityCard card = new LoyalityCard(this,cardNum,securityCode,expDate);
//      customer.addCard(this.createCard(this, cardNum, securityCode, expDate));
//      return true;
//      //change expDate type to Date later on
//   }

   

   public LoyalityCard createCard(SalesStaff sStaff,long cardNum, int securityCode, String expDate) {
      LoyalityCard card = new LoyalityCard(sStaff,cardNum,securityCode,expDate);
      return card;

   }

=======
	public SalesStaff(String id,String firstName, String lastName, String password) {
		super(id,firstName,lastName,password);	
	}
	
	
	public boolean removeCartItem(Sale sale,SaleLineItem item) {
		//sale.deleteitem(item); // this method must be implemented in Sale Class
		return true; // for testing, remove later on
	}
	
	
	public boolean cancelCart(Sale sale) {
	//   Store.(sale);// this method must be implemented by Store Static Class
	   return true ; // for testing ,remove later on
	}
	
	
	public boolean topupCredit(LoyalityCard card,double amount) {
			card.addCredit(amount);
			return true;
	}
	
	
	public boolean sellcard(Customer customer,long cardNum, int securityCode, String expDate ){	
		//LoyalityCard card = new LoyalityCard(this,cardNum,securityCode,expDate);
		customer.addCard(this.createCard(this, cardNum, securityCode, expDate));
		return true;
		//change expDate type to Date later on
	}
	
	public void displayRole() {
		System.out.println("SalesStaff");	
	}
	
	public LoyalityCard createCard(SalesStaff sStaff,long cardNum, int securityCode, String expDate) {
		LoyalityCard card = new LoyalityCard(sStaff,cardNum,securityCode,expDate);
		return card;
		
	}
		
>>>>>>> 68f6feb6271fd33edad73cc1d9b287f725001c9a

}
