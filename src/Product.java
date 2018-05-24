/**
 * Product class.
 *
 * @author Pavan
 * @version 1.0
 *
 */

public class Product {
   private String prodID;
   private String productName;
   private double unitPrice;
   private double salesPrice;
   private double bulk;
   private double bulkPrice;
   private double quantity;
   private double replenishLine;
   private double replenishQuantity;
   private String unit = "EA, KG";
   private boolean onSale = false;
  
   private Supplier supplier;



  

   public String getProdID() {
      return prodID;
   }
   public void setProdID(String prodID) {
      this.prodID = prodID;
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
   public double getSalesPrice() {
      return salesPrice;
   }
   public void setSalesPrice(double salesPrice) {
      this.salesPrice = salesPrice;
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
   public void setQuantity(double quantity) {
      this.quantity = quantity;
   }
   public double getReplenishLine() {
      return replenishLine;
   }
   public void setReplenishLine(double replenishLine) {
      this.replenishLine = replenishLine;
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
   public boolean isOnSale() {
      return onSale;
   }
   public void setOnSale(boolean onSale) {
      this.onSale = onSale;
   }
public Supplier getSupplier() {
	return supplier;
}
public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}
public Product(String prodID, String productName, double unitPrice, double salesPrice, double bulk, double bulkPrice,
		double quantity, double replenishLine, double replenishQuantity, String unit, boolean onSale,
		Supplier supplier) {
	super();
	this.prodID = prodID;
	this.productName = productName;
	this.unitPrice = unitPrice;
	this.salesPrice = salesPrice;
	this.bulk = bulk;
	this.bulkPrice = bulkPrice;
	this.quantity = quantity;
	this.replenishLine = replenishLine;
	this.replenishQuantity = replenishQuantity;
	this.unit = unit;
	this.onSale = onSale;
	this.supplier = supplier;
}

  




}
