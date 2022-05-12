package se.kth.salesystem.integration;

import se.kth.salesystem.util.Quantity;

/**
 * Represents an Item.
 */
public class Item {
	private ItemDTO itemDescription;
	private Integer itemID;
	private Quantity quantity;

	/**
	 * Creates a new instance, represented as an item.
	 * 
	 * @param itemDescription The description of an item.
	 * @param itemID          The identifier of an item.
	 * @param quantity        The amount if items.
	 */
	public Item(ItemDTO itemDescription, Integer itemID, Quantity quantity) {
		this.itemDescription = itemDescription;
		this.itemID = itemID;
		this.quantity = quantity;
	}

	/**
	 * Get the value of itemDescription.
	 * 
	 * @return itemDescription The value of itemDescription
	 */
	public ItemDTO getItemDescription() {
		return itemDescription;
	}

	/**
	 * Get the value of itemID.
	 * 
	 * @return itemID The value of itemID.
	 */
	public Integer getItemID() {
		return itemID;
	}

	/**
	 * Get the value of quantity.
	 * 
	 * @return quantity The value of quantity.
	 */
	public Quantity getQuantity() {
		return quantity;
	}

	/**
	 * Will increase the quantity of an item with 1
	 */
	public void increaseQuantity() {
		this.quantity.increaseQuantity();
	}

	/**
	 * Will decrease the quantity of an item with 1
	 */
	public void decreaseQuantity() {
		this.quantity.decreaseQuantity();
	}

	/**
	 * Turns instance into a <code>String</code>
	 * 
	 * @return The instance as a <code>String</code>
	 */
	@Override
	public String toString() {
		return "Item: " + itemDescription + ", itemID = " + itemID + ", quantity= " + quantity.getQuantity();
	}

}
