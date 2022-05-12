package se.kth.salesystem.startup;

import se.kth.salesystem.controller.Controller;
import se.kth.salesystem.integration.AccountingSystem;
import se.kth.salesystem.integration.DiscountDatabase;
import se.kth.salesystem.integration.InventorySystem;
import se.kth.salesystem.view.View;

/**
 * Contains the <code>main</code> method. Performs all startup of the
 * application.
 */
public class Main {

	/**
	 * Starts the application.
	 * 
	 * @param args The application does not take any command line parameters.
	 */
	public static void main(String[] args) {
		AccountingSystem accountingSystem = new AccountingSystem();
		InventorySystem inventorySystem = new InventorySystem();
		DiscountDatabase discountDatabase = new DiscountDatabase();
		Controller controller = new Controller(accountingSystem, inventorySystem, discountDatabase);
		View view = new View(controller);
		view.mockExecution();
	}

}
