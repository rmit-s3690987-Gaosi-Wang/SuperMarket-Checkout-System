import java.util.ArrayList;

public class Product {
    private String productID;
    private String productName;
    private double unitPrice;
    private double salePrice;
    private double bulk;
    private double bulkPrice;
    private double quantity;
    private double replenishLine;
    private double replenishQuantity;
    private String unit;
    private String supplier;
    private boolean onSale = false;
    ArrayList<Supplier> suppliers = new ArrayList<Supplier>();

    public Product(String productID, String productName, double unitPrice, double salePrice,
                   double bulk, double bulkPrice, double quantity, double replenishLine, double replenishQuantity,
                   String unit, boolean onSale, Supplier supplier) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.salePrice = salePrice;
        this.bulk = bulk;
        this.bulkPrice = bulkPrice;
        this.quantity = quantity;
        this.replenishLine = replenishLine;
        this.replenishQuantity = replenishQuantity;
        this.unit = unit;
        this.onSale = onSale;
        suppliers.add(supplier);
}
    public Product(String productID, String productName, double unitPrice, double salePrice,
                   double bulk, double bulkPrice, double quantity, double replenishLine, double replenishQuantity,
                   String unit, boolean onSale) {
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.salePrice = salePrice;
        this.bulk = bulk;
        this.bulkPrice = bulkPrice;
        this.quantity = quantity;
        this.replenishLine = replenishLine;
        this.replenishQuantity = replenishQuantity;
        this.unit = unit;
        this.onSale = onSale;;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getBulk() {
        return bulk;
    }

    public void setBulk(double bulk) {
        this.bulk = bulk;
    }

    public double getBulkPrice() {
        return bulkPrice;
    }

    public void setBulkPrice(double bulkPrice) {
        this.bulkPrice = bulkPrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getReplenishLine() {
        return replenishLine;
    }

    public void setReplenishLine(double replenishLine) {
        this.replenishLine = replenishLine;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getReplenishQuantity() {
        return replenishQuantity;
    }

    public void setReplenishQuantity(double replenishQuantity) {
        this.replenishQuantity = replenishQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void printSupplier() {
        for (int i = 0; i <suppliers.size() ; i++) {
            System.out.println(suppliers.get(i));
        }
    }

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }


   enum  units {
        EA,
        KG;
    }


}
