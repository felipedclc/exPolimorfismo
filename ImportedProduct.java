package entities;

public class ImportedProduct extends Product {

	private Double customsFee;

	public ImportedProduct() {
		super();

	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

	public void totalPrice(double price) {
		price += customsFee;
	}

	@Override
	public String priceTag() {
		return "\n" + name + "$ " + price + "(Customs fee: $ " + String.format("%.2f", customsFee) + ")";
	}
 }
