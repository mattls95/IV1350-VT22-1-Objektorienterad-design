package model;

import java.util.ArrayList;

import integration.InventorySystem;
import integration.Item;
import util.Amount;

/**
 * Represents a sale between a customer and a cashier.
 */
public class Sale {
	private Total total;
	private ArrayList<Item> items = new ArrayList<>();
	private InventorySystem inventorySystem;

	 /**
     * Creates a new instance, represented as a Sale.
     */
	public Sale(InventorySystem inventorySystem) {
		this.inventorySystem = inventorySystem;
		this.total = new Total(new Amount(0), new Amount(0), this);
	}

	 /**
     * Gets the ArrayList with the items.
     * @return The ArrayList with the items.
     */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
     * Gets the value of total.
     * @return The value of total.
     */
	public Total getTotal() {
		return total;
	}

	public void increaseQuantity(Integer itemID) {
		for (Item item : items) {
			if (item.getItemID().equals(itemID))
				item.increaseQuantity();
		}
	}

	/**
     * Adds a new item to to sale list and updates total amount of the sale
     * @param item The item to be added
     */
	public void addItem(Item item) {
		ArrayList<Item> inventoryItemList = inventorySystem.getItems();
		for (Item itemToCheckAgainst : inventoryItemList) {
			if (item.getItemID().equals(itemToCheckAgainst.getItemID())) {
				items.add(item);
				System.out.println("Item Added");
			}

		}
		updateTotal();
	}
	
	/**
     * Prints the item in sales list
     */
	public void printItems() {
		for (Item item : items) {
			item.toString();
			System.out.println("\n");
		}
	}
	
	/**
     * Updates the total amount and total VAT of the sale
     */
	public void updateTotal() {
		total.calculateTotalAmount();
		total.calculateTotalVAT();
	}

	/**
     * Applies discount to a sale by decreasing the total amount
     */
	public void applyDiscount() {
		total.decreaseAmount();
	}

	/**
     * Makes the instance into to a <code>String</code>
     * @return The instance as a <code>String</code>
     */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Item item : items) {
			stringBuilder.append(item.toString() + "\n");
		}
		return stringBuilder.toString();
	}
	
	

}
