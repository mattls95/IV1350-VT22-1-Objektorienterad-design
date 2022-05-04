package integration;

import java.time.LocalDateTime;
import java.util.HashMap;

import model.Sale;

/**
 * Represents an external accounting system which would call the actual system
 */
public class AccountingSystem {
	private HashMap<LocalDateTime, Sale> accounting = new HashMap<>();

	/**
     *  Creates a new instance of the accounting system
     */
	public AccountingSystem() {
	}
	
	/**
     * Adds the sale and time of the sale to the system.
     * @param sale The completed sale
     */
	public void updateAccountingSystem(Sale sale) {
		LocalDateTime saleTime = LocalDateTime.now();
		accounting.put(saleTime, sale);
	}
	

}
