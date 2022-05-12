package se.kth.salesystem.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import se.kth.salesystem.model.Sale;
import se.kth.salesystem.model.SaleObserver;
import se.kth.salesystem.model.Total;

public class TotalRevenueFileOutput implements Logger, SaleObserver {
	private PrintWriter logStream;
	private File file;
	private Integer saleNumber = 0;
	private HashMap<Total, Integer> totalRevenueAndSaleNumber = new HashMap<>();
	private double totalRevenue;

	/**
	 * Creates a new instance and also creates a new log file. An existing log file
	 * will be deleted.
	 */
	public TotalRevenueFileOutput() {
		file = new File("C:\\Users\\matti\\eclipse-workspace\\Seminar Three\\logs\\log.txt");
		try {
			file.createNewFile();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		try {
			logStream = new PrintWriter(new FileWriter(file), true);
		} catch (IOException exception) {
			System.out.println("Can not log");
			exception.printStackTrace();
		}
	}

	/**
	 * Prints the specified string to the log file.
	 */
	@Override
	public void log() {
		logStream.println("Number of sales made: " + saleNumber + " Total Revenue: " + this.totalRevenue);
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
