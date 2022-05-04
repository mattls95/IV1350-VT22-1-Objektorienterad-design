package model;

import java.util.ArrayList;

import integration.Item;
import util.Amount;

/**
 *  Represents the total amount and the total amount with VAT
 */
public class Total {
	private Amount totalAmount;
	private Amount totalVat;
	private Sale sale;

	/**
     *  Creates a new instance, representing the total.
     *  @param totalAmount The total amount of the items excluding VAT
     *  @param totalVAT The total VAT of all items
     *  @param sale The sale that total concerns
     */
	public Total(Amount totalAmount, Amount totalVat, Sale sale) {
		this.totalAmount = totalAmount;
		this.totalVat = totalVat;
		this.sale = sale;
	}

	/**
     * Gets the value of total.
     * @return The value of total.
     */
	public Amount getTotalAmount() {
		return totalAmount;
	}
	
	 /**
     * Gets the value of totalVAT.
     * @return The totalVat.
     */
	public Amount getTotalVAT() {
		return this.totalVat;
	}

	/**
     * Calculates the total amount excluding VAT.
     * @return totalAmount The total amount.
     */
	public Amount calculateTotalAmount() {
		ArrayList<Item> items = sale.getItems();
		Item item = items.get(items.size() - 1);
		totalAmount.increaseAmount(item.getItemDescription().getPrice().getAmount());
		return totalAmount;
	}

	/**
     * Calculates the total VAT.
     * @return totalVat The total Vat 
     */
	public Amount calculateTotalVAT() {
		ArrayList<Item> items = sale.getItems();
		Item item = items.get(items.size() - 1);
		totalVat.multipleAmount(item.getItemDescription().getPrice().getAmount(), item.getItemDescription().getVATrate());
		return totalVat;

	}
	
	/**
     * Gets the value of total amount including VAT
     * @return a new amount with total amount
     */
	public Amount getTotalIncludingVAT() {
		return new Amount(totalAmount.getAmount() + totalVat.getAmount());
	}

	/**
     * Decreases the total amount with 100 
     * @return a new amount with the decreased amount
     */
	public Amount decreaseAmount() {
		totalAmount.decreaseAmount(100);
		return totalAmount;

	}

	/**
     * Makes the instance into to a <code>String</code>
     * @return The instance as a <code>String</code>
     */
	@Override
	public String toString() {
		return "Total: Total Amount = " + totalAmount.getAmount() + ", Total VAT = " + totalVat.getAmount();
	}

}
