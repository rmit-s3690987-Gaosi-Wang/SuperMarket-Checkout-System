/**
 * User - Customer class.
 *
 * @author Senadhi
 * @version 1.0
 *
 */

public class Customer extends User {

   private String custID;
   private LoyalityCard loyalitycard;

    public Customer(String custID, String firstName, String lastName) {
        super(firstName,lastName);
        this.custID = custID;
    }

   public String getCustID() {
      return custID;
   }

    public void addCard(LoyalityCard loyalitycard) {
        this.loyalitycard = loyalitycard;
    }

    public LoyalityCard getLoyalityCard() {
        return this.loyalitycard;
    }

    public String displayRole() {
        
        return "Customer";
    }
}
