package se.kth.salesystem.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import se.kth.salesystem.integration.AccountingSystem;
import se.kth.salesystem.integration.DatabaseNotRespondingException;
import se.kth.salesystem.integration.DiscountDatabase;
import se.kth.salesystem.integration.InventorySystem;
import se.kth.salesystem.integration.Item;
import se.kth.salesystem.integration.ItemDoesNotExistException;
import se.kth.salesystem.model.CashRegister;
import se.kth.salesystem.model.Payment;
import se.kth.salesystem.model.Printer;
import se.kth.salesystem.model.Receipt;
import se.kth.salesystem.model.Sale;
import se.kth.salesystem.model.SaleObserver;
import se.kth.salesystem.model.Total;
import se.kth.salesystem.util.Amount;
import se.kth.salesystem.util.CustomerID;

/**
 * The Point-of-sale applications controller, all calls to the model is passed
 * through here.
 */
public class Controller {
	private Sale sale;
	private InventorySystem inventorySystem;
	private AccountingSystem accountingSystem;
	private DiscountDatabase discountDatabase;
	private CashRegister cashRegister;
	private Payment payment;
	private ArrayList<SaleObserver> saleObservers = new ArrayList<>();

	/**
	 * Creates a new instance of the controller
	 *
	 * @param accountingSystem Used to update the inventory system
	 * @param inventorySystem  Used to receive items and update the inventory system
	 * @param discountDatabase Used to check discount eligibility
	 */
	public Controller(AccountingSystem accountingSystem, InventorySystem inventorySystem,
			DiscountDatabase discountDatabase) throws DatabaseNotRespondingException {
		this.accountingSystem = accountingSystem;
		this.inventorySystem = inventorySystem;
		this.discountDatabase = discountDatabase;
		this.cashRegister = new CashRegister();
		this.payment = new Payment(cashRegister);
	}

	/**
	 * Initiates a new sale.
	 */
	public void startNewSale() {
		this.sale = new Sale(this.inventorySystem);
		sale.addSaleObservers(saleObservers);
	}

	/**
	 * If the item exist we will add it to the sale
	 * 
	 * @param itemID The item that will be added to the sale
	 * @return The item as a String
	 */
	public String registerItem(Integer itemID) throws ItemDoesNotExistException {
		inventorySystem.checkItemExists(itemID);
		addItem(itemID);
		return inventorySystem.getItem(itemID).toString();
	}

	/**
	 * If the item exist we will add it to the sale
	 * 
	 * @param itemID The item that will be added to the sale
	 * @return The item as a String
	 */
	public void addItem(Integer itemID) throws ItemDoesNotExistException {
		Item item = inventorySystem.getItem(itemID);
		if (sale.checkItemQuantity(item)) {
			sale.increaseQuantity(item.getItemID());
		} else
			sale.addItem(item);
	}

	/**
	 * Displays the total amount and VAT separately
	 * 
	 * @return The total including VAT as a String
	 */
	public String displayTotal() {
		Total total = sale.getTotal();
		return total.toString();

	}

	/**
	 * Checks whether a discount is possible
	 * 
	 * @param customerID which will be checked the discount database
	 * @return Answer with confirmation of discount given or not as a String
	 */
	public String checkDiscount(CustomerID customerID) {
		boolean discount = discountDatabase.checkDiscount(sale, customerID);
		if (discount == true) {
			return "Discount of 100 applied";
		}
		return "No discount eligble";
	}

	/**
	 * Makes a payment
	 * 
	 * @param amount the amount that the payment consists of
	 * @return the change from the payment as a String
	 */
	public String pay(Amount amount) {
		payment.makePayment(amount, sale.getTotal());
		return payment.getChange().getChange().toString();
	}

	/**
	 * Logs the sale and updates accounting and inventory systems
	 * 
	 * @throws ItemDoesNotExistException
	 */
	public void logSale() throws ItemDoesNotExistException {
		accountingSystem.updateAccountingSystem(sale);
		inventorySystem.updateInventorySystem(sale);
		sale.endSale();
	}

	/**
	 * prints the receipt and returns it as a String
	 * 
	 * @return the receipt as a String
	 */
	public String printReceipt() {
		Printer printer = new Printer();
		return printer.printReceipt(new Receipt(LocalDateTime.now(), sale, payment, payment.getChange()));
	}

	/**
	 * Adds an observer to the controller
	 */
	public void addSaleObserver(SaleObserver obs) {
		saleObservers.add(obs);
	}
}
