public abstract class User {
   private String firstName,lastName;

   public User (String firstName, String lastName) {
      
      this.firstName = firstName;
      this.lastName  = lastName;
     
   }

   public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getName() {
      return firstName + " " + lastName;
   }

   

   

   

   //   to show menu
   public abstract void menu();

}
