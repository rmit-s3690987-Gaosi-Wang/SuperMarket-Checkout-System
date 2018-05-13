/**
 * Sale class.
 *
 * @author Senadhi
 * @version 1.0
 *
 */

public abstract class User {
   private String firstName, lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName  = lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }
	
//	public boolean authenticateUser(String id, String passowrd) {
//		if (this.id.equals(id) && this.password.equals(password)) {
//			return true;
//		}else {
//		return false;
//		}
//	}
	
	public String displayRole(Object a) {
		if ( a instanceof Customer ) {
			return "Customer";
		}
		else if ( a instanceof SalesStaff ) {
			return"SalesStaff";
		}
		else if ( a instanceof StoreManager ) {
			return "StoreManager";
		}
		if ( a instanceof WHManager) {
			return "WearhouseManager";
		}	
		else {
			return "Not an Entiity";
		}
		
	}
	
}
