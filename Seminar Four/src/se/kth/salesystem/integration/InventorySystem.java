package se.kth.salesystem.integration;

import java.util.ArrayList;

import se.kth.salesystem.model.Sale;
import se.kth.salesystem.model.VAT;
import se.kth.salesystem.util.Amount;
import se.kth.salesystem.util.Quantity;

/**
 * A class that represents the external inventory system
 */
public class InventorySystem {
	private ArrayList<Item> items = new ArrayList<>();

	/**
	 * Creates a new instance of the inventory system.
	 * 
	 * @throws DatabaseNotRespondingException
	 */
	public InventorySystem() throws DatabaseNotRespondingException {
		addItems();
	}

	/**
	 * Returns the items present in the inventory system
	 * 
	 * @return items An ArrayList containing the items present
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * Checks if an item is present in the inventory system
	 * 
	 * @return boolean true if it is present and false if its not
	 * @throws ItemDoesNotExistException
	 */
	public boolean checkItemExists(Integer itemID) throws ItemDoesNotExistException {
		for (Item itemToCheckAgainst : items) {
			if (itemID.equals(itemToCheckAgainst.getItemID()))
				return true;
		}
		throw new ItemDoesNotExistException(itemID);
	}

	/**
	 * Checks if an item is present in the inventory system
	 * 
	 * @return boolean true if it is present and false if its not
	 * @throws ItemDoesNotExistException
	 */
	public Item getItem(Integer itemID) throws ItemDoesNotExistException {
		for (Item item : items) {
			if (itemID.equals(item.getItemID()))
				return item;
		}
		throw new ItemDoesNotExistException(itemID);
	}

	/**
	 * Updates the quantity of the items in the inventory system
	 * 
	 * @param sale The completed sale with purchased items
	 * @throws ItemDoesNotExistException
	 */
	public void updateInventorySystem(Sale sale) throws ItemDoesNotExistException {
		ArrayList<Item> itemsInSale = sale.getItems();
		for (Item item : itemsInSale) {
			if (checkItemExists(item.getItemID()))
				decreaseQuantity(item);
		}
	}

	/**
	 * Decreases the quantity of an item
	 */
	private void decreaseQuantity(Item item) {
		item.decreaseQuantity();
	}

	/**
	 * Adds items to the inventory system in order to be able to simulate a sale
	 */
	private void addItems() {
		items.add(new Item(new ItemDTO(new Amount(100), VAT.getVAT_Rate_12(), "Item 1"), 1, new Quantity(1)));
		items.add(new Item(new ItemDTO(new Amount(200), VAT.getVAT_Rate_12(), "Item 2"), 2, new Quantity(1)));
		items.add(new Item(new ItemDTO(new Amount(300), VAT.getVAT_Rate_6(), "Item 3"), 3, new Quantity(1)));
		items.add(new Item(new ItemDTO(new Amount(400), VAT.getVAT_Rate_6(), "ITem 4"), 4, new Quantity(1)));
	}

}
