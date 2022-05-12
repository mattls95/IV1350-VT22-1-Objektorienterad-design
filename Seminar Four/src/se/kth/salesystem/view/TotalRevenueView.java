package se.kth.salesystem.view;

import java.util.HashMap;

import se.kth.salesystem.model.SaleObserver;
import se.kth.salesystem.model.Total;
import se.kth.salesystem.util.Logger;

public class TotalRevenueView implements Logger, SaleObserver {
	private HashMap<Total, Integer> totalRevenueAndSaleNumber = new HashMap<>();
	private double totalRevenue;
	private Integer saleNumber = 0;


	/**
	 * Prints the specified string to the log file.
	 */
	@Override
	public void log() {
		System.out.println("Number of sales made: " + saleNumber + " Total Revenue: " + this.totalRevenue);
	}

	/**
	 * Calculates the total revenue based on the total amount of a new sale
	 * 
	 * @param total The total amount that the total revenue will be updated with
	 */
	@Override
	public void newSale(Total total) {
		saleNumber++;
		totalRevenueAndSaleNumber.put(total, saleNumber);
		totalRevenue += total.getTotalIncludingVAT().getAmount();
		log();
	}

}
