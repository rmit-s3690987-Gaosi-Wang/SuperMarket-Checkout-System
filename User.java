
public abstract class User {
	private String firstName,lastName, gender, address, password;
	private int age;

	public User(String firstName, String lastName, int age, String gender, String address, String password) {		
		this.firstName = firstName;
		this.lastName  = lastName;
		this.age  = age;
		this.gender = gender;
		this.address = address;
		this.password = password;
	}
	

	public String getName() {
		return firstName + lastName;	
	}
	
	
	

}
