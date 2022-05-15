package io.apicode.csvprocessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A popcorn costs 7$, a soda costs 2.5$, when bought together they cost 9$.
 * Given an input list of dates and the name of the items bought, find the total
 * amount spent. All pairs of soda and popcorn should be treated as a bundle if
 * they were bought on the same date, even if they are not bought one after the
 * other.
 * 
 * @author rajeevsingla
 *
 */

public class Sorting {

	public static void main(String[] args) {

		Sorting sort = new Sorting();

		Map<String, Double> priceData = sort.priceData();
		List<ProductData> productDataList = sort.productData();

		Map<String, Map<String, Integer>> count = new HashMap<>();

		Double totalCost = 0.0;

		for (ProductData productData : productDataList) {
			Map<String, Integer> map = null;
			if (count.get(productData.getDate()) != null) {
				map = count.get(productData.getDate());
			} else {
				map = new HashMap<>();
			}
			String product = productData.getItem();
			map.put(product, 1 + map.getOrDefault(product, 0));
			count.put(productData.getDate(), map);
		}

		for (String date : count.keySet()) {

			Map<String, Integer> data = count.get(date);

			int totalPopcorn = data.get("popcorn") == null ? 0 : data.get("popcorn");
			int totalSoda = data.get("soda") == null ? 0 : data.get("soda");

			int combine = Math.min(totalPopcorn, totalSoda);

			totalCost = totalCost + (combine * priceData.get("combine"));

			totalCost = totalCost + ((totalPopcorn - combine) * priceData.get("popcorn"));
			totalCost = totalCost + ((totalSoda - combine) * priceData.get("soda"));

		}

		System.out.println(totalCost);

	}

	public List<ProductData> productData() {

		List<ProductData> productPurchase = new ArrayList<>();
		ProductData p1 = new ProductData("12-10-2022", "popcorn", 7.0);
		ProductData p2 = new ProductData("12-10-2022", "soda", 2.5);
		ProductData p3 = new ProductData("12-10-2022", "soda", 2.5);
		ProductData p4 = new ProductData("12-10-2022", "soda", 2.5);
		ProductData p5 = new ProductData("11-10-2022", "soda", 2.5);
		ProductData p6 = new ProductData("11-10-2022", "popcorn", 7.0);
		ProductData p7 = new ProductData("12-11-2022", "popcorn", 7.0);

		productPurchase.add(p1);
		productPurchase.add(p2);
		productPurchase.add(p3);

		productPurchase.add(p4);
		productPurchase.add(p5);
		productPurchase.add(p6);
		productPurchase.add(p7);

		return productPurchase;

	}

	public Map<String, Double> priceData() {

		Map<String, Double> priceData = new HashMap<>();
		priceData.put("popcorn", 7.0);
		priceData.put("soda", 2.5);
		priceData.put("combine", 9.0);

		return priceData;

	}

}

class ProductData {
	String date;
	String item;
	Double price;

	public ProductData(String date, String item, Double price) {
		super();
		this.date = date;
		this.item = item;
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public String getItem() {
		return item;
	}

	public Double getPrice() {
		return price;
	}

}
