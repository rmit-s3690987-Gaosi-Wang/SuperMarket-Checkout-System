public abstract class Employee extends User {
    public Employee(String employeeID, String password, String firstName, String lastName) {
        super(employeeID, password, firstName, lastName);
    }

    public void checkStock(Product product) {
        System.out.println("The current stock quantity of the product "+product.getProductName() +" is "+ product.getQuantity());
        try {
            if (product.getQuantity() < product.getReplenishLine()) {
                replenish(product, product.getUnit());
            }
            System.out.println("automatically replenish product " + product.getProductName() +" " + product.getProductID()+
                    " of " + product.getReplenishQuantity()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void replenish(Product product, String unit) {
        product.setQuantity(product.getQuantity() + product.getReplenishQuantity());
        product.setUnit(unit);
    }
}