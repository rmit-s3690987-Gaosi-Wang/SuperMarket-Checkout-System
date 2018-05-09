import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	
	ArrayList<Product> ProdNew =  new ArrayList<Product>();
	ArrayList<Supplier> supplier = new ArrayList<Supplier>();
	Product product;
	Scanner sc = new Scanner(System.in);
	
	public Manager()
	{
		this.existingProducts();
		this.existingSupplier();
	}
	
	public void existingProducts()
	{
		ProdNew.add(new Product("P101", "ABC", 10, 8, 10, 9, 20, 20, 20, "EA", false, "s101"));
		ProdNew.add(new Product("P102", "XYZ", 15, 10, 10, 12, 20, 20, 20, "EA", false, "s102"));
		ProdNew.add(new Product("P103", "PQR", 12, 8, 10, 10, 20, 20, 20, "EA", false, "s101"));
		ProdNew.add(new Product("P104", "LMN", 18, 15, 10, 14, 20, 20, 20, "EA", false, "s103"));
		ProdNew.add(new Product("P105", "HJK", 1, 0.90, 10, 0.80, 20, 20, 20, "EA", false, "s102"));
		ProdNew.add(new Product("P106", "ASD", 122, 110, 10, 104, 20, 20, 20, "EA", false, "s103"));
		ProdNew.add(new Product("P107", "WER", 89, 70, 10, 72, 20, 20, 20, "EA", false, "s101"));
		ProdNew.add(new Product("P108", "TYU", 23, 15, 10, 18, 20, 20, 20, "EA", false, "s102"));
	}
	
	
	
	public void existingSupplier()
	{
		supplier.add(new Supplier("s101", "Dou", "Duplin", "23, abc drive", 123456789));
		supplier.add(new Supplier("s102", "Trip", "Tripple", "52, geelong", 147852369));
		supplier.add(new Supplier("s103", "Four", "Fourth", "8, Melb", 789654123));
	}
	
	public void addProduct()
	{
		
		System.out.println("please enter Product Id : ");
		String id =  sc.nextLine();
		System.out.println("please enter name : ");
		String name = sc.nextLine();
		System.out.println("Please enter Unit Price : ");
		double UnitPrice = sc.nextDouble();
		System.out.println("Please enter Sales Price : ");
		double SalesPrice = sc.nextDouble();
		System.out.println("Please enter Bulk amount : ");
		double Bulk = sc.nextDouble();
		System.out.println("Please enter Bulk price : ");
		double BulkPrice = sc.nextDouble();
		System.out.println("Please enter quantity : ");
		int quantity = sc.nextInt();
		System.out.println("Please enter Replenish line : ");
		double ReplenishLine = sc.nextDouble();
		System.out.println("Please enter Replenish Quantity : ");
		double ReplenishQuantity = sc.nextDouble();
		System.out.println("Please enter Unit Of Measure {EA/KG} : ");
		String unit = sc.nextLine();
		System.out.println("Please enter Supplier ID : ");
		String SupplierId = sc.nextLine();
		
		ProdNew.add(new Product(id,name, UnitPrice, SalesPrice, Bulk, BulkPrice, quantity, ReplenishLine, ReplenishQuantity, unit,product.isOnSale() , SupplierId));
	}
	
	public void setUnitPrice()
	{
		
		for(Product product:this.ProdNew) {
			System.out.println(product.getProdID() + " " +product.getProductName() + " " + product.getUnitPrice() ) ;
		}
		System.out.println("Please enter the product Id : ");
		String ProdId = sc.nextLine();
		boolean productExists = false;
		for(Product p : this.ProdNew)
		{
			if(p.getProdID().equals(ProdId))
			{
				System.out.println("Enter new unit price");
				double newUnitPrice = sc.nextDouble();
				p.setUnitPrice(newUnitPrice);
				System.out.println("Changed");
				productExists = true;
				break;
			}
		}
		if(!productExists) System.out.println("Product doesn't Exist");
		
//		for(Product p : this.ProdNew){System.out.println(p.getProdID() + " " +p.getUnitPrice());}
		
		
		
	}
	public void getProductbySupplierID()
	{
		System.out.println("Please enter supplier ID : ");
		String id = sc.nextLine();
		for(Product p : this.ProdNew)
		{
			if(p.getSupplierId().equals(id))
			{
				System.out.println(p.getProdID() +" "+p.getProductName());
			}
		}
	}
}
