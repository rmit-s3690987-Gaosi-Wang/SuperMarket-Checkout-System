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
	
}
