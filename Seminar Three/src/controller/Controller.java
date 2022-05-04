package controller;

import java.time.LocalDateTime;

import integration.AccountingSystem;
import integration.DiscountDatabase;
import integration.InventorySystem;
import integration.Item;
import model.CashRegister;
import model.Payment;
import model.Printer;
import model.Receipt;
import model.Sale;
import model.Total;
import util.Amount;
import util.CustomerID;
import util.Quantity;

/**
 *  The Point-of-sale applications controller, all calls to the model is passed through here.
 */
public class Controller {
	private Sale sale;
	private InventorySystem inventorySystem;
	private AccountingSystem accountingSystem;
	private DiscountDatabase discountDatabase;
	private CashRegister cashRegister;
	private Payment payment;

	 /**
     * Creates a new instance of the controller
     *
     * @param accountingSystem   Used to update the inventory system
     * @param inventorySystem    Used to receive items and update the inventory system
     * @param discountDatabase   Used to check discount eligibility
     */
	public Controller(AccountingSystem accountingSystem, InventorySystem inventorySystem, DiscountDatabase discountDatabase) {
		this.accountingSystem = accountingSystem;
		this.inventorySystem = inventorySystem;
		this.discountDatabase = discountDatabase;
		this.cashRegister = new CashRegister();
		this.payment = new Payment(cashRegister);
	}

	/**
     *  Initiates a new sale.
     */
	public void startNewSale() {
		this.sale = new Sale(this.inventorySystem);
	}

	 /**
     *  If the item exist we will add it to the sale 
     * @param Item The item that will be added to the sale
     * @return The item as a String
     */
	public String registerItem(Item item) {
		if (inventorySystem.checkItemExists(item)) {
			sale.addItem(item);
			return item.toString();
		} else {
			return "Item does not exist";
		}
	}
	/**
     * Displays the total amount and VAT separately
     * @return The total including VAT as a String
     */
	public String displayTotal() {
		Total total = sale.getTotal();
		return total.toString();

	}
	
	/**
     * Checks whether a discount is possible 
     * @param customerID which will be checked the discount database
     * @return Answer with confirmation of discount given or not as a String
     */
	public String checkDiscount(CustomerID customerID) {
		boolean discount = discountDatabase.checkDiscount(sale, customerID);
		if(discount == true) {
			return "Discount of 100 applied";
		}
		return "No discount eligble";
	}

	/**
     * Makes a payment
     * @param amount the amount that the payment consists of
     * @return the change from the payment as a String
     */
	public String pay(Amount amount) {
		payment.makePayment(amount, sale.getTotal());
		return payment.getChange().getChange().toString();
	}

	/**
     * Logs the sale and updates accounting and inventory systems
     */
	public void logSale() {
		accountingSystem.updateAccountingSystem(sale);
		inventorySystem.updateInventorySystem(sale);
	}
	/**
     * prints the receipt and returns it as a String
     * @return the receipt as a String
     */
	public String printReceipt() {
		Printer printer = new Printer();
		return printer.printReceipt(new Receipt(LocalDateTime.now(), sale, payment, payment.getChange()));
	}
}
