public abstract class User {
    private String id;
    private String password ;
    private String firstName;
    private String lastName ;

    public User(String id, String password, String firstName, String lastName) {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
