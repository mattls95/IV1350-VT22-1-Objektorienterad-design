package se.kth.salesystem.view;

import se.kth.salesystem.controller.Controller;
import se.kth.salesystem.integration.DatabaseNotRespondingException;
import se.kth.salesystem.integration.Item;
import se.kth.salesystem.integration.ItemDTO;
import se.kth.salesystem.integration.ItemDoesNotExistException;
import se.kth.salesystem.model.VAT;
import se.kth.salesystem.util.Amount;
import se.kth.salesystem.util.CustomerID;
import se.kth.salesystem.util.DatabaseErrorGenerator;
import se.kth.salesystem.util.Quantity;
import se.kth.salesystem.util.TotalRevenueFileOutput;

import java.time.LocalDateTime;

import org.apache.logging.log4j.*;

/**
 * This application does not have an actual view. This class is a placeholder
 * for a view that can make a mock execution
 */
public class View {
	private Controller controller;
	private static Logger logger = LogManager.getLogger(View.class);

	/**
	 * Creates a new instance, represented as a view.
	 * 
	 * @param controller The class where all calls are being made from
	 */
	public View(Controller controller) {
		this.controller = controller;
	}

	/**
	 * Makes a mock execution of the application. Simulating someone making inputs
	 * to the application.
	 */
	public void mockExecution() {
		try {
			//DatabaseErrorGenerator.generateDatabaseException();
			controller.addSaleObserver(new TotalRevenueView());
			controller.addSaleObserver(new TotalRevenueFileOutput());

			/* SALE ONE */
			System.out.println("Cashier starts new sale.\n");
			controller.startNewSale();

			System.out.println("Cashier enter items.");
			String item = controller.registerItem(1);
			System.out.println(item);
			String total = controller.displayTotal();
			System.out.println(total + "\n");

			item = controller.registerItem(2);
			System.out.println(item);
			total = controller.displayTotal();
			System.out.println(total + "\n");

			item = controller.registerItem(3);
			System.out.println(item);
			total = controller.displayTotal();
			System.out.println(total + "\n");

			item = controller.registerItem(3);
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
			controller.logSale();

			/* SALE TWO */
			System.out.println("Cashier starts new sale.\n");
			controller.startNewSale();

			System.out.println("Cashier enter items.");
			String itemSale2 = controller.registerItem(1);
			System.out.println(itemSale2);
			String totalSale2 = controller.displayTotal();
			System.out.println(totalSale2 + "\n");

			itemSale2 = controller.registerItem(2);
			System.out.println(itemSale2);
			totalSale2 = controller.displayTotal();
			System.out.println(totalSale2 + "\n");

			itemSale2 = controller.registerItem(3);
			System.out.println(itemSale2);
			totalSale2 = controller.displayTotal();
			System.out.println(totalSale2 + "\n");

			System.out.println("Customer requests discount check");
			String discountSale2 = controller.checkDiscount(new CustomerID(1));
			System.out.println(discountSale2);
			totalSale2 = controller.displayTotal();
			System.out.println(totalSale2 + "\n");

			System.out.println("Customer makes payment\n");
			controller.pay(new Amount(1000));

			String receiptSale2 = controller.printReceipt();
			System.out.println(receiptSale2);
			controller.logSale();
			
			/* SALE THREE */
			System.out.println("Cashier starts new sale.\n");
			controller.startNewSale();

			System.out.println("Cashier enter items.");
			String itemSale3 = controller.registerItem(1);
			System.out.println(itemSale3);
			String totalSale3 = controller.displayTotal();
			System.out.println(totalSale3 + "\n");

			itemSale3 = controller.registerItem(2);
			System.out.println(itemSale3);
			totalSale3 = controller.displayTotal();
			System.out.println(totalSale3 + "\n");

			itemSale3 = controller.registerItem(4);
			System.out.println(itemSale3);
			totalSale3 = controller.displayTotal();
			System.out.println(totalSale3 + "\n");

			System.out.println("Customer requests discount check");
			String discountSale3 = controller.checkDiscount(new CustomerID(1));
			System.out.println(discountSale3);
			totalSale3 = controller.displayTotal();
			System.out.println(totalSale3 + "\n");

			System.out.println("Customer makes payment\n");
			controller.pay(new Amount(1000));

			String receiptSale3 = controller.printReceipt();
			System.out.println(receiptSale3);
			controller.logSale();
		} catch (DatabaseNotRespondingException exception) {
			logger.error("Database Connection Failed");
			System.out.println(exception.getMessage());
		} catch (ItemDoesNotExistException exception) {
			System.out.println(exception.getMessage());
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

}
