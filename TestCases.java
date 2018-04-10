import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class TestCases {
	
	@Before
	void setup() {
	
	}
	

	@Test
	void test() {
		Customer cust1 = new Customer(1, "John", "Cena" , 25, "male", "73 Bruce Street, Mount Waverley", "123");		
		assertEquals("123",cust1.getPassword())	;	
		assertTrue(cust1 instanceof Customer);
	}
	
	@Test
	void test2() {
		
		Supplier sup1 = new Supplier(1,"John", "Snow", "45 PineWood Drive , Glen Waverley","32443458");
		assertTrue(sup1.addproduct("Iphone x"));
		
	}
}
