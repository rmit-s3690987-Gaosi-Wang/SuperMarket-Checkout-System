import java.util.Date;

/**
 * Sale class.
 *
 * @author Senadhi
 * @version 1.0
 *
 */

public class LoyalityCard {
	
	private SalesStaff issuer;
	private String cardNum, securityCode;
	private int loyalitypoints;
	private Date expDate; 
	private double credit = 0;
	

	public LoyalityCard(SalesStaff issuer, String cardNum, String securityCode, Date expDate) {

		this.issuer = issuer;
		this.cardNum = cardNum;
		this.securityCode = securityCode;
		this.loyalitypoints = 0;
		this.expDate = expDate;
		
	}
	
	public LoyalityCard(SalesStaff issuer, String cardNum, String securityCode, Date expDate, double amount) {

		this.issuer = issuer;
		this.cardNum = cardNum;
		this.securityCode = securityCode;
		this.loyalitypoints = 0;
		this.expDate = expDate;
		this.credit = amount;
	}
	
	//Use this method to validate the CreditCard/LoyalityCard Credentials
	public boolean autheriseCharge(String cardNum, String securityCode) {
		if (this.cardNum.equals(cardNum) && this.securityCode.equals(securityCode)) {
			return true;	
		}else {
			return false;
		}	
	}
	
    public boolean deductLoyalityPoints(int points) {
    		if (this.loyalitypoints >= points) {
    		this.loyalitypoints -=points;
    		return true;
    		} else {return false;}
	}
    
    public void addLoyalityPoints(int points) {
		this.loyalitypoints +=points;	
	}
    
    public int checkLoyalityPoints() {
		return loyalitypoints;
	}
    
    //Use this method when purchasing.
    public boolean spendCredit(double amount) 
    { 
    	if ( this.credit < amount) 
    	{
    		System.out.println("You Do not have Suffitient Funds !! Please Recharge");
    		return false;


    	} 
    	else 
    	{
    		System.out.println("credit before payment               "+this.credit);
    		this.credit -=amount;
    		System.out.println("credit after payment           " + this.credit);
    		System.out.println("Sucessful payment");
    		return true;

    	}

    }
    
    
    //use this method to top up ( SalesStaff)
    public void addCredit(double amount) {
		this.credit +=amount;	
    }
    
    public double checkCredit() {
		return credit;
	}

}
