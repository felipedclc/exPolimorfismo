package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + "data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if (ch == 'c') {
				Product prod = new Product(name, price);
				list.add(prod);
			}
			if (ch == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				ImportedProduct imp = new ImportedProduct(name, price, customsFee);
				list.add(imp);
			}
			if (ch == 'u') {
				System.out.print("Manufacturate date(MM/YYYY): ");
				Date manufacturateDate = sdf.parse(sc.next());
				UsedProduct used = new UsedProduct(name, price, manufacturateDate);
				list.add(used);
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}

		sc.close();
	}

}
