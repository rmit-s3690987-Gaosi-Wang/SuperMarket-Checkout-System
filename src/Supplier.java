/**
 * Product class.
 *
 * @author Pavan
 * @version 1.0
 *
 */

public class Supplier {
    private String supplierID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    public Supplier (String supplierID, String firstName, String lastName, String address) {
        this.supplierID = supplierID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
}
