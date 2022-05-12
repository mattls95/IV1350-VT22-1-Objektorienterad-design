package se.kth.salesystem.model;

public interface SaleObserver {
	/**
	 * Invoked when a sale ended.
	 *
	 * @param total The total amount of the sale
	 */
	void newSale(Total total);
}
