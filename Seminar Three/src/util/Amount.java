package util;

import model.Total;

/**
 * Represent the amount of something, like payment or change.
 * Something that need to be represented as a double
 */
public class Amount {
	private double amount;
	private double vatAmount;

	 /**
     * Creates an instance, representing the specified amount.
     * @param amount The amount represented by the created instance.
     */
	public Amount(double amount) {
		this.amount = amount;
	}

	/**
     * Get the value of amount.
     * @return The value of amount.
     */
	public double getAmount() {
		return amount;
	}

	/**
     * Set the value of amount.
     */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	 /**
     * Increases the amount
     * @param amount The amount to increase with
     * @return The sum of this objects amount and the parameter amount
     */
	public double increaseAmount(double amount) {
		return this.amount += amount;
	}

	 /**
     * Decreases the amount
     * @param amount The amount to decrease with
     * @return The difference of this objects amount and the parameter amount
     */
	public double decreaseAmount(double amount) {
		return this.amount -= amount;
	}

	/**
     * Multiplies the amount
     * @param amount The amount to multiply with
     * @return The difference of this objects amount and the parameter amount
     */
	public double multipleAmount(double amount, double vatRate) {
		return this.amount += vatRate * amount ;
	}

	/**
     * Makes the instance into to a <code>String</code>
     * @return The instance as a <code>String</code>
     */
	@Override
	public String toString() {
		return "Amount = " + amount;
	}

}
