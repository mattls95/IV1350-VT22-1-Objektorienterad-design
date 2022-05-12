package se.kth.salesystem.model;

import se.kth.salesystem.util.Amount;

/**
 * Represents a cash register.
 */
public class CashRegister {
	private Amount balance;

	/**
	 * Creates a new instance of a cashregister with a balance of zero.
	 */
	public CashRegister() {
		this.balance = new Amount(0);
	}

	/**
     * Gets the value of balance.
     * @return The value of balance.
     */
	public Amount getBalance() {
		return balance;
	}

	/**
	 * Updates the balance with the specified payment.
	 * 
	 * @param payment The amount of cash that will be added to the balance of the
	 *                cash register.
	 */
	public void increaseBalance(Amount balance) {
		this.balance.increaseAmount(balance.getAmount());
	}

}
