import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;


class TestCases {

	Customer cust1 = new Customer("C001","Bruce","Wayne","123");	
	SalesStaff sStaff = new SalesStaff("s1", "Killer", "Bee", "s123");
	Sale sale = new Sale();
	SaleLineItem sitem = new SaleLineItem();
	LoyalityCard lCard = new LoyalityCard(sStaff, 1234567, 123, "2020-09-12");
	
	@Before
	void setup() {
	
		
	}
	
	@Test //testing Customer and User Class
	void test() {	
		Customer cust = new Customer("C000","Baristan","Selmy","c123"); // checking the initiation or customer instance creation
		
		assertTrue(cust instanceof Customer); // checking the method type
		
		assertTrue(cust.authenticateUser("C000", "c123")); // checking the customer Authentication method	
		
		// addCard() method testing
		cust.addCard(lCard);
		assertEquals(lCard,cust.getLoyalityCard());
		
		
		
	}
	
	@Test //testing SalesStaff Class
	void test2() {
		
		SalesStaff sStaff1 = new SalesStaff("s2", "David", "Nill", "s123"); // Class Initiation
		assertTrue(sStaff1.sellcard(cust1,1234543, 123, "2021-09-12")); // Selling a card
		
		assertTrue(sStaff1.topupCredit(lCard, 50)); // top-up credit method
		
		assertTrue(sStaff1.removeCartItem(sale,sitem)); // removing an item from a cart ( Sale )
		
		assertTrue(sStaff1.cancelCart(sale)); // Cancel a cart ( Sale )
				
	}
	
	
	@Test //testing LoyalityCard Class
	void test3() {
		cust1.addCard(lCard);
		
		assertTrue(lCard.autheriseCharge(1234567, 123)); // validate card credentials 
		
			
		lCard.addLoyalityPoints(20);
		assertEquals(20,lCard.checkLoyalityPoints()); // checking add Loyality points
		
		lCard.deductLoyalityPoints(5);
		assertEquals(15,lCard.checkLoyalityPoints()); // checking deduct Loyality points
		
		
		lCard.addCredit(30);
		assertEquals(30,lCard.checkCredit()); // checking add credit method
		
		lCard.spendCredit(10);
		assertEquals(20,lCard.checkCredit());// checking spend credit method
			
	}
	
	
	
	
	
	
	
	

}
