package se.kth.salesystem.model;

public class Printer {

	/**
	 * Represents a printer.
	 */
	public Printer() {
	}

	/**
	 * Prints the specified receipt
	 * 
	 * @param receipt The specified receipt that will be printed.
	 */
	public String printReceipt(Receipt receipt) {
		return receipt.toString();
	}

}
