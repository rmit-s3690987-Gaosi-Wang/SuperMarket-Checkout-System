/**
 * Sale class.
 *
 * @author Senadhi
 * @version 1.0
 *
 */

public class LoyalityCard {
	
	private String issuer;
	private long cardNum;
	private int securityCode,loyalitypoints;
	private String expDate; // must be changed to date later on with the accepted format
	private double credit = 0;
	
	

	public LoyalityCard(String issuer, long cardNum, int securityCode, String expDate) {

		this.issuer = issuer;
		this.cardNum = cardNum;
		this.securityCode = securityCode;
		this.loyalitypoints = 0;
		this.expDate = expDate;
		
	}
	

	public LoyalityCard(String issuer, long cardNum, int securityCode, String expDate, double amount) {

		this.issuer = issuer;
		this.cardNum = cardNum;
		this.securityCode = securityCode;
		this.loyalitypoints = 0;
		this.expDate = expDate;
		this.credit = amount;
	}
	
	
	
	//Use this method to validate the CreditCard/LoyalityCard Credentials
	public boolean autheriseCharge(long cardNum, int securityCode) 
	{
		if (this.cardNum == cardNum && this.securityCode == securityCode) 
		{
			return true;	
		}
		else 
		{
			return false;
		}	
	}
	
    public void deductLoyalityPoints(int points) 
    {
    		this.loyalitypoints -=points;	
	}
    
    public void addLoyalityPoints(int points) 
    {
		this.loyalitypoints +=points;	
	}
    
    public int checkLoyalityPoints() 
    {
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
    	else {
		this.credit -=amount;
		System.out.println("Sucessful payment");
		return false;

    		}
    }
    
    //use this method to top up ( SalesStaff)
    public void addCredit(double amount) 
    {
		this.credit +=amount;	
    }
    
    public double checkCredit() 
    {
		return credit;
	}

}
