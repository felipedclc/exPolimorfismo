package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
	
	SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");

	private Date manufacturateDate;
	
	public UsedProduct() {
		super();
		
	}

	public UsedProduct(String name, Double price, Date manufacturateDate) {
		super(name, price);
		this.manufacturateDate = manufacturateDate;
	}

	public Date getManufacturateDate() {
		return manufacturateDate;
	}
	
	@Override
	public String priceTag() {
		return "\n" + name + "(used) " + "$ " + String.format("%.2f",price) + "(Manufaturate date: (" + sdf.format(manufacturateDate) + ")";
	}
}
