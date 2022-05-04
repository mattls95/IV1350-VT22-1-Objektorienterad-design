package view;

import controller.Controller;
import integration.Item;
import integration.ItemDTO;
import model.VAT;
import util.Amount;
import util.CustomerID;
import util.Quantity;

/**
 * This application does not have an actual view.
 * This class is a placeholder for a view that can make a mock execution
 */
public class View {
	private Controller controller;

	 /**
     * Creates a new instance, represented as a view.
     * @param controller The class where all calls are being made from
     */
	public View(Controller controller) {
		this.controller = controller;
	}

	/**
     *  Makes a mock execution of the application.
     *  Simulating someone making inputs to the application.
     */
	public void mockExecution() {
		System.out.println("Cashier starts new sale.\n");
		controller.startNewSale();
		
		System.out.println("Cashier enter items.");
		String item = controller.registerItem(new Item(new ItemDTO(new Amount(100), VAT.getVAT_Rate_25(), "Item 1"), 1, new Quantity(1)));
		System.out.println(item);
		String total = controller.displayTotal();
		System.out.println(total + "\n");
		
		item = controller.registerItem(new Item(new ItemDTO(new Amount(200), VAT.getVAT_Rate_12(), "Item 2"), 2, new Quantity(1)));
		System.out.println(item);
		total = controller.displayTotal();
		System.out.println(total + "\n");
		
		item = controller.registerItem(new Item(new ItemDTO(new Amount(300), VAT.getVAT_Rate_6(), "Item 3"), 3, new Quantity(1)));
		System.out.println(item);
		total = controller.displayTotal();
		System.out.println(total + "\n");
		
		System.out.println("Customer requests discount check");
		String discount = controller.checkDiscount(new CustomerID(1));
		System.out.println(discount);
		total = controller.displayTotal();
		System.out.println(total + "\n");
		
		System.out.println("Customer makes payment\n");
		controller.pay(new Amount(1000));
		
		String receipt = controller.printReceipt();
		System.out.println(receipt);

	}
}
