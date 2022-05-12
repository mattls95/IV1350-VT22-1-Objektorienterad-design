package se.kth.salesystem.integration;

import se.kth.salesystem.util.Amount;

/**
 * Represents the data of an item.
 */
public class ItemDTO {
	private Amount price;
	private double VATrate;
	private String name;

	/**
	 * Creates a new instance representing a particular item.
	 * 
	 * @param price   The price of the item.
	 * @param VATrate The Vat rate of an item.
	 * @param name    The name of the item.
	 */
	public ItemDTO(Amount price, double VATrate, String name) {
		this.price = price;
		this.VATrate = VATrate;
		this.name = name;
	}

	/**
	 * Get value of price.
	 * 
	 * @return the value of price.
	 */
	public Amount getPrice() {
		return price;
	}

	/**
	 * Get the VAT rate
	 * 
	 * @return the value VATrate
	 */
	public double getVATrate() {
		return VATrate;
	}

	/**
	 * Turns the instance into a <code>String</code>.
	 * 
	 * @return The instance as a <code>String</code>.
	 */
	@Override
	public String toString() {
		return "price = " + price.getAmount() + ", VATrate = " + VATrate + ", name = " + name;
	}

}
