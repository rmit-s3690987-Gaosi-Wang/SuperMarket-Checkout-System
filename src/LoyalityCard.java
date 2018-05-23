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
	
	
<<<<<<< HEAD

	public LoyalityCard(String issuer, long cardNum, int securityCode, String expDate) {

=======
	public LoyalityCard(SalesStaff issuer, String cardNum, String securityCode, Date expDate) {
>>>>>>> 621307869ec2c1d8da5c84a3cd845cbb5d7d4539
		this.issuer = issuer;
		this.cardNum = cardNum;
		this.securityCode = securityCode;
		this.loyalitypoints = 0;
		this.expDate = expDate;
		
	}
	
<<<<<<< HEAD

	public LoyalityCard(String issuer, long cardNum, int securityCode, String expDate, double amount) {

=======
	public LoyalityCard(SalesStaff issuer, String cardNum, String securityCode, Date expDate, double amount) {
>>>>>>> 621307869ec2c1d8da5c84a3cd845cbb5d7d4539
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
	
    public void deductLoyalityPoints(int points) {
    		this.loyalitypoints -=points;	
	}
    
    public void addLoyalityPoints(int points) {
		this.loyalitypoints +=points;	
	}
    
    public int checkLoyalityPoints() {
		return loyalitypoints;
	}
    
    //Use this method when purchasing.
    public boolean spendCredit(double amount) { 
    		if ( this.credit < amount) {
    			System.out.println("You Do not have Suffitient Funds !! Please Recharge");
    			return false;


    		} 
    	else {
		this.credit -=amount;
<<<<<<< HEAD
		System.out.println("Sucessful payment");
		return false;


=======
		return true;
>>>>>>> 621307869ec2c1d8da5c84a3cd845cbb5d7d4539
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
