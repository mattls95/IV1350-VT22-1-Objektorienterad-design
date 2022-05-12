package se.kth.salesystem.model;

import se.kth.salesystem.util.Amount;

/**
 * Represents the change of a completed sale.
 */
public class Change {
	private Amount change;

	public Change() {
		this.change = new Amount(0);
	}

	/**
	 * Calculates the change that is to be given to the customer
	 * 
	 * @return The change that is given to the customer
	 */
	public Amount calculateChange(Amount amount, Total total) {
		this.change.setAmount(amount.getAmount() - total.getTotalIncludingVAT().getAmount());
		return this.change;
	}

	/**
	 * Gets the value change
	 * 
	 * @return The value of change.
	 */
	public Amount getChange() {
		return change;
	}

	/**
	 * Turns the instance into a <code>String</code>.
	 * 
	 * @return The instance as a <code>String</code>.
	 */
	@Override
	public String toString() {
		return change.toString();
	}

}
