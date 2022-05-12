package se.kth.salesystem.model;

import java.util.ArrayList;

import se.kth.salesystem.integration.InventorySystem;
import se.kth.salesystem.integration.Item;
import se.kth.salesystem.util.Amount;

/**
 * Represents a sale between a customer and a cashier.
 */
public class Sale {
	private Total total;
	private ArrayList<Item> items = new ArrayList<>();
	private InventorySystem inventorySystem;
	private ArrayList<SaleObserver> saleObservers = new ArrayList<>();

	/**
	 * Creates a new instance, represented as a Sale.
	 */
	public Sale(InventorySystem inventorySystem) {
		this.inventorySystem = inventorySystem;
		this.total = new Total(new Amount(0), new Amount(0), this);
	}

	/**
	 * Gets the ArrayList with the items.
	 * 
	 * @return The ArrayList with the items.
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * Gets the value of total.
	 * 
	 * @return The value of total.
	 */
	public Total getTotal() {
		return total;
	}

	public void increaseQuantity(Integer itemID) {
		for (Item item : items) {
			if (item.getItemID().equals(itemID)) {
				item.increaseQuantity();
				total.increaseAmount(item);
				total.increaseVAT(item);
			}
		}
	}

	/**
	 * Adds a new item to to sale list and updates total amount of the sale
	 * 
	 * @param item The item to be added
	 */
	public void addItem(Item item) {
		ArrayList<Item> inventoryItemList = inventorySystem.getItems();
		for (Item itemToCheckAgainst : inventoryItemList) {
			if (item.getItemID().equals(itemToCheckAgainst.getItemID())) {
				items.add(item);
			}
		}
		updateTotal();
	}

	/**
	 * Check if item is in the sales list or not
	 * 
	 * @param item The item to be checked
	 */
	public boolean checkItemQuantity(Item item) {
		for (Item itemToCheckAgainst : items) {
			if (itemToCheckAgainst.equals(item)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Prints the item in sales list
	 */
	public void printItems() {
		for (Item item : items) {
			item.toString();
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
	 * Increases the total amount and total VAT of the sale
	 */
	public void increaseTotal(Item item) {
		total.increaseAmount(item);
		total.increaseVAT(item);
	}

	/**
	 * Applies discount to a sale by decreasing the total amount
	 */
	public void applyDiscount() {
		total.decreaseAmount();
	}

	/**
	 * Ends the sale
	 */
	public void endSale() {
		notifyObservers();
	}

	/**
	 * Notifies the observers that a new total amount is available
	 */
	private void notifyObservers() {
		for (SaleObserver obs : saleObservers) {
			obs.newSale(total);
		}
	}

	/**
	 * Sets the sales observers to those declared in the Controller
	 */
	public void addSaleObservers(ArrayList<SaleObserver> obs) {
		saleObservers = obs;
	}

	/**
	 * Makes the instance into to a <code>String</code>
	 * 
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
