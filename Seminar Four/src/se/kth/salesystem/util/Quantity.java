package se.kth.salesystem.util;

/**
 * Represent the quantity of something, like items Something that can be
 * represented as a integer
 */
public class Quantity {
	private int quantity;

	/**
	 * Creates an instance, representing the specified quantity.
	 * 
	 * @param amount The quantity represented by the created instance.
	 */
	public Quantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Get the value of quantity.
	 * 
	 * @return The value of quantity.
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Decreases the quantity of 1
	 */
	public void decreaseQuantity() {
		this.quantity -= 1;
	}

	/**
	 * Increases the quantity of 1
	 */
	public void increaseQuantity() {
		this.quantity += 1;

	}
}
