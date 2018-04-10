import java.util.*;

public class CreditCard {
	
	private String issuer;
	private long cardNum;
	private int securityCode,loyalitypoints;
	private Date expDate;
	private Customer customer;
	
	

	public CreditCard(String issuer, long cardNum, int securityCode, Date expDate, Customer customer) {
		this.issuer = issuer;
		this.cardNum = cardNum;
		this.securityCode = securityCode;
		this.loyalitypoints = 0;
		this.expDate = expDate;
		this.customer = customer;
		
		
	}
	

}
